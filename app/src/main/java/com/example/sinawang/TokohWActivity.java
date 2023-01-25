package com.example.sinawang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class TokohWActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Wayang> mWayangData;
    private WayangAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tokoh_w);

        //get sumber daya integers.xml
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        //Initialize the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        //Set the Layout Manager
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

//

        //Initialize the ArrayList that will contain the data
        mWayangData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new WayangAdapter(this, mWayangData);
        mRecyclerView.setAdapter(mAdapter);

        //Get the data
        initializeData();
    }

    private void initializeData() {
        //Get the resources from the XML file
        String[] wayangList = getResources().getStringArray(R.array.nama_wayang);
        String[] wayangInfo = getResources().getStringArray(R.array.nama_lain_wayang);
        String[] wayangDesk = getResources().getStringArray(R.array.deskripsi_W_Wayang);
        TypedArray wayangImageResources = getResources().obtainTypedArray(R.array.gambar_wayang);

        //Clear the existing data (to avoid duplication)
        mWayangData.clear();


        //Create the ArrayList of Sports objects with the titles, images
        // and information about each sport
        for(int i=0; i<wayangList.length; i++){
            mWayangData.add(new Wayang(wayangList[i],wayangInfo[i],wayangDesk[i], wayangImageResources.getResourceId(i, 0)));
        }

        //Recycle the typed array
        wayangImageResources.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }

}