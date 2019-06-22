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
public class day4 extends Fragment {
    ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.day1, container, false);
        lv = (ListView) view.findViewById(R.id.listView);
        String[] title = { "Fun Games", "Shutter Up", "Workshop", "Debate", "Brainathon", "AV Quiz", "Rampage",
                "Prize Distribution" };
        String[] desc = { "Lt Complex", "Facebook", "LT 21", "", "LT 21", "LT 21", "", "" };
        String[] time = { "All Day", "24x7", "9:00am", "2:00pm", "3:00pm", "4:15pm", "5:30pm", "" };
        int[] imgId = { R.drawable.informalsic, R.drawable.culturalic, R.drawable.technicalic, R.drawable.literaryic,
                R.drawable.technicalic, R.drawable.literaryic, R.drawable.informalsic, R.drawable.mologo };
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