package com.sunil.materialdrawertransition;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sunil.materialdrawertransition.adapter.ListAdapter;
import com.sunil.materialdrawertransition.model.ImageModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KNS015 on 13-03-2015.
 */
public class ListViewFragment extends Fragment{

    private RecyclerView mRecyclerView;
    List<ImageModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.gridview_layout, container, false);
        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        list=new ImageUtil().getimagelist();

        ListAdapter adapter=new ListAdapter(getActivity(), list);
        mRecyclerView.setAdapter(adapter);

        adapter.SetOnItemClickListener(new ListAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View v , int position) {
                String title=list.get(position).getTitle();
                String imageurl=list.get(position).getImageurl();
                Toast.makeText(getActivity(), "Tile is: " + title, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("image", imageurl);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),

                        new Pair<View, String>(v.findViewById(R.id.image),  DetailActivity.VIEW_NAME_HEADER_IMAGE),
                        new Pair<View, String>(v.findViewById(R.id.title),  DetailActivity.VIEW_NAME_HEADER_TITLE));

                getActivity().startActivity(intent, options.toBundle());
            }
        });

        return rootView;
    }

}
