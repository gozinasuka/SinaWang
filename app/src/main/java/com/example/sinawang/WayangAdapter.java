package com.example.sinawang;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class WayangAdapter extends RecyclerView.Adapter<WayangAdapter.WayangViewHolder> {

    private GradientDrawable mGradientDrawable;
    private ArrayList<Wayang> mWayangData;
    private Context mContext;
    TextView textView;


    WayangAdapter(Context context, ArrayList<Wayang> wayangData) {
        this.mWayangData = wayangData;
        this.mContext = context;

        //Prepare gray placeholder
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //Make the placeholder same size as the images
        Drawable drawable = ContextCompat.getDrawable
                (mContext,R.drawable.arjuna);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }


    }


    @NonNull
    @Override
    public WayangAdapter.WayangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WayangViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);

    }

    @Override
    public void onBindViewHolder(@NonNull WayangAdapter.WayangViewHolder holder, int position) {
        Wayang currentWayang = mWayangData.get(position);

        //Bind the data to the views
        holder.bindTo(currentWayang);
    }


    @Override
    public int getItemCount() {
        return mWayangData.size();
    }

    public class WayangViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        private TextView mTitleText;
        private TextView mInfoText;
        private TextView mDescriptionText;
        private ImageView mWayangImage;
        private Context mContext;
        private Wayang mCurrentWayang;
        private GradientDrawable mGradientDrawable;
        private Button mbtn_watak;

        WayangViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.product);
            mInfoText = (TextView)itemView.findViewById(R.id.nama_lain);
            mDescriptionText = (TextView)itemView.findViewById(R.id.description);
            mWayangImage = (ImageView)itemView.findViewById(R.id.product_image);



            //invisible text
            mDescriptionText.setVisibility(View.INVISIBLE);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            //Set the OnClickListener to the whole view
            itemView.setOnClickListener(this);
        }

        void bindTo(Wayang currentWayang){
            //Populate the textviews with data
            mTitleText.setText(currentWayang.getTitle());
            mInfoText.setText(currentWayang.getInfo());
            mDescriptionText.setText(currentWayang.getDescription());



            //Get the current sport
            mCurrentWayang = currentWayang;



            //Load the images into the ImageView using the Glide library
            Glide.with(mContext).load(currentWayang.
                    getImageResource()).placeholder(mGradientDrawable).into(mWayangImage);
        }

        @Override
        public void onClick(View view) {
            //Set up the detail intent
            Intent detailIntent = Wayang.starter(mContext, mCurrentWayang.getTitle(),mCurrentWayang.getInfo(),mCurrentWayang.getDescription(),
                    mCurrentWayang.getImageResource());


            //Start the detail activity
            mContext.startActivity(detailIntent);
        }



    }


//    public class WayangViewHolder extends RecyclerView.ViewHolder
//    {
//
//        private TextView mTitleText;
//        private TextView mInfoText;
//        private TextView mDescriptionText;
//        private ImageView mWayangImage;
//        private Context mContext;
//        private Wayang mCurrentWayang;
//        private GradientDrawable mGradientDrawable;
//        public Button mbtn_watak;
//
//        WayangViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
//            super(itemView);
//
//            //Initialize the views
//            mTitleText = (TextView)itemView.findViewById(R.id.product);
//            mInfoText = (TextView)itemView.findViewById(R.id.nama_lain);
//            mDescriptionText = (TextView)itemView.findViewById(R.id.description);
//            mWayangImage = (ImageView)itemView.findViewById(R.id.product_image);
//
//
//
//            //invisible text
//            mDescriptionText.setVisibility(View.INVISIBLE);
//
//            mContext = context;
//            mGradientDrawable = gradientDrawable;
//
//            //Set the OnClickListener to the whole view
//            itemView.setOnClickListener(this);
//        }
//
//        void bindTo(Wayang currentWayang){
//            //Populate the textviews with data
//            mTitleText.setText(currentWayang.getTitle());
//            mInfoText.setText(currentWayang.getInfo());
//            mDescriptionText.setText(currentWayang.getDescription());
//
//
//
//            //Get the current sport
//            mCurrentWayang = currentWayang;
//
//
//
//            //Load the images into the ImageView using the Glide library
//            Glide.with(mContext).load(currentWayang.
//                    getImageResource()).placeholder(mGradientDrawable).into(mWayangImage);
//        }
//
//        @Override
//        public void onClick(View view) {
//            //Set up the detail intent
//            Intent detailIntent = Wayang.starter(mContext, mCurrentWayang.getTitle(),mCurrentWayang.getInfo(),mCurrentWayang.getDescription(),
//                    mCurrentWayang.getImageResource());
//
//
//            //Start the detail activity
//            mContext.startActivity(detailIntent);
//        }
//
//
//
//    }



}
