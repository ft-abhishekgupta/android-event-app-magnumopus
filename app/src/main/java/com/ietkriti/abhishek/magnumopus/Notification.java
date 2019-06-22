package com.ietkriti.abhishek.magnumopus;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Notification extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        setTitle("Notifications");
        tv = (TextView) findViewById(R.id.textView14);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String s = sharedPref.getString("notif", "No data , Press GET");
        tv.setText(s);

    }

    public void mnotify(View view) {
        Toast.makeText(Notification.this, "Fetching Data...Please Wait...", Toast.LENGTH_LONG).show();
        new LoadTextFileTask(tv).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                "https://drive.google.com/uc?export=download&id=0B8XO8v084szyUTJFcGpEWTUydU0");
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("notif", tv.getText().toString());
        editor.commit();
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("k", true);
        startActivity(i);
    }
}

class LoadTextFileTask extends AsyncTask<String, Void, String> {
    private TextView txtView;

    public LoadTextFileTask(TextView txtView) {
        this.txtView = txtView;
    }

    protected String doInBackground(String... urls) {
        String url = urls[0];
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            if (con.getResponseCode() != 200)
                throw new IOException();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                response.append('\n');
            }
            in.close();
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(String text) {
        if (text != null) {
            txtView.setText(text);
        }
    }
}
