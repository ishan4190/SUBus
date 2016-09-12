package com.andro.ishan.su_bus_app;

import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.util.FloatMath;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Ishan on 9/7/2016.
 */
public class Fragment_DetailView extends Fragment {
    BusData busObj= new BusData();

    Matrix matrix = new Matrix();
    Matrix savedMatrix = new Matrix();

    // We can be in one of these 3 states
    static final int NONE = 0;
    static final int DRAG = 1;
    static final int ZOOM = 2;
    int mode = NONE;

    // Remember some things for zooming
    PointF start = new PointF();
    PointF mid = new PointF();
    float oldDist = 1f;
    String savedItemClicked;

    public static Fragment_DetailView newInstance(HashMap<String,?> bus) {
        Fragment_DetailView fragment = new Fragment_DetailView();
        Bundle args = new Bundle();
        args.putSerializable("Bus", bus);

        // args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }




    public Fragment_DetailView() { }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        View rootView=null;
        HashMap<String,?> bus= (HashMap<String,?>) getArguments().getSerializable("Bus");

        View view = inflater.inflate(R.layout.detailview, container, false);



        TextView busName = (TextView) view.findViewById(R.id.detailBusName);
        TouchImageView busImage = (TouchImageView) view.findViewById(R.id.detailImage);




        int imgId= (Integer)bus.get("image");
        busImage.setImageResource(imgId);

        String busDetailName= (String)bus.get("name");
        busName.setText(busDetailName);




        return view;
    }



}

