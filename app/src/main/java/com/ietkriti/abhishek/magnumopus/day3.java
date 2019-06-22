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
public class day3 extends Fragment {
    ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.day1, container, false);
        lv = (ListView) view.findViewById(R.id.listView);
        String[] title = { "Fun Games", "LAN Gaming", "Shutter Up", "Scavenger Hunt", "Soap Sculpture",
                "Group Discussion", "scanf();", "INKcredible", "TechQuila" };
        String[] desc = { "Lt Complex", "Lt Complex", "Facebook", "LT 21", "LT 16", "", "LT 21", "LT Complex",
                "CS Lab" };
        String[] time = { "All Day", "All Day", "24x7", "1:00pm", "2:30pm", "3:30pm", "4:30pm", "5:30pm", "6:30pm" };
        int[] imgId = { R.drawable.informalsic, R.drawable.technicalic, R.drawable.culturalic, R.drawable.informalsic,
                R.drawable.culturalic, R.drawable.literaryic, R.drawable.literaryic, R.drawable.culturalic,
                R.drawable.technicalic };
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