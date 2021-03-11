package me.pgb.a2021_02_19a.model;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import me.pgb.a2021_02_19a.R;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private String TAG = "VIEW_HOLDER";

    public TextView name;
    public TextView capital;
    public TextView region;

    private Bundle bundle;

    public ViewHolder(View itemView){
        super(itemView);

        itemView.setOnClickListener(this);
        name = itemView.findViewById(R.id.item_country);
        capital = itemView.findViewById(R.id.item_capital);
        region = itemView.findViewById(R.id.item_region);


    }
    @Override
    public void onClick(View v) {
        Log.i(TAG,"You clicked " + String.valueOf(v.getId()).toString());
        bundle = new Bundle();
        bundle.putInt("card", getAdapterPosition());
        bundle.putString("capital", capital.getText().toString());
        bundle.putString("region", region.getText().toString());

        Navigation.findNavController(itemView).navigate(R.id.action_navigation_notifications_to_detailsFragment, bundle);


    }
}
