package me.pgb.a2021_02_19a.ui.country_list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import me.pgb.a2021_02_19a.model.Country;

public class CountryListViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<ArrayList<Country>> countryArrayList;

    public CountryListViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Countries fragment");

        countryArrayList = new MutableLiveData<>();
        countryArrayList.setValue(new ArrayList<Country>());
    }

    public MutableLiveData<ArrayList<Country>> getCountryArrayList() {
        return countryArrayList;
    }

    public void addCountryList(ArrayList<Country> myCountryArrayList){
        countryArrayList.postValue(myCountryArrayList);
    }

    public LiveData<String> getText() {
        return mText;
    }
}