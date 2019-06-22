package com.ietkriti.abhishek.magnumopus;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by abhishek on 09-07-2016.
 */
public class calldialog extends DialogFragment implements DialogInterface.OnClickListener {
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.callpic, null, false);
        builder.setView(v);

        if (!team.numberpass.equals("")) {
            builder.setPositiveButton("CALL", this);
            builder.setNegativeButton("SMS", this);
        }

        AlertDialog dialog = builder.create();
        dialog.show();
        TextView t = (TextView) dialog.findViewById(R.id.textView41);
        if (!team.numberpass.equals(""))
            t.setText(team.namepass + "\n" + team.numberpass);
        else
            t.setText(team.namepass);
        ImageView ii = (ImageView) dialog.findViewById(R.id.imageView25);
        ii.setImageResource(team.xx);

        return dialog;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == -2) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", team.numberpass, null)));

        } else {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + team.numberpass));
            startActivity(intent);
        }
    }
}
