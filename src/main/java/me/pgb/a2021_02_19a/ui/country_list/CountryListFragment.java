package me.pgb.a2021_02_19a.ui.country_list;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import me.pgb.a2021_02_19a.R;
import me.pgb.a2021_02_19a.controller.GetData;
import me.pgb.a2021_02_19a.controller.ItemRecycleViewer;
import me.pgb.a2021_02_19a.model.Country;

public class CountryListFragment extends Fragment {

    private CountryListViewModel countryListViewModel;
    private RecyclerView recyclerView;
    //private ArrayList<Country> countryArrayList;
    private ItemRecycleViewer itemRecyclerView;
    private RequestQueue queue;



    private RecyclerView.Adapter adapter;
   // private Button addButton;


    public void onCreate(Bundle myBundle){
       super.onCreate(myBundle);

        countryListViewModel =
                new ViewModelProvider(this).get(CountryListViewModel.class);

        queue = Volley.newRequestQueue(getContext());

     }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_countries, container, false);


        adapter = new ItemRecycleViewer(R.layout.cardview_layout,GetData.countryArrayList);

        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        GetData getData = new GetData(recyclerView, adapter, queue, this);
        getData.loadCountryData();
        adapter.notifyDataSetChanged();

        //loadCountryData();

        return root;
    }
}