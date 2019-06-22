package com.ietkriti.abhishek.magnumopus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by abhishek on 15-08-2016.
 */
public class culturalevents extends Fragment implements AdapterView.OnItemClickListener {
    ListView lv;
    static int xx = 0;
    static String namepass = "", numberpass = "";
    String phone[], title[], desc[];
    int[] imgId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.eventdesc, container, false);
        getActivity().setTitle("Cultural Events");

        lv = (ListView) view.findViewById(R.id.listView4);
        title = new String[] { "About Cultural Events", "Movie Maniacs", "Shutter Up", "Paper Fashionista",
                "INKcredible", "Soap Sculpture" };
        desc = new String[] {
                "Culture is the arts elevated to a set of beliefs. Cultural events promote one's identity and helps to connect with one's roots. Its time to exhibit your skills of drama, dance, music and arts in this amazing extravaganza of cultural events.",
                "A Bollywood Audio Visual Quiz consisting of two rounds Bollywood related questions will be asked on the projector & participants will write their answers on the sheet of paper which will be assessed by the judges. \n\nThe team with the max. correct answers will be selected for the 2nd round which is also an audio visual round.\n\n• Team members - 2.\n• Prize - Movie Tickets.\n• Entry fee - 20/- Rs.\n• Venue -  LT-21\n• Date -2 sept\n• Time – 5pm onwards",
                "A Selfie competition in which the participant will click his/her selfie at the time of KRITI fest and post it on KRITI's Facebook page. The person getting the max. likes will win the event.\n\nThis is a free event. This is a 4-day event which will keep going parallel with other events.\nThis is an Individual event.\nPrize - Selfie stick\nFB Page - www.facebook.com/ietkriti/",
                "A Paper dress making competition in which a team of min. 3 & max. 5 members will make a paper dress made up of newspapers & coloured papers for a team member ,who will then wear that dress and walk on the ramp with his /her team representing their dress.\n\n• Team  members-   3-5 members in a team\n• prize -  Cash prize(100/- Rs. per member)\n• Entry fee - 10/- Rs. per individual\n• Venue  -  LT-complex\n• Date  - 1 sept\n• Time - 5:30 pm onwards",
                "A Tattoo making competition consisting of two members in which a team member will make tattoo on his/her team member's wrist/hand. \n\nHetero teams are preferable and ink will be provided.\n\n• Team members - 2\n• Prize - Cash prize (200 /- Rs.)\n• Entry fee - 15/- Rs\n• Venue -  LT-Complex\n• Date -  3 sept\n• Time - 5:30 pm onwards",
                "A Soap carving event in which a soap will be provided and the team will have to carve that soap into different shapes and designs with the help of knife and toothpick.\n\n• Team members - 2 \n• Prize - Cash prize (200/- Rs.)\n• Entry fee - 15/- Rs.\n• Venue -  LT - 16\n• Date – 3 sept \n• Time - 2:30 pm onwards" };
        phone = new String[] { ">", ">", ">", ">", ">", ">" };
        imgId = new int[] { R.drawable.arrow, R.drawable.culturalic, R.drawable.culturalic, R.drawable.culturalic,
                R.drawable.culturalic, R.drawable.culturalic, R.drawable.culturalic, R.drawable.culturalic,
                R.drawable.culturalic };
        ArrayList<SingleRowData> dataSource = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            SingleRowData s = new SingleRowData(imgId[i], title[i], desc[i], phone[i]);
            dataSource.add(s);
        }
        CustomAdpevent adapter = new CustomAdpevent(view.getContext(), dataSource);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Animation b = AnimationUtils.loadAnimation(view.getContext(), R.anim.fadein);
        TextView t = (TextView) view.findViewById(R.id.textView33);
        TextView t2 = (TextView) view.findViewById(R.id.textView34);
        t.setText(desc[position]);
        if (t.getVisibility() == View.INVISIBLE) {
            t.startAnimation(b);
            t.setVisibility(View.VISIBLE);
            t2.setText("<");
        } else if (t.getVisibility() == View.VISIBLE) {
            t.setVisibility(View.INVISIBLE);
            t.setText("");
            t2.setText(">");
        }
    }
}
