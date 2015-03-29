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
public class SalonProfileAdapter extends RecyclerView.Adapter<SalonProfileAdapter.SalonProfileViewHolder> {

    private List<SalonProfileInfo> salonList;

    public SalonProfileAdapter(List<SalonProfileInfo> salonList) {
        this.salonList = salonList;
    }


    @Override
    public int getItemCount() {
        return salonList.size();
    }

    @Override
    public void onBindViewHolder(SalonProfileViewHolder salonViewHolder, int i) {
        SalonProfileInfo ci = salonList.get(i);
        salonViewHolder.vName.setText(ci.name);
        salonViewHolder.vRecommendation.setText(ci.recommendation);
        salonViewHolder.vReview.setText(ci.review);
        salonViewHolder.vBarberImage.setImageResource(ci.picture);
    }

    @Override
    public SalonProfileViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.salon_profile_card_layout, viewGroup, false);

        return new SalonProfileViewHolder(itemView);
    }

    public static class SalonProfileViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected TextView vRecommendation;
        protected TextView vReview;
        protected ImageView vBarberImage;

        public SalonProfileViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.txtName);
            vRecommendation = (TextView)  v.findViewById(R.id.txtRecommendation);
            vReview = (TextView)  v.findViewById(R.id.txtReview);
            vBarberImage = (ImageView) v.findViewById(R.id.barberImage);
        }
    }
}
