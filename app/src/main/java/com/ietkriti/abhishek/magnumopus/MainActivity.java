package com.ietkriti.abhishek.magnumopus;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final int SPLASH_DISPLAY_LENGTH = 1000;
    int flag = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.INVISIBLE);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, new home()).commit();

        Intent i = getIntent();
        Boolean b = i.getBooleanExtra("k", true);
        if (b)
            fragmentManager.beginTransaction().replace(R.id.content_frame, new home()).commit();
        else
            fragmentManager.beginTransaction().replace(R.id.content_frame, new events()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (flag == 0) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_outb, R.anim.slide_inb);
            ft.replace(R.id.content_frame, new home(), "fragment");
            ft.commit();
            flag = 1;
        } else if (flag == 2) {
            flag = 0;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_outb, R.anim.slide_inb);
            ft.replace(R.id.content_frame, new events(), "fragment");
            ft.commit();
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    FragmentManager fragmentManager = getSupportFragmentManager();

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new home()).commit();
        } else if (id == R.id.events) {
            mevent(null);
        } else if (id == R.id.schedule) {
            finish();
            Intent i = new Intent(this, schedule.class);
            startActivity(i);
        } else if (id == R.id.notification) {
            mnotification(null);
        } else if (id == R.id.website) {
            mwebsite(null);
        } else if (id == R.id.youtube) {
            myoutube(null);
        } else if (id == R.id.facebook) {
            mfacebook(null);
        } else if (id == R.id.sponsors) {
            msponsors(null);
        } else if (id == R.id.team) {
            mteam(null);
        } else if (id == R.id.aboutus) {
            maboutus(null);
        } else if (id == R.id.contactus) {
            mcontactus(null);
        } else if (id == R.id.cultural) {
            mcultural(null);
        } else if (id == R.id.informals) {
            minformals(null);
        } else if (id == R.id.literary) {
            mliterary(null);
        } else if (id == R.id.technical) {
            mtechnical(null);
        } else if (id == R.id.map) {
            mmap(null);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static String FACEBOOK_URL = "https://www.facebook.com/ietkriti/";
    public static String FACEBOOK_PAGE_ID = "ietkriti";

    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) {
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else {
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL;
        }
    }

    public void mevent(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.slide_out, R.anim.slide_in);
        ft.replace(R.id.content_frame, new events(), "fragment");
        ft.commit();
        flag = 0;
    }

    public void mschedule(View view) {
        finish();
        Intent i = new Intent(this, schedule.class);
        startActivity(i);
    }

    public void mnotification(View view) {
        finish();
        Intent i = new Intent(this, Notification.class);
        startActivity(i);
    }

    public void mwebsite(View view) {
        String url = getString(R.string.website);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void msponsors(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.slide_out, R.anim.slide_in);
        ft.replace(R.id.content_frame, new sponsors(), "fragment");
        ft.commit();
        flag = 0;
    }

    public void mteam(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.slide_out, R.anim.slide_in);
        ft.replace(R.id.content_frame, new team(), "fragment");
        ft.commit();
        flag = 0;

    }

    public void maboutus(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.slide_out, R.anim.slide_in);
        ft.replace(R.id.content_frame, new about(), "fragment");
        ft.commit();
        flag = 0;
    }

    public void mcontactus(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.slide_out, R.anim.slide_in);
        ft.replace(R.id.content_frame, new contact(), "fragment");
        ft.commit();
        flag = 0;
    }

    public void mdeveloper(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fadein, R.anim.slide_in);
        ft.replace(R.id.content_frame, new developer(), "fragment");
        ft.commit();
        flag = 0;
    }

    public void mtechnical(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.slide_out, R.anim.slide_in);
        ft.replace(R.id.content_frame, new technicalevents(), "fragment");
        ft.commit();
        flag = 2;
    }

    public void mcultural(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.slide_out, R.anim.slide_in);
        ft.replace(R.id.content_frame, new culturalevents(), "fragment");
        ft.commit();
        flag = 2;
    }

    public void mliterary(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.slide_out, R.anim.slide_in);
        ft.replace(R.id.content_frame, new literaryevents(), "fragment");
        ft.commit();
        flag = 2;
    }

    public void minformals(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.slide_out, R.anim.slide_in);
        ft.replace(R.id.content_frame, new informalsevents(), "fragment");
        ft.commit();
        flag = 2;
    }

    public void mfacebook(View view) {
        Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
        String facebookUrl = getFacebookPageURL(this);
        facebookIntent.setData(Uri.parse(facebookUrl));
        startActivity(facebookIntent);
    }

    public void myoutube(View view) {
        String url = getString(R.string.youtube);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void mmap(View v) {
        String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 26.914285, 80.942500);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }
}