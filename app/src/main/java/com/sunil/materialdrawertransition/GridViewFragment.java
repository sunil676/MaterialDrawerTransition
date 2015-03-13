package com.sunil.materialdrawertransition;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunil.materialdrawertransition.adapter.ListAdapter;
import com.sunil.materialdrawertransition.model.ImageModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KNS015 on 13-03-2015.
 */
public class GridViewFragment extends Fragment{

    private RecyclerView mRecyclerView;

    String imagearray[]={
            "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/flying_in_the_light.jpg",
            "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/caterpillar.jpg",
            "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/look_me_in_the_eye.jpg",
            "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/flamingo.jpg",
            "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/rainbow.jpg",
            "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/over_there.jpg",
            "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/jelly_fish_2.jpg",
            "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/lone_pine_sunset.jpg"
    };
    String title[]={
            "flying_in_the_light",
            "caterpillar",
            "look_me_in_the_eye",
            "flamingo",
            "rainbow",
            "over_there",
            "jelly_fish_2",
            "lone_pine_sunset"
    };


    List<ImageModel> list=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.gridview_layout, container, false);

        //mGridView=(GridView)rootView.findViewById(R.id.gridView);

        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        for (int i=0; i< imagearray.length; i++){

            String imageurl=imagearray[i];
            String titlename=title[i];
            ImageModel model=new ImageModel(imageurl, titlename);
            list.add(model);
        }

        ListAdapter adapter=new ListAdapter(getActivity(), list);
        mRecyclerView.setAdapter(adapter);

        return rootView;
    }
}
