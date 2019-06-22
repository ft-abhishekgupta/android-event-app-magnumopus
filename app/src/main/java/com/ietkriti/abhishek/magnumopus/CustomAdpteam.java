package com.ietkriti.abhishek.magnumopus;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
public class CustomAdpteam extends BaseAdapter {

    ArrayList<SingleRowData> dataSource;
    Context c;
    String number[];

    CustomAdpteam(Context context, ArrayList d) {
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
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = li.inflate(R.layout.eventview2, parent, false);
        ImageView image = (ImageView) row.findViewById(R.id.imageView24);
        TextView title = (TextView) row.findViewById(R.id.textView39);
        ImageView call = (ImageView) row.findViewById(R.id.imageView23);
        TextView desc = (TextView) row.findViewById(R.id.textView40);
        number = new String[getCount()];
        SingleRowData rowdata = dataSource.get(position);
        image.setImageResource(rowdata.id);
        number[position] = rowdata.time;
        title.setText(rowdata.title);
        desc.setText(rowdata.desc);
        if (number[position].equals("0") || number[position].equals("")) {
            call.setVisibility(View.INVISIBLE);
            call.setClickable(false);
        }
        return row;
    }
}