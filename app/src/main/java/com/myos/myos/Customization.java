package com.myos.myos;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class Customization extends Activity implements View.OnClickListener {
    private int currentImage = 0;
    private ResideMenu resideMenu = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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


        setContentView(R.layout.activity_customization);

        final ImageView v = (ImageView) findViewById(R.id.userPicture);
        final ImageView barberIV = (ImageView) findViewById(R.id.barberIV);
        barberIV.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                    switch (currentImage) {
                        case 0: {
                            v.setImageResource(R.drawable.gg);
                            currentImage = 1;
                            break;
                        }
                        case 1: {
                            v.setImageResource(R.drawable.hh);
                            currentImage = 2;
                            break;
                        }
                        case 2: {
                            v.setImageResource(R.drawable.aa);
                            currentImage = 0;
                            break;
                        }
                    }
                }
                return true;
            }
        });
        ( (Button)findViewById(R.id.proceed)).setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_customization, menu);
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

    @Override
    public void onClick(View v) {
        Intent mIntent = new Intent(this, Payment.class);
        startActivity(mIntent);

    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }
}
