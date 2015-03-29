package com.myos.myos;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class StylistProfile extends Activity implements View.OnClickListener {

    private ResideMenu resideMenu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stylist_profile);

        RecyclerView recList = (RecyclerView) findViewById(R.id.stylistProfileCardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        StylistProfileAdapter ca = new StylistProfileAdapter(createList(30));
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
        getMenuInflater().inflate(R.menu.menu_stylist_profile, menu);
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

    private List<StylistProfileInfo> createList(int size) {

        List<StylistProfileInfo> result = new ArrayList<StylistProfileInfo>();

        // first salon
        StylistProfileInfo si1 = new StylistProfileInfo();
        si1.picture = R.drawable.aa;
        result.add(si1);

        // first salon
        StylistProfileInfo si2 = new StylistProfileInfo();
        si2.picture = R.drawable.bb;
        result.add(si2);

        // first salon
        StylistProfileInfo si3 = new StylistProfileInfo();
        si3.picture = R.drawable.cc;
        result.add(si3);

        // first salon
        StylistProfileInfo si4 = new StylistProfileInfo();
        si4.picture = R.drawable.dd;
        result.add(si4);

        // first salon
        StylistProfileInfo si5 = new StylistProfileInfo();
        si5.picture = R.drawable.ee;
        result.add(si5);

        StylistProfileInfo si6 = new StylistProfileInfo();
        si6.picture = R.drawable.ff;
        result.add(si6);

        return result;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }
}
