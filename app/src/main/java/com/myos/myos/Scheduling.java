package com.myos.myos;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import java.util.Calendar;


public class Scheduling extends Activity implements View.OnClickListener, CalendarView.OnDateChangeListener {

    CalendarView calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduling);

        initializeCalendar();

        Button selectButton = (Button) findViewById(R.id.select_button);
        selectButton.setOnClickListener(this);

        this.getActionBar().hide();
    }

    public void initializeCalendar(){
        calendar = (CalendarView) findViewById(R.id.calendarView);
        calendar.setShowWeekNumber(false);
        calendar.setFirstDayOfWeek(2);
        calendar.setOnDateChangeListener(this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scheduling, menu);
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
        Intent mIntent;

        switch (v.getId()){
            case R.id.select_button:
                mIntent = new Intent(this, Payment.class);
                startActivity(mIntent);
                break;
            default:
                break;
        }
    }

    long startMillis;

    @Override
    public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
        Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
        builder.appendPath("time");
        ContentUris.appendId(builder, startMillis);
        Intent intent = new Intent(Intent.ACTION_VIEW)
                .setData(builder.build());
        startActivity(intent);
    }
}
