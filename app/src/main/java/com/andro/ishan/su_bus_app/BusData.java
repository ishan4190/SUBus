package com.andro.ishan.su_bus_app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ishan on 9/7/2016.
 */
public class BusData {

    List<Map<String,?>> busList;

    public List<Map<String, ?>> getBusList() {
        return busList;
    }

    public int getSize(){
        return busList.size();
    }

    public int findBus(String query) {
        int i = 0;
        while (i < this.busList.size()) {
            String test = (String) ((Map) this.busList.get(i)).get("name");
            if (test.contains(query) || test.toLowerCase().contains(query) || test.toUpperCase().contains(query)) {
                return i;
            }
            i++;
        }
        return 0;
    }

    public HashMap getItem(int i){
        if (i >=0 && i < busList.size()){
            return (HashMap) busList.get(i);
        } else return null;
    }



    public BusData() {

        busList = new ArrayList<Map<String, ?>>();

        busList.add(createBus("From Campus James Street",R.drawable.jamesstreetweekday));
        busList.add(createBus("Towards Campus James Street",R.drawable.jamesstreetweekday));
        busList.add(createBus("From Campus Westcott 530",R.drawable.fromsuwestcott));
        busList.add(createBus("Towards Campus Westcott 530",R.drawable.tosuwestcott));
        busList.add(createBus("From Campus East Campus",R.drawable.eastcampus));
        busList.add(createBus("Towards Campus East Campus",R.drawable.eastcampus));
        busList.add(createBus("From Campus Drumlins",R.drawable.fromsudrumlins));
        busList.add(createBus("Towards Campus Drumlins",R.drawable.tosudrumlins));
        busList.add(createBus("Towards Campus James Weekend",R.drawable.jamesstreetweekend));
        busList.add(createBus("From Campus James Weekend",R.drawable.jamesstreetweekend));


    }


    private HashMap createBus(String name, int image) {
        HashMap bus = new HashMap();
        bus.put("image",image);
        bus.put("name", name);
        return bus;
    }
}
