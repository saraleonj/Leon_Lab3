package me.pgb.a2021_02_19a.controller;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import me.pgb.a2021_02_19a.model.Country;
import me.pgb.a2021_02_19a.ui.country_list.CountryListFragment;
import me.pgb.a2021_02_19a.ui.country_list.CountryListViewModel;

public class GetData {

    private final String TAG = "NOW";
    private String URL = "https://restcountries.eu/rest/v1/all";

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private CountryListViewModel countryListViewModel;
    public static ArrayList<Country> countryArrayList = new ArrayList<Country>();
    private RequestQueue queue;

    //public static ArrayList<Country> sCountryList = new ArrayList<Country>();

    public GetData(RecyclerView recyclerView, RecyclerView.Adapter adapter, RequestQueue queue, CountryListFragment countryListFragment){
        countryListViewModel = new ViewModelProvider(countryListFragment).get(CountryListViewModel.class);


        this.queue = queue;
        this.adapter = adapter;
        this.recyclerView = recyclerView;
    }

    public void loadCountryData(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //take response from OnResponse to json array
                            JSONArray array = new JSONArray(response);

                            Log.i("sar", "size: " + String.valueOf(array.length()));

                            //iterate through array indexes
                            for (int i = 0; i < array.length(); i++) {

                                //get each object in the array
                                JSONObject jsonData = array.getJSONObject(i);

                                String name = jsonData.getString("name");
                                String capital = jsonData.getString("capital");
                                String region = jsonData.getString("region");
                                String area = jsonData.getString("area");
                                String currency = jsonData.getString("currencies");

                                Country country = new Country(name, capital, region, area, currency);
                                countryArrayList.add(country);
                            }

                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        queue.add(stringRequest);
    }
}
