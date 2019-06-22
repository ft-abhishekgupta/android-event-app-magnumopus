package com.ietkriti.abhishek.magnumopus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by abhishek on 15-08-2016.
 */
public class team extends Fragment implements AdapterView.OnItemClickListener {
    ListView lv;
    static int xx = 0;
    static String namepass = "", numberpass = "";
    String phone[], title[], desc[];
    int[] imgId, imgId2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.team, container, false);
        getActivity().setTitle("Team");

        lv = (ListView) view.findViewById(R.id.listView3);
        title = new String[] { "Coordinators", "Rajat Kushwaha", "Garima Juneja", "Final Yr. Mentors", "Anchit Barnwal",
                "Dilasha Choudhary", "Cultural Heads", "Ritwik Mitra", "Devanshi Bansal", "Informal Heads",
                "Vaibhav Chauhan", "Gaurangi Katiyar", "Literary Heads", "Sarthak", "Akshita Sharma", "Technical Heads",
                "Om Prakash Dubey", "Namrata Raina", "Treasurer", "Akash Singh", "Team Members", "Abhishek Gupta",
                "Shubham Singhal", "Ayush Jain", "Ayush Rai", "Pushkar Srivastava", "Suvit Debbarma", "Shailesh Kumar",
                "Amrita Singh", "Muskan Rawat", "Sandhya Gautam", "Arti Jaiswal" };
        desc = new String[] { "--------------------------", "", "", "----------------------------------", "", "",
                "----------------------------", "", "", "-------------------------------", "", "",
                "----------------------------", "", "", "--------------------------------", "", "",
                "-------------------", "", "------------------------------", "", "", "", "", "", "", "", "", "", "",
                "" };
        phone = new String[] { "0", "+918853388512", "", "0", "", "", "0", "+918765505310", "", "0", "+919044512779",
                "", "0", "+919721515756", "", "0", "+918604563825", "", "0", "+918808032969", "0", "+918604620958",
                "+919084785533", "+919058124789", "+919161980495", "+918960508903", "+918794192730", "+918960978898",
                "", "", "", "" };
        imgId = new int[] { R.drawable.arrow, R.drawable.rajat, R.drawable.garima, R.drawable.arrow, R.drawable.anchit,
                R.drawable.dilasha, R.drawable.arrow, R.drawable.ritwik, R.drawable.devanshi, R.drawable.arrow,
                R.drawable.vaibhav, R.drawable.gaurangi, R.drawable.arrow, R.drawable.sarthak, R.drawable.akshita,
                R.drawable.arrow, R.drawable.om, R.drawable.blank, R.drawable.arrow, R.drawable.akash, R.drawable.arrow,
                R.drawable.abhishek, R.drawable.shubham, R.drawable.ayushjain, R.drawable.ayush, R.drawable.pushkar,
                R.drawable.suvit, R.drawable.shailesh, R.drawable.amrita, R.drawable.muskan, R.drawable.sandhya,
                R.drawable.arti };
        imgId2 = new int[] { R.drawable.arrow, R.drawable.rajat2, R.drawable.garima2, R.drawable.arrow,
                R.drawable.anchit2, R.drawable.dilasha2, R.drawable.arrow, R.drawable.ritwik2, R.drawable.devanshi2,
                R.drawable.arrow, R.drawable.vaibhav2, R.drawable.gaurangi2, R.drawable.arrow, R.drawable.sarthak2,
                R.drawable.akshita2, R.drawable.arrow, R.drawable.om2, R.drawable.aboutus, R.drawable.arrow,
                R.drawable.akash2, R.drawable.arrow, R.drawable.abhishek2, R.drawable.shubham2, R.drawable.ayushjain2,
                R.drawable.ayush2, R.drawable.pushkar2, R.drawable.suvit2, R.drawable.shailesh2, R.drawable.amrita2,
                R.drawable.muskan2, R.drawable.sandhya2, R.drawable.arti2 };

        ArrayList<SingleRowData> dataSource = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            SingleRowData s = new SingleRowData(imgId2[i], title[i], desc[i], phone[i]);
            dataSource.add(s);
        }
        CustomAdpteam adapter = new CustomAdpteam(view.getContext(), dataSource);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        namepass = title[position];
        numberpass = phone[position];
        xx = imgId[position];
        calldialog cd = new calldialog();
        if (!numberpass.equals("0"))
            cd.show(getActivity().getFragmentManager(), "My Custom Dialog");
    }
}
