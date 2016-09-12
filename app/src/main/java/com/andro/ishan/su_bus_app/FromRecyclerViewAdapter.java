package com.andro.ishan.su_bus_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Ishan on 8/23/2016.
 */
public class FromRecyclerViewAdapter extends RecyclerView.Adapter<FromRecyclerViewAdapter.ViewHolder> {
    OnItemClickListener mItemClickListener;
    private List<Map<String, ?>> movieData;
    private Context context;
    private List<String> busNameList = new ArrayList<String>();
    private List<String> busTimeList = new ArrayList<String>();
    String busNameString;
    String busTimeString;
    Date amPmTime=null;

    public interface OnItemClickListener{
        public void onItemClick(View view, int pos, String busName);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener){
        this.mItemClickListener = mItemClickListener;
    }

    public FromRecyclerViewAdapter(Context myContext, List<String> nameList, List<String> timeList) {
        busNameList = nameList;
        busTimeList= timeList;
        context = myContext;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View recyclerView;

        recyclerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_from_campus, parent, false);

        ViewHolder vh = new ViewHolder(recyclerView);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        busNameString= busNameList.get(position);
        busTimeString =busTimeList.get(position);


        holder.bindCardData();
    }

    @Override
    public int getItemCount() {
        return busNameList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView busName,busTime;



        public ViewHolder(final View itemView) {
            super(itemView);
            busName = (TextView) itemView.findViewById(R.id.busName);
            busTime= (TextView) itemView.findViewById(R.id.busTimeText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if(mItemClickListener!=null) {

                        mItemClickListener.onItemClick(v, getPosition(),busNameList.get(getPosition()));
                    }

                }
            });


        }

        public void bindCardData() {


              // Calendar cal = new GregorianCalendar();


            busName.setText(busNameString);
                busTime.setText(busTimeString);


        }
    }
}

