package me.pgb.a2021_02_19a.ui.details;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.pgb.a2021_02_19a.R;
import me.pgb.a2021_02_19a.controller.GetData;
import me.pgb.a2021_02_19a.model.Country;
import me.pgb.a2021_02_19a.ui.country_list.CountryListViewModel;

public class DetailsFragment extends Fragment {

    private DetailsViewModel mViewModel;
    private CountryListViewModel countryListViewModel;

    public static DetailsFragment newInstance() {
        return new DetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        countryListViewModel = new ViewModelProvider(this).get(CountryListViewModel.class);
        return inflater.inflate(R.layout.details_fragment, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        TextView countryView = view.findViewById(R.id.name);
        TextView capitalView = view.findViewById(R.id.capital);
        TextView regionView = view.findViewById(R.id.region);
        TextView areaView = view.findViewById(R.id.area);
        TextView currencyView = view.findViewById(R.id.currency);

        Bundle bundle = getArguments();
        int position = bundle.getInt("card");
        //String capital = bundle.getString("capital");
        //String region = bundle.getString("region");
        Country country = GetData.countryArrayList.get(position);
        Log.i("name", country.name);
        countryView.setText(country.name);
        capitalView.setText(country.capital);
        regionView.setText(country.region);
        areaView.setText(country.area);
        currencyView.setText(country.currency);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetailsViewModel.class);
        // TODO: Use the ViewModel
    }

}