package com.myos.myos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


public class StylistProfileAdapter extends RecyclerView.Adapter<StylistProfileAdapter.StylistProfileViewHolder> {

    private List<StylistProfileInfo> stylistProfileList;

    public StylistProfileAdapter(List<StylistProfileInfo> stylistProfileList) {
        this.stylistProfileList = stylistProfileList;
    }

    @Override
    public int getItemCount() {
        return stylistProfileList.size();
    }

    @Override
    public void onBindViewHolder(StylistProfileViewHolder stylistProfileViewHolder, int i) {
        StylistProfileInfo ci = stylistProfileList.get(i);
        stylistProfileViewHolder.vShopImage.setImageResource(ci.picture);
    }

    @Override
    public StylistProfileViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.stylist_profile_card_layout, viewGroup, false);

        return new StylistProfileViewHolder(itemView);
    }

    public static class StylistProfileViewHolder extends RecyclerView.ViewHolder {

        protected ImageView vShopImage;

        public StylistProfileViewHolder(View v) {
            super(v);
            vShopImage = (ImageView) v.findViewById(R.id.shopImage);
        }
    }
}
