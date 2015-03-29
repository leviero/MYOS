package com.myos.myos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class SalonProfile extends Activity implements View.OnClickListener, View.OnTouchListener {
    private ResideMenu resideMenu = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my);

        setContentView(R.layout.activity_salon_profile);
        RecyclerView recList = (RecyclerView) findViewById(R.id.salonProfileCardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        recList.setOnTouchListener(this);
        // attach to current activity;
        resideMenu = new ResideMenu(this);
        resideMenu.attachToActivity(this);

        // create menu items;
        String titles[] = { "Home", "Profile", "Calendar", "Settings" };
        int icon[] = { R.drawable.icon_home, R.drawable.icon_profile, R.drawable.icon_calendar, R.drawable.icon_settings };

        for (int i = 0; i < titles.length; i++){
            ResideMenuItem item = new ResideMenuItem(this, icon[i], titles[i]);
            item.setOnClickListener(this);
            if(i % 2 == 0) {
                resideMenu.addMenuItem(item, ResideMenu.DIRECTION_LEFT); // or  ResideMenu.DIRECTION_RIGHT
            }
            else{
                resideMenu.addMenuItem(item, ResideMenu.DIRECTION_RIGHT);
            }
        }

        SalonProfileAdapter ca = new SalonProfileAdapter(createList(30));
        recList.setAdapter(ca);

        this.getActionBar().hide();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_salon_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<SalonProfileInfo> createList(int size) {

        List<SalonProfileInfo> result = new ArrayList<SalonProfileInfo>();
        // first salon
        SalonProfileInfo si1 = new SalonProfileInfo();
        si1.name = "Alison Lau Wai Ha";
        si1.recommendation = "50 people";
        si1.review = "30 people";
        si1.picture = R.drawable.stylist;
        result.add(si1);

        // first salon
        SalonProfileInfo si2 = new SalonProfileInfo();
        si2.name = "Charles Kim Mak";
        si2.recommendation = "24 people";
        si2.review = "6 people";
        si2.picture = R.drawable.b1;
        result.add(si2);

        // first salon
        SalonProfileInfo si3 = new SalonProfileInfo();
        si3.name = "Sammy Tang Wan Wui";
        si3.recommendation = "22 people";
        si3.review = "Coming Soon!";
        si3.picture = R.drawable.b2;
        result.add(si3);

        // first salon
        SalonProfileInfo si4 = new SalonProfileInfo();
        si4.name = "Tim Ho Wan";
        si4.recommendation = "20 people";
        si4.review = "3 people";
        si4.picture = R.drawable.b3;
        result.add(si4);

        // first salon
        SalonProfileInfo si5 = new SalonProfileInfo();
        si5.name = "Michael Cung Kit Ha";
        si5.recommendation = "15 people";
        si5.review = "2 people";
        si5.picture = R.drawable.b4;
        result.add(si5);

        SalonProfileInfo si6 = new SalonProfileInfo();
        si6.name = "Edison Fung Ho Yin";
        si6.recommendation = "12 people";
        si6.review = "5 people";
        si6.picture = R.drawable.b5;
        result.add(si6);

        return result;
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            Intent mIntent = new Intent(this, Customization.class);
            startActivity(mIntent);
        }
        return false;
    }

    @Override
    public void onClick(View v) {

    }
}
