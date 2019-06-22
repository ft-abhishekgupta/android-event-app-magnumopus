package com.ietkriti.abhishek.magnumopus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by abhishek on 18-07-2016.
 */
public class CustomAdp extends BaseAdapter {

    ArrayList<SingleRowData> dataSource;
    Context c;

    CustomAdp(Context context, ArrayList d) {
        c = context;
        dataSource = d;
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = li.inflate(R.layout.eventview, parent, false);
        ImageView image = (ImageView) row.findViewById(R.id.imageView22);
        TextView title = (TextView) row.findViewById(R.id.textView30);
        TextView time = (TextView) row.findViewById(R.id.textView31);
        TextView desc = (TextView) row.findViewById(R.id.textView32);
        SingleRowData rowdata = dataSource.get(position);
        image.setImageResource(rowdata.id);
        title.setText(rowdata.title);
        desc.setText(rowdata.desc);
        time.setText(rowdata.time);
        return row;
    }
}
