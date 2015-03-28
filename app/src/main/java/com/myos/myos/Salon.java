package com.myos.myos;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;


public class Salon extends Activity implements View.OnClickListener {
    private ResideMenu resideMenu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my);
        setContentView(R.layout.activity_salon);
        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        recList.setOnClickListener(this);
        SalonAdapter ca = new SalonAdapter(createList(30));
        recList.setAdapter(ca);


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


        this.getActionBar().hide();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_salon, menu);
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

    private List<SalonInfo> createList(int size) {

        List<SalonInfo> result = new ArrayList<SalonInfo>();
        // first salon
        SalonInfo si1 = new SalonInfo();
            si1.name = "Mega Hair";
            si1.location = "HKUST";
            si1.priceRange = "HKD50 - HKD100";
        si1.picture = R.drawable.mega_hair;
            result.add(si1);

        // first salon
        SalonInfo si2 = new SalonInfo();
        si2.name = "QB House";
        si2.location = "Hang Hau";
        si2.priceRange = "HKD50 - HKD100";
        si2.picture = R.drawable.qb;
        result.add(si2);

        // first salon
        SalonInfo si3 = new SalonInfo();
        si3.name = "Mandarin House";
        si3.location = "Tsim Sha Tsui";
        si3.priceRange = "HKD200 - HKD300";
        si3.picture = R.drawable.mandarin;
        result.add(si3);

        // first salon
        SalonInfo si4 = new SalonInfo();
        si4.name = "Gentleman's Tonic";
        si4.location = "Central";
        si4.priceRange = "HKD500 - HKD900";
        si4.picture = R.drawable.gentlemen;
        result.add(si4);

        // first salon
        SalonInfo si5 = new SalonInfo();
        si5.name = "Salon Nova";
        si5.location = "Central";
        si5.priceRange = "HKD200 - HKD300";
        si5.picture = R.drawable.sn;
        result.add(si5);

        SalonInfo si6 = new SalonInfo();
        si6.name = "Tony & Guy";
        si6.location = "Central";
        si6.priceRange = "HKD200 - HKD300";
        si6.picture = R.drawable.tg;
        result.add(si6);

        return result;
    }

    @Override
    public void onClick(View v) {
        Intent mIntent = new Intent(this, Salon.class);
        startActivity(mIntent);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }
}
