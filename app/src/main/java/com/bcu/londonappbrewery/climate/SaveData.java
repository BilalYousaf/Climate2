package com.bcu.londonappbrewery.climate;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;


public class SaveData {

    private static final String TAG ="SaveData";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;

    private static String prefName = "Pref";
    public static ArrayList<HistoryObj> weatherHistoryList = new ArrayList<>();
    //KEYS to store
    public static String WEATHER_LIST_KEY= "WeatherIds";

    public SaveData(Context context){
        int PRIVATE_MODE = 0;
        this.context = context;
        preferences = context.getSharedPreferences(prefName,PRIVATE_MODE);
        editor = preferences.edit();

        weatherHistoryList = getWeatherList();
    }

        public ArrayList<HistoryObj> getWeatherList(){
    	Gson gson = new Gson();

    	ArrayList<String> objStrings = getListString(WEATHER_LIST_KEY);
    	ArrayList<HistoryObj> objects =  new ArrayList<HistoryObj>();

    	for(String jObjString : objStrings){
            HistoryObj value  = gson.fromJson(jObjString,  HistoryObj.class);
    		objects.add(value);
    	}

    	return objects;
    }


    public void saveWeatherList(ArrayList<HistoryObj> objArray){
    	checkForNullKey(WEATHER_LIST_KEY);
    	Gson gson = new Gson();
    	ArrayList<String> objStrings = new ArrayList<String>();
    	for(HistoryObj obj : objArray){
    		objStrings.add(gson.toJson(obj));
    	}
    	putListString(WEATHER_LIST_KEY, objStrings);
    }

    public ArrayList<String> getListString(String key) {
        return new ArrayList<String>(Arrays.asList(TextUtils.split(preferences.getString(key, ""), "‚‗‚")));
    }

    public void putListString(String key, ArrayList<String> stringList) {
        checkForNullKey(key);
        String[] myStringList = stringList.toArray(new String[stringList.size()]);
        preferences.edit().putString(key, TextUtils.join("‚‗‚", myStringList)).apply();
    }

    public void checkForNullKey(String key){
        if (key == null){
            throw new NullPointerException();
        }
    }
 }
