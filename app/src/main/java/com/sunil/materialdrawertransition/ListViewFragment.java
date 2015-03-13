package com.sunil.materialdrawertransition;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        list=new ImageUtil().getimagelist();

        ListAdapter adapter=new ListAdapter(getActivity(), list);
        mRecyclerView.setAdapter(adapter);

        adapter.SetOnItemClickListener(new ListAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View v , int position) {
                String title=list.get(position).getTitle();
                Toast.makeText(getActivity(), "Tile is: " + title, Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }

}
