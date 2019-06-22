package com.ietkriti.abhishek.magnumopus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by abhishek on 15-08-2016.
 */
public class day1 extends Fragment {
    ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.day1, container, false);
        lv = (ListView) view.findViewById(R.id.listView);
        String[] title = { "Inauguration", "Fun Games", "Shutter Up", "LAN Gaming", "Kritsvilla", "Tambola",
                "Paper Fashionista" };
        String[] desc = { "LT 11", "Lt Complex", "Facebook", "Lt Complex", "", "LT 21", "LT Complex" };
        String[] time = { "3:30pm", "4:30pm", "24x7", "4:30pm", "5:30pm", "4:45pm", "5:30pm" };
        int[] imgId = { R.drawable.notification, R.drawable.informalsic, R.drawable.culturalic, R.drawable.technicalic,
                R.drawable.informalsic, R.drawable.informalsic, R.drawable.culturalic };
        ArrayList<SingleRowData> dataSource = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            SingleRowData s = new SingleRowData(imgId[i], title[i], desc[i], time[i]);
            dataSource.add(s);
        }
        CustomAdp adapter = new CustomAdp(view.getContext(), dataSource);
        lv.setAdapter(adapter);
        return view;
    }
}

class SingleRowData {
    int id;
    String title;
    String desc;
    String time;

    SingleRowData(int i, String t, String d, String ti) {
        id = i;
        title = t;
        desc = d;
        time = ti;
    }
}
