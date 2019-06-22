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
public class informalsevents extends Fragment implements AdapterView.OnItemClickListener {
    ListView lv;
    static int xx = 0;
    static String namepass = "", numberpass = "";
    String phone[], title[], desc[];
    int[] imgId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.eventdesc, container, false);
        getActivity().setTitle("Informal Events");
        lv = (ListView) view.findViewById(R.id.listView4);
        title = new String[] { "About Informal Events", "Kritsvilla", "Scavenger Hunt", "Tambola", "Rampage",
                "Fun Games" };
        desc = new String[] {
                "Gear up for the most exhilarating section of Magnum Opus 2K16 . Show off your informal side and leave everyone spellbound. The breath taking events of informals will leave you enthralled. Get a little wild the perpetual piercing sensation of your hair-raising events. You will have no other way out except to be electrified.",
                "A challenge to be on stage\nTo win the crown of fame\nAll you need is a bit of courage\n\nRules:\n1.The game is to be played individually.\n2.The game contains various interesting rounds like Personal Interview, Treasure hunt, Just a minute etc.\n3.Come and explore more….\n\nEntry Fee: Rs 20/-\n\nPrizes: Movie tickets for winners and the title of Miss Kriti and Mr. Kriti\n\nDate - 1st Sept\nTime - 5:30pm start",
                "The game is all about getting 30 items in 30 minutes back to the starting point.\n\nRules:\n1.The game should be played in a team of minimum 4 and maximum 5 members.\n2.The list of items will be provided on the spot.\n3.In case two teams collect same number of items then preference will be given to the team which gets back first.\n\nEntry fees: Rs 15/- per member\n\nPrizes: Cash prize for winning team.\n\nDate - 3rd Sept\nTime - 1:30pm\nVenue - LT-21",
                "Tambola is a fun game in which random numbers are called out. Players are provided a card of random. Players have to strike numbers off their card as they are called and the objective is to either strike a full line or a full card.\n\nEntry fees: Rs 10/- \n\nPrizes: Exciting prizes.\n\nDate - 1st Sept\nTime - 4:45pm\nVenue - LT-21",
                "It’s a simple Ramp-Walking event.\n\nRules:\nParticipants have to be dressed up either in Western or Ethnic outfits.\n\nEntry fees: Rs 10/- \n\nPrizes: Exciting prizes for winners and the title of Miss Iconic and Mr. Iconic\n\nDate - 4th Sept\nTime - 5:30pm",
                "Challenging but exciting..\nThrilling but amazing..\nFunny n amusing..\nThe fun games are waiting...\n\nDate - 1,2,3,4 Sept\nVenue - LT Complex\nTime - All Day" };
        phone = new String[] { ">", ">", ">", ">", ">", ">" };
        imgId = new int[] { R.drawable.arrow, R.drawable.informalsic, R.drawable.informalsic, R.drawable.informalsic,
                R.drawable.informalsic, R.drawable.informalsic };
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