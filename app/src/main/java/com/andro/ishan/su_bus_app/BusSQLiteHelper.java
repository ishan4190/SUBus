package com.andro.ishan.su_bus_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ishan on 8/8/2016.
 */
public class BusSQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "RELEASEBUSDBVER1"; // name of database
    private static final int DB_VERSION = 1; // the version of database




    BusSQLiteHelper(Context context)
    {
      super (context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
/////////////////////////////////////JAMES STREET/////////////////////////////////////////////////////
        ////////////FROM CAMPUS- JAMES STREET TABLE AND DATA POPULATION////////////
        db.execSQL("CREATE TABLE FROMSUROUTE_JAMES ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "START_STOPNAME BLOB, "
                + "START_TIME_FROM_CAMPUS_JAMES BLOB);");

       insertStartTime(db, "College Place", "7:30");
        insertStartTime(db,"College Place","8:10");
        insertStartTime(db,"College Place","8:45");
        insertStartTime(db,"College Place","9:30");
        insertStartTime(db,"College Place","10:45");
        insertStartTime(db,"College Place","12:15");
        insertStartTime(db,"College Place","13:45");
        insertStartTime(db,"College Place","15:10");
        insertStartTime(db,"College Place","16:00");
        insertStartTime(db,"College Place","16:45");
        insertStartTime(db,"College Place","17:30");
        insertStartTime(db,"College Place","18:10");
        insertStartTime(db,"College Place","19:00");
        insertStartTime(db,"College Place","19:35");
        insertStartTime(db,"College Place","20:10");
        insertStartTime(db,"College Place","20:45");

        ///////////////////////////////TO CAMPUS - JAMES STREET TABLE AND DATA POPULATION////////////////

        // stop names and time gaps table- james street
        db.execSQL("CREATE TABLE TOSUROUTE_JAMES ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "START_STOP_JAMES_TO_SU BLOB, "
                + "TO_STOP BLOB,"
                + "TIME_GAP INTEGER);");

        // start time from Lodi - james street
        db.execSQL("CREATE TABLE JAMES_START ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "LODI_TIME BLOB);");

        insertToSUJames(db, "James and Lodi", "", 0);
        insertToSUJames(db, "James and Lodi", "E.Genesse and Irving", 5);
        insertToSUJames(db,"James and Lodi","E.Genesse and Univ. Ave.",6);
        insertToSUJames(db,"James and Lodi","E.Genesse and Westcott",10);
        insertToSUJames(db,"James and Lodi","Westcott and Euclid",15);
        insertToSUJames(db,"James and Lodi","College Place",20);

        insertLodiStart(db,"7:05");
        insertLodiStart(db,"7:45");
        insertLodiStart(db,"8:25");
        insertLodiStart(db,"9:00");
        insertLodiStart(db,"9:45");
        insertLodiStart(db,"11:00");
        insertLodiStart(db,"12:30");
        insertLodiStart(db,"14:00");
        insertLodiStart(db,"15:00");
        insertLodiStart(db,"16:15");
        insertLodiStart(db,"17:00");
        insertLodiStart(db,"17:45");
        insertLodiStart(db,"18:25");
        insertLodiStart(db,"19:15");
        insertLodiStart(db,"19:50");
        insertLodiStart(db,"20:25");


///////////////////////////////////////// WESTCOTT-DEWITT 530 BUS/////////////////////////////////////////////////
        /////////////////////FROM CAMPUS WESTCOTT BUS TABLE AND DATA POPULATION////////////


        db.execSQL("CREATE TABLE FROMSU_WESTCOTT ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "START_STOPNAME_WESTCOTT BLOB, "
                + "START_TIME_SU_WESTCOTT BLOB);");


        insertStartTimeWestcott(db, "College Place","6:23");
        insertStartTimeWestcott(db,"College Place","6:53");
        insertStartTimeWestcott(db,"College Place","7:38");
        insertStartTimeWestcott(db,"College Place","8:23");
        insertStartTimeWestcott(db,"College Place","9:43");
        insertStartTimeWestcott(db,"College Place","10:48");
        insertStartTimeWestcott(db,"College Place","12:08");
        insertStartTimeWestcott(db,"College Place","13:13");
        insertStartTimeWestcott(db,"College Place","14:38");
        insertStartTimeWestcott(db,"College Place","15:43");
        insertStartTimeWestcott(db,"College Place","16:28");
        insertStartTimeWestcott(db,"College Place","16:58");
        insertStartTimeWestcott(db,"College Place","17:33");
        insertStartTimeWestcott(db,"College Place","18:03");
        insertStartTimeWestcott(db,"College Place","22:38");



       ////////////////// TO SU - Westcott bus////////////////////////



        db.execSQL("CREATE TABLE TOSU_WESTCOTT ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "START_STOP_WESTCOTT_TO_SU BLOB, "
                + "TOWARDS_STOPNAMES_WESTCOTT BLOB,"
                + "TIME_GAP_WESTCOTT INTEGER);");

        db.execSQL("CREATE TABLE WESTCOTT_START ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "TOWARDS_START_TIME_WESTCOTT BLOB);");


        insertToSUWestcott(db, "Nottingham HS", "", 0);
        insertToSUWestcott(db, "Nottingham HS", "E.Genesse and Westcott", 6);
        insertToSUWestcott(db, "Nottingham HS", "Westcott and Euclid",10);
        insertToSUWestcott(db, "Nottingham HS","SU-Bird Library",16);



        insertWestcottStart(db,"5:31");
        insertWestcottStart(db,"6:46");
        insertWestcottStart(db,"7:16");
        insertWestcottStart(db,"7:51");
        insertWestcottStart(db,"8:06");
        insertWestcottStart(db,"9:11");
        insertWestcottStart(db,"9:51");
        insertWestcottStart(db,"11:11");
        insertWestcottStart(db,"12:16");
        insertWestcottStart(db,"13:41");
        insertWestcottStart(db,"14:46");
        insertWestcottStart(db,"16:06");
        insertWestcottStart(db,"17:11");
        insertWestcottStart(db,"23:05");

/////////////////////////////////////////////////DRUMLINS BUS/////////////////////////////////////////////////////////////////////////////
          ////////////////////////////////////FROM SU - DRUMLINS BUS CREATE TABLE AND DATA POPULATION /////////////////////////

        db.execSQL("CREATE TABLE FROMSU_DRUMLINS ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "START_STOPNAME_DRUMLINS BLOB, "
                + "START_TIME_SU_DRUMLINS BLOB);");


        insertStartTimeDrumlins(db, "College Place","5:54");
        insertStartTimeDrumlins(db,"College Place","6:39");
        insertStartTimeDrumlins(db,"College Place","7:13");
        insertStartTimeDrumlins(db,"College Place","8:12");
        insertStartTimeDrumlins(db,"College Place","8:54");
        insertStartTimeDrumlins(db,"College Place","10:14");
        insertStartTimeDrumlins(db,"College Place","10:53");
        insertStartTimeDrumlins(db,"College Place","11:19");
        insertStartTimeDrumlins(db,"College Place","11:58");
        insertStartTimeDrumlins(db,"College Place","12:39");
        insertStartTimeDrumlins(db,"College Place","13:18");
        insertStartTimeDrumlins(db,"College Place","13:49");
        insertStartTimeDrumlins(db,"College Place","14:48");
        insertStartTimeDrumlins(db,"College Place","15:09");
        insertStartTimeDrumlins(db,"College Place","15:49");
        insertStartTimeDrumlins(db,"College Place","16:19");
        insertStartTimeDrumlins(db,"College Place","16:49");
        insertStartTimeDrumlins(db,"College Place","17:26");
        insertStartTimeDrumlins(db,"College Place","17:35");
        insertStartTimeDrumlins(db, "College Place", "17:56");
        insertStartTimeDrumlins(db, "College Place", "18:29");


        /////////////////////////TOWARDS SU - DRUMLINS BUS DATA POPULATION AND TABLE CREATION/////////

        db.execSQL("CREATE TABLE TOSU_DRUMLINS ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "START_STOP_DRUMLINS_TO_SU BLOB, "
                + "TOWARDS_STOPNAMES_DRUMLINS BLOB,"
                + "TIME_GAP_DRUMLINS INTEGER);");

        db.execSQL("CREATE TABLE DRUMLINS_START ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "TOWARDS_START_TIME_DRUMLINS BLOB);");




        insertToSUDrumlins(db, "Drumlins", "", 0);
        insertToSUDrumlins(db, "Drumlins", "Meadowbrooks and Lancaster", 10);
        insertToSUDrumlins(db, "Drumlins", "SU-Bird Library", 18);


        insertDrumlinsStart(db,"5:37");
        insertDrumlinsStart(db,"6:07");
        insertDrumlinsStart(db,"6:57");
        insertDrumlinsStart(db,"7:30");
        insertDrumlinsStart(db,"8:29");
        insertDrumlinsStart(db,"9:13");
        insertDrumlinsStart(db,"9:53");
        insertDrumlinsStart(db,"10:33");
        insertDrumlinsStart(db,"11:13");
        insertDrumlinsStart(db,"11:38");
        insertDrumlinsStart(db,"12:18");
        insertDrumlinsStart(db,"12:58");
        insertDrumlinsStart(db,"13:43");
        insertDrumlinsStart(db,"14:08");
        insertDrumlinsStart(db,"14:48");
        insertDrumlinsStart(db,"15:33");
        insertDrumlinsStart(db,"16:13");
        insertDrumlinsStart(db,"16:40");
        insertDrumlinsStart(db,"17:07");
        insertDrumlinsStart(db,"17:43");
        insertDrumlinsStart(db, "17:57");
        insertDrumlinsStart(db, "19:02");

////////////////////////////////////////////////EAST CAMPUS BUS SCHEDULE//////////////////////////////////////////////////
        db.execSQL("CREATE TABLE EASTCAMPUS ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "START_STOP_EASTCAMPUS_TO_SU BLOB, "
                + "TOWARDS_STOPNAMES_EASTCAMPUS BLOB,"
                + "TIME_GAP_EASTCAMPUS INTEGER);");

        db.execSQL("CREATE TABLE EASTCAMPUS_START ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "STARTSTOP_TIME_EASTCAMPUS BLOB);");



        insertEastCampus(db, "College Place", "", 0);
        insertEastCampus(db, "College Place", "Day and Flint Halls", 6);
        insertEastCampus(db,"College Place","Westcott and Euclid",13);
        insertEastCampus(db,"College Place","E.Genesse and Westcott",15);
        insertEastCampus(db,"College Place","E.Genesse and Univ. Ave.",18);
        insertEastCampus(db,"College Place","Marshall Street-University Ave.",19);
        insertEastCampus(db,"College Place","Henry Street Shelter",28);
        insertEastCampus(db,"College Place","SU-Bird Library",30);
        insertEastCampus(db, "College Place", "Comstock and Adams", 31);
        insertEastCampus(db, "College Place", "College Place", 40);

        insertEastCampusStart(db, "17:20");
        insertEastCampusStart(db,"18:00");
        insertEastCampusStart(db,"18:40");
        insertEastCampusStart(db,"19:20");
        insertEastCampusStart(db,"20:00");
        insertEastCampusStart(db,"20:40");
        insertEastCampusStart(db,"21:20");
        insertEastCampusStart(db,"22:00");
        insertEastCampusStart(db,"22:40");
        insertEastCampusStart(db,"23:20");
        insertEastCampusStart(db,"24:00");
        insertEastCampusStart(db,"00:40");
        insertEastCampusStart(db, "1:20");
        insertEastCampusStart(db, "2:00");


///////////////////////////////All Stop table for SPinner Population
        db.execSQL("CREATE TABLE STOPS_LIST ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "STOP_NAMES BLOB);");

        insertStopNames(db,"College Place");
        insertStopNames(db,"Comstock and Adams");
        insertStopNames(db,"Day and Flint Halls");
        insertStopNames(db,"E.Genesse and Irving");
        insertStopNames(db,"E.Genesse and Univ. Ave.");
        insertStopNames(db,"E.Genesse and Westcott");
        insertStopNames(db,"Henry Street Shelter");
        insertStopNames(db,"Marshall Street-University Ave.");
        insertStopNames(db,"Meadowbrooks and Lancaster");
        insertStopNames(db,"SU-Bird Library");
        insertStopNames(db,"Westcott and Euclid");

/////////////////*/*/*/*/*/*/*////WEEKEND BUSES//*/*/*/*/*/*/*/*///////////////////////////////////////////////////////////////////

//////////////////////////James Street Weekends////////////////////////////////////////////////////////////////



////////////////////////////FROM_CAMPUS- JAMES STREET WEEKEND

        db.execSQL("CREATE TABLE FROMSU_JAMES_WEEKEND ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "START_STOPNAME BLOB, "
                + "START_TIME_FROM_CAMPUS_JAMES BLOB);");

        insertStartTimeWeekends(db, "College Place", "17:30");
        insertStartTimeWeekends(db,"College Place","18:10");
        insertStartTimeWeekends(db,"College Place","19:00");
        insertStartTimeWeekends(db,"College Place","19:35");
        insertStartTimeWeekends(db,"College Place","20:10");
        insertStartTimeWeekends(db,"College Place","20:45");


///////////////////////TO CAMPUS - JAMES STREET SATURDAY


        db.execSQL("CREATE TABLE TOSU_JAMES_WEEKEND ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "START_STOP_JAMES_TO_SU BLOB, "
                + "TO_STOP BLOB,"
                + "TIME_GAP INTEGER);");


        //////////////////////////////////////probably use the same JAMES_START TABLE TO CALCULATE DISTANCE

        // start time from Lodi - james street
        db.execSQL("CREATE TABLE JAMES_START_WEEKEND ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "LODI_TIME BLOB);");

        insertToSUJamesWeekends(db, "James and Lodi", "", 0);
        insertToSUJamesWeekends(db, "James and Lodi", "E.Genesse and Irving", 5);
        insertToSUJamesWeekends(db,"James and Lodi","E.Genesse and Univ. Ave.",6);
        insertToSUJamesWeekends(db,"James and Lodi","E.Genesse and Westcott",10);
        insertToSUJamesWeekends(db,"James and Lodi","Westcott and Euclid",15);
        insertToSUJamesWeekends(db,"James and Lodi","College Place",20);

        insertLodiStartWeekends(db,"17:45");
        insertLodiStartWeekends(db,"18:25");
        insertLodiStartWeekends(db,"19:15");
        insertLodiStartWeekends(db,"19:50");
        insertLodiStartWeekends(db,"20:25");


        ////////////////////////////////DRUMLINS WEEKENDS////////////////////////////////////////////////////////////////

        db.execSQL("CREATE TABLE FROMSU_DRUMLINS_WEEKENDS ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "START_STOPNAME_DRUMLINS BLOB, "
                + "START_TIME_SU_DRUMLINS BLOB);");


        insertStartTimeDrumlinsWeekends(db, "College Place","7:49");
        insertStartTimeDrumlinsWeekends(db,"College Place","11:49");
        insertStartTimeDrumlinsWeekends(db,"College Place","14:34");
        insertStartTimeDrumlinsWeekends(db,"College Place","15:54");
        insertStartTimeDrumlinsWeekends(db,"College Place","18:34");



        /////////////////////////TOWARDS SU - DRUMLINS BUS DATA POPULATION AND TABLE CREATION/////////

        db.execSQL("CREATE TABLE TOSU_DRUMLINS_WEEKENDS ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "START_STOP_DRUMLINS_TO_SU BLOB, "
                + "TOWARDS_STOPNAMES_DRUMLINS BLOB,"
                + "TIME_GAP_DRUMLINS INTEGER);");

        db.execSQL("CREATE TABLE DRUMLINS_START_WEEKENDS ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "TOWARDS_START_TIME_DRUMLINS BLOB);");




        insertToSUDrumlinsWeekends(db, "Drumlins", "", 0);
        insertToSUDrumlinsWeekends(db, "Drumlins", "Meadowbrooks and Lancaster", 12);
        insertToSUDrumlinsWeekends(db, "Drumlins", "SU-Bird Library", 20);


        insertDrumlinsStartWeekends(db,"8:25");
        insertDrumlinsStartWeekends(db,"12:25");
        insertDrumlinsStartWeekends(db,"15:00");
        insertDrumlinsStartWeekends(db,"16:20");
        insertDrumlinsStartWeekends(db,"19:05");



        ////////////////////////East Campus Sunday////////////////////////////////

        db.execSQL("CREATE TABLE EASTCAMPUS_SUNDAY ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "START_STOP_EASTCAMPUS_TO_SU BLOB, "
                + "TOWARDS_STOPNAMES_EASTCAMPUS BLOB,"
                + "TIME_GAP_EASTCAMPUS INTEGER);");

        db.execSQL("CREATE TABLE EASTCAMPUS_START_SUNDAY ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "STARTSTOP_TIME_EASTCAMPUS BLOB);");




        insertEastCampusSunday(db,"College Place", "Day and Flint Halls", 6);
        insertEastCampusSunday(db,"College Place","Westcott and Euclid",13);
        insertEastCampusSunday(db,"College Place","E.Genesse and Westcott",15);
        insertEastCampusSunday(db,"College Place","E.Genesse and Univ. Ave.",18);
        insertEastCampusSunday(db,"College Place","Marshall Street-University Ave.",19);
        insertEastCampusSunday(db,"College Place","Henry Street Shelter",28);
        insertEastCampusSunday(db,"College Place","SU-Bird Library",30);
        insertEastCampusSunday(db,"College Place","Comstock and Adams",31);
        insertEastCampusSunday(db,"College Place","College Place",40);

        insertEastCampusStartSunday(db,"17:20");
        insertEastCampusStartSunday(db,"18:00");
        insertEastCampusStartSunday(db,"18:40");
        insertEastCampusStartSunday(db,"19:20");
        insertEastCampusStartSunday(db,"20:00");
        insertEastCampusStartSunday(db,"20:40");
        insertEastCampusStartSunday(db,"21:20");








    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if(oldVersion==1)
        {


        }

        if(oldVersion<3) {


        }
    }






    //////////////////////FUCNTIONS FOR JAMES STREET/////////////////////////////////////////////////////////
// function insert data into FROM CAMPUSJAMES STREET TABLE
    private static void insertStartTime(SQLiteDatabase db, String startStopName,String startTime)
    {
        ContentValues routevalues = new ContentValues();
        routevalues.put("START_STOPNAME",startStopName);
        routevalues.put("START_TIME_FROM_CAMPUS_JAMES",startTime);

        db.insert("FROMSUROUTE_JAMES", null, routevalues);
    }



// function to insert Stop names and Time Gaps on route from LODI to Campus - JAMES STREET
    private static void insertToSUJames(SQLiteDatabase db, String startStopName,String toStopName,int timeGap)
    {
        ContentValues routevalues = new ContentValues();
        routevalues.put("START_STOP_JAMES_TO_SU",startStopName);
        routevalues.put("TO_STOP",toStopName);
        routevalues.put("TIME_GAP", timeGap);
        db.insert("TOSUROUTE_JAMES", null, routevalues);

    }


    // function to insert start time of James street from LODI
    private static void insertLodiStart(SQLiteDatabase db, String time)
    {   ContentValues routevalues = new ContentValues();
        routevalues.put("LODI_TIME",time);
        db.insert("JAMES_START", null, routevalues);
    }


/////////////////////////////////////////FUCNTIONS FOR DATA POPULATION TO WESTCOTT BUS TABLE/////////////////////////////////////////////////

    // function insert data into FROM CAMPUS- WESTCOTT BUS TABLE
    private static void insertStartTimeWestcott(SQLiteDatabase db, String startStopName,String startTime)
    {
        ContentValues routevalues = new ContentValues();
        routevalues.put("START_STOPNAME_WESTCOTT",startStopName);
        routevalues.put("START_TIME_SU_WESTCOTT",startTime);

        db.insert("FROMSU_WESTCOTT", null, routevalues);
    }


    // function to insert Stop names and Time Gaps on towards campus route for Wesctcott BUS
    private static void insertToSUWestcott(SQLiteDatabase db, String startStopName,String toStopName,int timeGap)
    {
        ContentValues routevalues = new ContentValues();
        routevalues.put("START_STOP_WESTCOTT_TO_SU",startStopName);
        routevalues.put("TOWARDS_STOPNAMES_WESTCOTT",toStopName);
        routevalues.put("TIME_GAP_WESTCOTT", timeGap);
        db.insert("TOSU_WESTCOTT", null, routevalues);

    }


    // function to insert start time of Westcott towards campus route
    private static void insertWestcottStart(SQLiteDatabase db, String time)
    {   ContentValues routevalues = new ContentValues();
        routevalues.put("TOWARDS_START_TIME_WESTCOTT",time);
        db.insert("WESTCOTT_START", null, routevalues);
    }



    /////////////////////////////////////////FUCNTIONS FOR DATA POPULATION TO DRUMLINS BUS TABLE/////////////////////////////////////////////////

    // function insert data into FROM CAMPUS- Drumlins BUS TABLE
    private static void insertStartTimeDrumlins(SQLiteDatabase db, String startStopName,String startTime)
    {
        ContentValues routevalues = new ContentValues();
        routevalues.put("START_STOPNAME_DRUMLINS",startStopName);
        routevalues.put("START_TIME_SU_DRUMLINS",startTime);

        db.insert("FROMSU_DRUMLINS", null, routevalues);
    }


    // function to insert Stop names and Time Gaps on towards campus route for Wesctcott BUS
    private static void insertToSUDrumlins(SQLiteDatabase db, String startStopName,String toStopName,int timeGap)
    {
        ContentValues routevalues = new ContentValues();
        routevalues.put("START_STOP_DRUMLINS_TO_SU",startStopName);
        routevalues.put("TOWARDS_STOPNAMES_DRUMLINS",toStopName);
        routevalues.put("TIME_GAP_DRUMLINS", timeGap);
        db.insert("TOSU_DRUMLINS", null, routevalues);

    }


    // function to insert start time of Westcott towards campus route
    private static void insertDrumlinsStart(SQLiteDatabase db, String time)
    {   ContentValues routevalues = new ContentValues();
        routevalues.put("TOWARDS_START_TIME_DRUMLINS",time);
        db.insert("DRUMLINS_START", null, routevalues);
    }

//////////////////////////////////function FOR EAST CAMPUS/////////////////////////////////////

/////////////////proabably only has TOWARDS CAMPUS Route
    // function to insert Stop names and Time Gaps on towards campus route for Wesctcott BUS
    private static void insertEastCampus(SQLiteDatabase db, String startStopName,String toStopName,int timeGap)
    {
        ContentValues routevalues = new ContentValues();
        routevalues.put("START_STOP_EASTCAMPUS_TO_SU",startStopName);
        routevalues.put("TOWARDS_STOPNAMES_EASTCAMPUS",toStopName);
        routevalues.put("TIME_GAP_EASTCAMPUS", timeGap);
        db.insert("EASTCAMPUS", null, routevalues);

    }


    // function to insert start time of Westcott towards campus route
    private static void insertEastCampusStart(SQLiteDatabase db, String time)
    {   ContentValues routevalues = new ContentValues();
        routevalues.put("STARTSTOP_TIME_EASTCAMPUS",time);
        db.insert("EASTCAMPUS_START", null, routevalues);
    }

//////////////////////////////////////function to populate STOPS_LIST TABLE///////////////////////////

    private static void insertStopNames(SQLiteDatabase db, String stopNames)
    {
        ContentValues stopNameValues= new ContentValues();
        stopNameValues.put("STOP_NAMES",stopNames);
        db.insert("STOPS_LIST", null,stopNameValues);

    }


    /////*/*/*///// WEEKEND BUS FUNCTIONS////////////////////////////

    // function insert data into FROM CAMPUSJAMES STREET TABLE
    private static void insertStartTimeWeekends(SQLiteDatabase db, String startStopName,String startTime)
    {
        ContentValues routevalues = new ContentValues();
        routevalues.put("START_STOPNAME",startStopName);
        routevalues.put("START_TIME_FROM_CAMPUS_JAMES",startTime);

        db.insert("FROMSU_JAMES_WEEKEND", null, routevalues);
    }



    // function to insert Stop names and Time Gaps on route from LODI to Campus - JAMES STREET
    private static void insertToSUJamesWeekends(SQLiteDatabase db, String startStopName,String toStopName,int timeGap)
    {
        ContentValues routevalues = new ContentValues();
        routevalues.put("START_STOP_JAMES_TO_SU",startStopName);
        routevalues.put("TO_STOP",toStopName);
        routevalues.put("TIME_GAP", timeGap);
        db.insert("TOSU_JAMES_WEEKEND", null, routevalues);

    }


    // function to insert start time of James street from LODI
    private static void insertLodiStartWeekends(SQLiteDatabase db, String time)
    {   ContentValues routevalues = new ContentValues();
        routevalues.put("LODI_TIME",time);
        db.insert("JAMES_START_WEEKEND", null, routevalues);
    }

    //////////////////////////DRUMLINS WEEKEND//////////////////////////////////////////////
    // function insert data into FROM CAMPUS- Drumlins BUS TABLE
    private static void insertStartTimeDrumlinsWeekends(SQLiteDatabase db, String startStopName,String startTime)
    {
        ContentValues routevalues = new ContentValues();
        routevalues.put("START_STOPNAME_DRUMLINS",startStopName);
        routevalues.put("START_TIME_SU_DRUMLINS",startTime);

        db.insert("FROMSU_DRUMLINS_WEEKENDS", null, routevalues);
    }


    // function to insert Stop names and Time Gaps on towards campus route for Wesctcott BUS
    private static void insertToSUDrumlinsWeekends(SQLiteDatabase db, String startStopName,String toStopName,int timeGap)
    {
        ContentValues routevalues = new ContentValues();
        routevalues.put("START_STOP_DRUMLINS_TO_SU",startStopName);
        routevalues.put("TOWARDS_STOPNAMES_DRUMLINS",toStopName);
        routevalues.put("TIME_GAP_DRUMLINS", timeGap);
        db.insert("TOSU_DRUMLINS_WEEKENDS", null, routevalues);

    }


    // function to insert start time of Westcott towards campus route
    private static void insertDrumlinsStartWeekends(SQLiteDatabase db, String time)
    {   ContentValues routevalues = new ContentValues();
        routevalues.put("TOWARDS_START_TIME_DRUMLINS",time);
        db.insert("DRUMLINS_START_WEEKENDS", null, routevalues);
    }

/// function for SUNDAYS EAST CAMPUS

    private static void insertEastCampusSunday(SQLiteDatabase db, String startStopName,String toStopName,int timeGap)
    {
        ContentValues routevalues = new ContentValues();
        routevalues.put("START_STOP_EASTCAMPUS_TO_SU",startStopName);
        routevalues.put("TOWARDS_STOPNAMES_EASTCAMPUS",toStopName);
        routevalues.put("TIME_GAP_EASTCAMPUS", timeGap);
        db.insert("EASTCAMPUS_SUNDAY", null, routevalues);

    }


    // function to insert start time of Westcott towards campus route
    private static void insertEastCampusStartSunday(SQLiteDatabase db, String time)
    {   ContentValues routevalues = new ContentValues();
        routevalues.put("STARTSTOP_TIME_EASTCAMPUS",time);
        db.insert("EASTCAMPUS_START_SUNDAY", null, routevalues);
    }


}
