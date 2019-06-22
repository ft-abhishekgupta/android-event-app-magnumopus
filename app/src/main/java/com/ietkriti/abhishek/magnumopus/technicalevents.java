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
public class technicalevents extends Fragment implements AdapterView.OnItemClickListener {
    ListView lv;
    static int xx = 0;
    static String namepass = "", numberpass = "";
    String phone[], title[], desc[];
    int[] imgId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.eventdesc, container, false);
        getActivity().setTitle("Technical Events");

        lv = (ListView) view.findViewById(R.id.listView4);
        title = new String[] { "About Technical Events", "Brainathon", "Code Wars", "TechQuila", "Workshop",
                "LAN Gaming", "Counter Strike 1.6", "Pocket Tanks", "Tekken 3", "Fifa 14" };
        desc = new String[] {
                "Living in the arena of binary codes sustaining the pain of compilation errors, planning for the better plan execution of the thrilling brain we coders...the coders of the Magnum Opus 2K16 welcome you in the new class of public with the comforts of static private class. Welcome to techno-tech world of technology.",
                "Outwit! Outplay! Outlast!\n\nFlex your brain muscles, dig into the grey matter and get ready for the battle of brains. \n\nSolve some exciting brain teasers and then indulge in the thrill of riddles pointing to a location in college. \n\nBe a part of brainathon, put your thinking caps on… \n\nRules:-\n1.  Time: 1 hour\n2.  Team of three\n3.  Brain teasers will be given to you. After solving the teaser you will be provided with a clue pointing to a location in the college. You need to click picture of the spot and return.\n4.  +5 marks will be awarded for solving the teaser and +3 for getting correct picture of the spot described in the clue.\n5.  Winner and runner up will be decided on the basis of scores at the end of one hour.\n6.  All the team members must be present at the end of one hour otherwise team will be disqualified.\n\nDate - 4th Sept\nTime - 3:00pm\nVenue - LT 21",
                "Welcome to C Arena. Each event is preceded by a prophecy, without a hero there is no event. \n\nDo you have what it takes to be a C KING. \n\nWelcome to Code Wars.\n\nRules:-\n1. Two round contest.\n2. No entry fees.\n3. Online 12 hour contest on hacker rank link would be provided later.\n4. Selected student will goes to final round.\n5. Final round will held in some LTs offline.\n6. Winners will be awarded certificate and cash prize of 500Rs.\n\nNOTE - Date will be notified",
                "Techies welcome to TechQuila!! Show your love for the new tech and tackle exciting questions. \n\nAre you upto the challenge ?\n\n1. Online contest will held in CSE lab.\n2. Quiz will be of one hour.\n3. Only one round\n4. Questions will be based on technology\n5. Winners will be awarded certificate and cash prize of 200Rs.\n6. Entry fee is 10 rs\n\nVENUE - Computer Lab\nTIMING - FROM 6:30 P.M\nDate - 3 September",
                "A workshop on Web Development to help you out.\n\nAn event organised for you to hone your skills. \nGain as much as you can.\n\n1. Entry fee=300(including CSE)\n2. Certificate of participation will be given on the same day\n3. Workshop will be of following topic:-HTML,CSS,JAVASCRIPT,JQUERY,BOOTSTRAP, PHP, SQL\n4. Workshop will be of 5 hour (one break will also be provided)\n5. Workshop will be on 4th September at 9:00am.\n\nVENUE - LT-21\nTIMING - \n\t9am to 1pm\nDATE - 4th September",
                "Play good!! Play bad!! Play god!!\n\nA gathering in which gamers(devotees of computer games) will gather to share a local area network(LAN) and participate in extended gaming sessions of popular games.\nThe more you play harder it gets. Welcome to the Gamers zone . \n\nDescription of individual games is given below...\n\nDate - 1,2,3 Sept.\nTime - All time during fest\nVenue - LT Complex 1st floor",
                "•\t2 Team  consisting of 5 member each.\n•\tStarting money will be 800$.\n•\t11 round match.\n•\t3 minutes per round.\n•\tKnife match for choosing counter terrorist or terrorist.\n•\tMaps: de_dust2, de_nuke, de_inferno.\n•\tTeam reverse after 6round.\n•\tSniper rifles are not allowed.\n•\tWinner team will be  selected by best of 11 round.\n•\tEntry Fees: Rs.50 Per team.\n\nVenue - LT complex                \nTiming - from 4:30 P.M\nDate - 1,2,3 September",
                "1. 2 Teams  1 player each.\n2. Number  of turn in a match=10\n3. Knockout match\n4. Reentry is allowed\n5. Spot entry allowed\n6. Entry fee=10\n7. Exciting prizes and certificate\n\nTIMING - FROM 4:30 P.M\nDate - 1,2,3 Sept\nVENUE - LT-12",
                "1. 2 teams 1 member each.\n2. Best of 3 round\n3. Knockout match\n4. Reentry is allowed\n5. Spot entry allowed\n6. Entry fee=10\n7. Attractive prizes and certificate\n\nVENUE - LT -12\nTIMING - FROM 4:30 P.M\nDate - \n\t1,2,3 September",
                "1. 2 teams 1 player  each\n2. Entry fee =20 \n3. Length of half time will be 4 minutes.\n4. Knockout match.\n5. Reentry is allowed.\n6. Spot entry allowed.\n7. Exciting prizes and certificate.\n\nVENUE - LT 12\nTIMING - FROM 4:30P.M\nDate - 1st,2nd,3rd September" };
        phone = new String[] { ">", ">", ">", ">", ">", ">", ">", ">", ">", ">" };
        imgId = new int[] { R.drawable.arrow, R.drawable.technicalic, R.drawable.technicalic, R.drawable.technicalic,
                R.drawable.technicalic, R.drawable.technicalic, R.drawable.technicalic, R.drawable.technicalic,
                R.drawable.technicalic, R.drawable.technicalic };
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