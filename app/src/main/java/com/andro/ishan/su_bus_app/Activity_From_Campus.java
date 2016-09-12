package com.andro.ishan.su_bus_app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

/**
 * Created by Ishan on 8/8/2016.
 */
public class Activity_From_Campus extends AppCompatActivity {

    Date trialTime = null;
    Date amPmTime = null;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    FromRecyclerViewAdapter fromRecyclerViewAdapter;
    String busTimeJames, busTimeWestcott, busTimeDrumlins, busTimeEastCampus;
    int countBus = 0;
    String busName, busTimeN;
    List<String> fromBusNameList = new ArrayList<String>();
    List<String> fromBusTimeList = new ArrayList<String>();
    BusData busData = new BusData();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_campus);

        Calendar calendar = new GregorianCalendar();
        int currentHour = Integer.valueOf(calendar.get(Calendar.HOUR));
        int currentMinute = Integer.valueOf(calendar.get(Calendar.MINUTE));
        int currentAMPM = Integer.valueOf(calendar.get(Calendar.AM_PM));
        int day = calendar.get(Calendar.DAY_OF_WEEK);


        final SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
        String time = new SimpleDateFormat("HH:mm").format(calendar.getTime());

        final SimpleDateFormat parserAMPM = new SimpleDateFormat("hh:mm aa");


        try {
            trialTime = parser.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        if (currentAMPM != 0) {
            currentHour = currentHour + 12;
        }

        // currentHour=12;
        SQLiteOpenHelper busDatabaseHelper = new BusSQLiteHelper(this);
        SQLiteDatabase db = busDatabaseHelper.getReadableDatabase();


        //////////////If weekend/////////////////////////////////////////
        if (day == 7 || day == 1) {

            Cursor cursorJames = db.query("FROMSU_JAMES_WEEKEND", new String[]{"START_TIME_FROM_CAMPUS_JAMES"}, null, null, null, null, null);
            if (cursorJames.moveToFirst()) {
                try {
                    while (parser.parse(cursorJames.getString(0)).before(trialTime) && !cursorJames.isLast())
                        cursorJames.moveToNext();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }


            if (!cursorJames.getString(0).equals(null)) {
                countBus++;
                //fromBusinfoString.add("James Street");
                //fromBusinfoString.add(cursorJames.getString(0));
                fromBusNameList.add("James Street");


                fromBusTimeList.add(cursorJames.getString(0));
                busTimeJames = "Next Bus James Street at : " + cursorJames.getString(0);

            } else {
                busTimeJames = "No James Street Bus...";
            }
            // closing connection


            ///////////////////////////////////////// Drumlins bus code//////////////////////////////////////////////
            Cursor cursorDrumlins = db.query("FROMSU_DRUMLINS_WEEKENDS", new String[]{"START_TIME_SU_DRUMLINS"}, null, null, null, null, null);
            if (cursorDrumlins.moveToFirst()) {
                try {
                    while (parser.parse(cursorDrumlins.getString(0)).before(trialTime) && !cursorDrumlins.isLast())
                        cursorDrumlins.moveToNext();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }


            if (!cursorDrumlins.getString(0).equals(null)) {
                busTimeDrumlins = "Next Bus Drumlins  at : " + cursorDrumlins.getString(0);
                countBus++;
                //fromBusinfoString.add("Drumlins");
                //fromBusinfoString.add(cursorDrumlins.getString(0));
                fromBusNameList.add("Drumlins");
                fromBusTimeList.add(cursorDrumlins.getString(0));
            } else {
                busTimeDrumlins = "No Drumlins Bus...";
            }
            // closing connection


            if (countBus == 0) {
                countBus++;

                fromBusNameList.add("Damn! No Bus!");
                fromBusTimeList.add("Don't Sweat it! Call an Escort or a Taxi");
            }


            if (day == 1) {
                Cursor cursorEastCampus = db.query("EASTCAMPUS_START_SUNDAY", new String[]{"STARTSTOP_TIME_EASTCAMPUS"}, null, null, null, null, null);
                if (cursorEastCampus.moveToFirst()) {
                    try {
                        while (parser.parse(cursorEastCampus.getString(0)).before(trialTime) && !cursorEastCampus.isLast())
                            cursorEastCampus.moveToNext();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }


                if (!cursorEastCampus.getString(0).equals(null)) {
                    busTimeEastCampus = "Next Bus East Campus  at : " + cursorEastCampus.getString(0);
                    countBus++;
                    //fromBusinfoString.add("East Campus");
                    //fromBusinfoString.add(cursorEastCampus.getString(0));
                    fromBusNameList.add("East Campus");
                    fromBusTimeList.add(cursorEastCampus.getString(0));
                } else {
                    busTimeEastCampus = "No East Campus Bus...";
                }

            }


            if (day == 7) {
                Cursor cursorEastCampus = db.query("EASTCAMPUS_START", new String[]{"STARTSTOP_TIME_EASTCAMPUS"}, null, null, null, null, null);
                if (cursorEastCampus.moveToFirst()) {
                    try {
                        while (parser.parse(cursorEastCampus.getString(0)).before(trialTime) && !cursorEastCampus.isLast())
                            cursorEastCampus.moveToNext();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }


                if (!cursorEastCampus.getString(0).equals(null)) {
                    busTimeEastCampus = "Next Bus East Campus  at : " + cursorEastCampus.getString(0);
                    countBus++;
                    //fromBusinfoString.add("East Campus");
                    //fromBusinfoString.add(cursorEastCampus.getString(0));
                    fromBusNameList.add("East Campus");
                    fromBusTimeList.add(cursorEastCampus.getString(0));
                } else {
                    busTimeEastCampus = "No East Campus Bus...";
                }

            }

        } else {

            //// james street code
            Cursor cursorJames = db.query("FROMSUROUTE_JAMES", new String[]{"START_TIME_FROM_CAMPUS_JAMES"}, null, null, null, null, null);
            if (cursorJames.moveToFirst()) {
                try {
                    while (parser.parse(cursorJames.getString(0)).before(trialTime) && !cursorJames.isLast())
                        cursorJames.moveToNext();
                } catch (ParseException e) {
                    cursorJames.getString(0).equals(null);
                    e.printStackTrace();
                }
            }


            if (!cursorJames.getString(0).equals(null)) {
                countBus++;
                //fromBusinfoString.add("James Street");
                //fromBusinfoString.add(cursorJames.getString(0));
                fromBusNameList.add("James Street");
                fromBusTimeList.add(cursorJames.getString(0));
                busTimeJames = "Next Bus James Street at : " + cursorJames.getString(0);

            } else {
                busTimeJames = "No James Street Bus...";
            }
            // closing connection


            ///////////////////////////////////////// Westcott bus code//////////////////////////////////////////////
            Cursor cursorWestcott = db.query("FROMSU_WESTCOTT", new String[]{"START_TIME_SU_WESTCOTT"}, null, null, null, null, null);
            if (cursorWestcott.moveToFirst()) {
                try {
                    while (parser.parse(cursorWestcott.getString(0)).before(trialTime) && !cursorWestcott.isLast())
                        cursorWestcott.moveToNext();
                } catch (ParseException e) {

                    cursorWestcott.getString(0).equals(null);
                    e.printStackTrace();
                }
            }


            if (!cursorWestcott.getString(0).equals(null)) {
                busTimeWestcott = "Next Bus Westcott 530 at : " + cursorWestcott.getString(0);
                countBus++;

                // fromBusinfoString.add("Westcott 530");
                //fromBusinfoString.add(cursorWestcott.getString(0));
                fromBusNameList.add("Westcott 530");
                fromBusTimeList.add(cursorWestcott.getString(0));
            } else {
                busTimeWestcott = "No Westcott 530 Bus...";
            }
            // closing connection


            ///////////////////////////////////////// Drumlins bus code//////////////////////////////////////////////
            Cursor cursorDrumlins = db.query("FROMSU_DRUMLINS", new String[]{"START_TIME_SU_DRUMLINS"}, null, null, null, null, null);
            if (cursorDrumlins.moveToFirst()) {
                try {
                    while (parser.parse(cursorDrumlins.getString(0)).before(trialTime) && !cursorDrumlins.isLast())
                        cursorDrumlins.moveToNext();
                } catch (ParseException e) {

                    cursorDrumlins.getString(0).equals(null);


                    e.printStackTrace();
                }
            }


            if (!cursorDrumlins.getString(0).equals(null)) {
                busTimeDrumlins = "Next Bus Drumlins  at : " + cursorDrumlins.getString(0);
                countBus++;
                //fromBusinfoString.add("Drumlins");
                //fromBusinfoString.add(cursorDrumlins.getString(0));
                fromBusNameList.add("Drumlins");
                fromBusTimeList.add(cursorDrumlins.getString(0));
            } else {
                busTimeDrumlins = "No Drumlins Bus...";
            }
            // closing connection


            ///////////////////////////////////////// East Campus bus code//////////////////////////////////////////////
            Cursor cursorEastCampus = db.query("EASTCAMPUS_START", new String[]{"STARTSTOP_TIME_EASTCAMPUS"}, null, null, null, null, null);
            if (cursorEastCampus.moveToFirst()) {
                try {
                    while (parser.parse(cursorEastCampus.getString(0)).before(trialTime) && !cursorEastCampus.isLast())
                        cursorEastCampus.moveToNext();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }


            if (!cursorEastCampus.getString(0).equals(null)) {
                busTimeEastCampus = "Next Bus East Campus  at : " + cursorEastCampus.getString(0);
                countBus++;
                //fromBusinfoString.add("East Campus");
                //fromBusinfoString.add(cursorEastCampus.getString(0));
                fromBusNameList.add("East Campus");
                fromBusTimeList.add(cursorEastCampus.getString(0));
            } else {
                busTimeDrumlins = "No East Campus Bus...";
            }
            // closing connection

            if (countBus == 0) {
                countBus++;

                fromBusNameList.add("Damn! No Bus!");
                fromBusTimeList.add("Don't Sweat it! Call an Escort or a Taxi");
            }

        }


        int size = fromBusNameList.size();


        //final View rootView = setContentView(R.layout.card_layout_to_campus, container, false);
        recyclerView = (RecyclerView) findViewById(R.id.cardListFromCampus);
        fromRecyclerViewAdapter = new FromRecyclerViewAdapter(this, fromBusNameList, fromBusTimeList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(fromRecyclerViewAdapter);
        adapterAnimation();




        fromRecyclerViewAdapter.setOnItemClickListener(new FromRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, String bName) {

                Log.d("busName", bName);
                Log.d("position", String.valueOf(position));
                String newName = "From Campus" + " " + bName;
                Log.d("new Name", newName);
                int newpos= busData.findBus(bName);
                Log.d("newpos", String.valueOf(newpos));


                getSupportFragmentManager().beginTransaction().replace(R.id.fromContainer,
                        Fragment_DetailView.newInstance(busData.getItem(newpos))).addToBackStack(null).commit();




            }
        });


        db.close();
    }


    private void adapterAnimation() {
        ScaleInAnimationAdapter alphaAdapter = new ScaleInAnimationAdapter(this.fromRecyclerViewAdapter);
        alphaAdapter.setDuration(500);
        recyclerView.setAdapter(alphaAdapter);
    }


}