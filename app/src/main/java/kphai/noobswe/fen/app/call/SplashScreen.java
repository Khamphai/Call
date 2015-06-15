package kphai.noobswe.fen.app.call;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;


public class SplashScreen extends ActionBarActivity {

    Handler objHandler;
    Runnable objRunable;
    Long Delay_time;
    Long Time = 2000L; // set time up in 3 second


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);


        objHandler = new Handler();

        // intent from startActivity to MainActivity
        objRunable = new Runnable() {
            @Override
            public void run() {
                Intent objIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(objIntent);
                finish();
            }
        };

    }   // End of OnCreate--------------------------------------------------------------------------

    // set it on press Back Button or Home button
    @Override
    protected void onResume() {
        super.onResume();

        Delay_time = Time;
        objHandler.postDelayed(objRunable, 2000);
        Time = System.currentTimeMillis();

    }


    @Override
    protected void onPause() {
        super.onPause();

        objHandler.removeCallbacks(objRunable);
        Time = Delay_time - (System.currentTimeMillis() - Time);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



} // end of Main Class------------------------------------------------------------------------------
