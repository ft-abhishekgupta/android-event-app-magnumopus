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
public class literaryevents extends Fragment implements AdapterView.OnItemClickListener {
    ListView lv;
    static int xx = 0;
    static String namepass = "", numberpass = "";
    String phone[], title[], desc[];
    int[] imgId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.eventdesc, container, false);
        getActivity().setTitle("Literary Events");

        lv = (ListView) view.findViewById(R.id.listView4);
        title = new String[] { "About Literary Events", "AV Quiz", "scanf();", "Group Discussion", "Wordament" };
        desc = new String[] {
                "Welcome to the most sophisticated event of the fest- Literary. Like never before, with new events, we present a totally revolutionized literary group. Get ready to be surprised and gear up to surprise us all with your literary skills.",
                "Multiple choice questions will be projected on projector which will be based on general knowledge . \n\nTeams answering maximum correct answers will be selected for next round and winners will be decided   accordingly.\n\nDate:- September 4\nVenue - LT-21\nTime:- 4:15-5:15pm\nTeam Member:-2\nEntry Fees:-Rs 10\nPrize:- Exciting Cash Prize",
                "As the name suggests, participants have to scan the answers of given question from an article which will be provided to them within a limited period of time. Contestants will have to scan the answers. \n\nTeam with maximum correct answer will be declared as winner.\n\nDate:- September 3\nVenue - LT 21\nTime:- 4:30-5:15pm\nTeam Member:-2\nEntry fees:- Rs 10\nPrize:- Exciting Cash Prize ",
                "A single group discussion would involve a group of six. \n\nThe Executive board shall judge the group and individuals on their constructive nature and flow of discussion. \n\nThe individuals qualified shall move on to the final round of a general debate whose topic agenda will be disclosed to the finalists itself.\n\nDate:- September 4\nVenue - LT 21\nTime:- 2-3pm\nTeam Member:- 1\nEntry fees:- Free\nPrize:- Exciting Prizes ",
                "As the name  suggest its a word puzzle game . It is divided into three rounds. \n\nIn first round participants will have to frame maximum number of words possible using the given string and accordingly few will be selected for next round. \n\nIn second round participants will be provided a set of questions and they will have to frame answers from the given string. Contestants giving maximum correct answers will be promoted to the final round.\n\nFinal round will be based on ‘SPELLATHON’, a highly addictive fun word twist game. In this contestants will have to find words that will satisfy the  conditions given. Finally the winner of this round will be the winner of the event.\n\nQualifying Round\n  Date:- September 3\n  Time:- 3:30pm-4:30pm\nFinal Round\n  Date:- September 4\n  Time:- 2-3pm\nTeam Member:1\nFees: Rs 10\nPrize:- Exciting Cash Prize " };
        phone = new String[] { ">", ">", ">", ">", ">", ">" };
        imgId = new int[] { R.drawable.arrow, R.drawable.literaryic, R.drawable.literaryic, R.drawable.literaryic,
                R.drawable.literaryic, R.drawable.literaryic, R.drawable.literaryic, R.drawable.literaryic,
                R.drawable.literaryic };
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