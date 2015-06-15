package kphai.noobswe.fen.app.call;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends ActionBarActivity {

    private ListView listView;
    private CustomAdapter customAdapter;

    private final static String[] topic = {
            "ອາຈານ ສົມພອນ ກັນທະວົງ",
            "ອາຈານ ທາ ບຸນທັນ",
            "ອາຈານ ເສີມສັກ ດວງສິລາ",
            "ກ",
            "ກ",
            "ກ",
            "ກ",
            "ກ",
            "ກ",
            "ກ",
            "ກ",
            "ກ",
            "ກ",
            "ກ",
            "ກ"};
    private final static String[] number = {
            "+8562055938276",
            "+8562055888117",
            "+8562055415771",
            "+85620",
            "+8520" ,
            "+85620",
            "+85620",
            "+85620",
            "+85620",
            "+85620",
            "+8520" ,
            "+85620",
            "+85620",
            "+85620",
            "+85620"};
    private final static int[] profile = {
            R.mipmap.ic_match1,
            R.mipmap.ic_match2,
            R.mipmap.ic_match3,
            R.mipmap.ic_match4,
            R.mipmap.ic_match5,
            R.mipmap.ic_match6,
            R.mipmap.ic_match7,
            R.mipmap.ic_match8,
            R.mipmap.ic_match9,
            R.mipmap.ic_match4,
            R.mipmap.ic_match5,
            R.mipmap.ic_match6,
            R.mipmap.ic_match7,
            R.mipmap.ic_match8,
            R.mipmap.ic_match9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayShowHomeEnabled(true);
        //actionBar.setIcon(R.mipmap.icon_call);


        listView = (ListView) findViewById(R.id.listNumber);
        customAdapter = new CustomAdapter(getApplicationContext(), topic, number, profile);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("ເຈົ້າຕ້ອງການໂທເບີນີ້ບໍ່ ?");
                builder.setMessage(topic[position]+ "_" + number[position]);
                builder.setCancelable(false);
                builder.setIcon(R.mipmap.ic_action_call);

                builder.setPositiveButton("[ໂທລະເນາະ]", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                        phoneIntent.setData(Uri.parse("tel:" + number[position]));
                                startActivity(phoneIntent);
                    }
                });
                builder.setNegativeButton("[ບໍ່ໂທແລະ]", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });

    } // end of OnCreate----------------------------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            startActivity(new Intent(this, About.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

        private long backPressedTime = 0;
    @Override
    public void onBackPressed() {        // to prevent irritating accidental logouts
        long t = System.currentTimeMillis();
        if (t - backPressedTime > 2000) {    // 3 secs
            backPressedTime = t;
            Toast.makeText(this, "Press back again to exit",
                    Toast.LENGTH_SHORT).show();
        } else {    // this guy is serious
            // clean up
            super.onBackPressed();       // bye
        }
    } // end of onBackPressed-----------------------------------------------------------------------

} //end of Main Class-------------------------------------------------------------------------------
