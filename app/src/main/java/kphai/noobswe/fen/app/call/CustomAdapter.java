package kphai.noobswe.fen.app.call;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by k- on 5/15/2015.
 */
public class CustomAdapter extends BaseAdapter {

    private ViewHolder mViewHolder;
    Context context;
    private String[] topic;
    private String[] number;
    private int[] profile ;


    public CustomAdapter(Context context,String[] topic , String[] number, int[] profile ) {
        this.context = context;
        this.topic = topic;
        this.number = number;
        this.profile = profile;
    }

    @Override
    public int getCount() {
        return topic.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mViewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.customadapter_listview, parent, false);

            mViewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.txtname = (TextView) convertView.findViewById(R.id.txtShowname);
            mViewHolder.txtnumber = (TextView) convertView.findViewById(R.id.txtShownumber);



            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.imageView.setImageResource(profile[position]);
        mViewHolder.txtname.setText(topic[position]);
        mViewHolder.txtnumber.setText(number[position]);
        return convertView;
    }

    public class ViewHolder {
        ImageView imageView;
        TextView txtname;
        TextView txtnumber;
    }
}// End of Main Class-------------------------------------------------------------------------------
