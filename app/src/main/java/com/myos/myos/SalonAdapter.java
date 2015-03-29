package com.myos.myos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by andrianto on 28/3/15.
 */
public class SalonAdapter extends RecyclerView.Adapter<SalonAdapter.SalonViewHolder> {

    private List<SalonInfo> salonList;

    public SalonAdapter(List<SalonInfo> salonList) {
        this.salonList = salonList;
    }

    @Override
    public int getItemCount() {
        return salonList.size();
    }

    @Override
    public void onBindViewHolder(SalonViewHolder salonViewHolder, int i) {
        SalonInfo ci = salonList.get(i);
        salonViewHolder.vName.setText(ci.name);
        salonViewHolder.vLocation.setText(ci.location);
        salonViewHolder.vPriceRange.setText(ci.priceRange);
        salonViewHolder.vShopImage.setImageResource(ci.picture);
    }

    @Override
    public SalonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);

        return new SalonViewHolder(itemView);
    }

    public static class SalonViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected TextView vLocation;
        protected TextView vPriceRange;
        protected ImageView vShopImage;

        public SalonViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.txtName);
            vLocation = (TextView)  v.findViewById(R.id.txtLocation);
            vPriceRange = (TextView)  v.findViewById(R.id.txtPriceRange);
            vShopImage = (ImageView) v.findViewById(R.id.shopImage);
        }
    }
}
