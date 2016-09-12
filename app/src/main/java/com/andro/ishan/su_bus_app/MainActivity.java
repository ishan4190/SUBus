package com.andro.ishan.su_bus_app;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements HomePageFragment.OnTask2ClickedListener ,HomePageFragment.OnTask1ClickedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_layout);

       Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarHome);
        setSupportActionBar(toolBar);

        toolBar.setLogo(R.drawable.logosu4);

       /* TextView toolbarTitle = null;
        for (int i = 0; i < toolBar.getChildCount(); ++i) {
            View child = toolBar.getChildAt(i);


            if (child instanceof TextView) {
                toolbarTitle = (TextView)child;
                break;
            }
        }*/

       /* Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/ITCFranklinGothicStd-BkCp.otf");
        assert toolbarTitle != null;
        toolbarTitle.setTypeface(custom_font);*/




        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, HomePageFragment.newInstance())
                .commit();
    }






    @Override
    public void onTask2Clicked(Bundle savedInstanceState) {
        Intent intent = new Intent(this, Activity_To_Campus.class);
        startActivity(intent);
    }


    @Override
    public void onTask1Clicked(Bundle savedInstanceState) {
        Intent intent = new Intent(this, Activity_From_Campus.class);
        startActivity(intent);
    }
}
