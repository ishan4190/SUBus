package com.andro.ishan.su_bus_app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

//import net.colindodd.gradientlayout.GradientLinearLayout;
//import net.colindodd.gradientlayout.GradientRelativeLayout;

import com.goka.kenburnsview.KenBurnsView;
import com.goka.kenburnsview.LoopViewPager;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;



/**
 * Created by Ishan on 2/11/2016.
 */
public class HomePageFragment extends Fragment {


    private static String ARG_SECTION_NUMBER = "section_number";

    private OnTask2ClickedListener t2Listener;
    private OnTask1ClickedListener t1Listener;

    private Button task1, task2;

    private ImageView image1;
    private ImageView image2;
    private boolean isFirstImage = true;

    public static HomePageFragment newInstance() {
        HomePageFragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        // args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        t2Listener= (OnTask2ClickedListener) getContext();
        t1Listener= (OnTask1ClickedListener) getContext();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.homepage_fragment, container, false);



        task2=(Button) view.findViewById(R.id.button_task2);
        task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t2Listener.onTask2Clicked(savedInstanceState);
            }
        });

        task1=(Button) view.findViewById(R.id.button_task1);
        task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1Listener.onTask1Clicked(savedInstanceState);
            }
        });
////////////////////////////////////////ken burns view /////////////////////////////////////////////////////////////////////////////////
        //initializeKenBurnsView(view);
        final KenBurnsView kenBurnsView = (KenBurnsView) view.findViewById(R.id.ken_burns_view);
        kenBurnsView.setScaleType(ImageView.ScaleType.CENTER_CROP);
       // kenBurnsView.setSwapMs(3750);
        //kenBurnsView.setFadeInOutMs(750);

        kenBurnsView.setTranslationX(20);

        // ResourceIDs
        List<Integer> resourceIDs = Arrays.asList(SampleImages.IMAGES_RESOURCE);
        //kenBurnsView.loadResourceIDs(resourceIDs);
        kenBurnsView.initResourceIDs(resourceIDs);

        // LoopViewListenerre
        LoopViewPager.LoopViewPagerListener listener = new LoopViewPager.LoopViewPagerListener() {
            @Override
            public View OnInstantiateItem(int page) {
                TextView counterText = new TextView(getContext());
                counterText.setText(String.valueOf(page));
                return counterText;
            }

            @Override
            public void onPageScroll(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                kenBurnsView.forceSelected(position);
            }

            @Override
            public void onPageScrollChanged(int page) {
            }
        };

        // LoopView
        LoopViewPager loopViewPager = new LoopViewPager(getContext(), resourceIDs.size(), listener);

        FrameLayout viewPagerFrame = (FrameLayout) view.findViewById(R.id.view_pager_frame);
        viewPagerFrame.addView(loopViewPager);

        kenBurnsView.setPager(loopViewPager);
//////////////////////////////////////////////////////////ken burns view ends/////////////////////////////////////////////////////////////

        return view;
    }

    public HomePageFragment() { }

    //OnButtonSelectedListener buttonListener;





    public interface OnTask1ClickedListener{
        public void onTask1Clicked(Bundle savedInstanceState);
    }

    public interface OnTask2ClickedListener{
        public void onTask2Clicked(Bundle savedInstanceState);
    }



    private void initializeKenBurnsView(View v) {
        // KenBurnsView


}


}