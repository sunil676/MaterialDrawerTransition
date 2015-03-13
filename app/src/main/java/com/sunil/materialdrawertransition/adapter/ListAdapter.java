package com.sunil.materialdrawertransition.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.sunil.materialdrawertransition.R;
import com.sunil.materialdrawertransition.model.ImageModel;

import java.util.List;

/**
 * Created by Sunil on 13-03-2015.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{

    List<ImageModel> listimages;
    Context mcontext;
    OnItemClickListener mItemClickListener;

    public ListAdapter( Context context,List<ImageModel> list) {
        this.listimages = list;
        this.mcontext = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item_row, viewGroup, false);
      /*  ViewHolder vh = new ViewHolder(v, new ViewHolder.IMyViewHolderClicks() {
            public void onPotato(View caller) {
                //Log.d("Poh-tah-tos");
                ViewHolder holder = (ViewHolder) caller.getTag();
                int position = holder.getPosition();
                String title=listimages.get(position).getTitle();
                Toast.makeText(mcontext, "Tile is: "+title, Toast.LENGTH_LONG).show();

            };

    });*/

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ImageModel model = listimages.get(i);
        String imageurl=model.getImageurl();
        viewHolder.title.setText(model.getTitle());
        Picasso.with(mcontext).load(imageurl).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return  listimages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title;
        public ImageView image;
        public Context context;


        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            image = (ImageView)itemView.findViewById(R.id.image);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getPosition());
            }
        }

    }


    public interface OnItemClickListener {
        public void onItemClick(View view , int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }


/*    public GridAdapter(Context activity, List<ImageModel> list){

        this.listimages=list;
        this.mcontext=activity;
    }

    @Override
    public int getCount() {
        return listimages.size();
    }

    @Override
    public Object getItem(int position) {
        return listimages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;

        if (convertView == null) {

            holder = new ViewHolder();
            LayoutInflater mInflater = (LayoutInflater) mcontext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.grid_item_row, null);

            holder.image  = (ImageView) convertView.findViewById(R.id.image);
            holder.title = (TextView) convertView.findViewById(R.id.title);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        ImageModel model=listimages.get(position);
        String imageurl=model.getImageurl();
        String title=model.getTitle();
        Log.v(TAG,"Image url is: "+imageurl);
        Log.v(TAG,"title is: "+title);

        holder.title.setText(title);
        Picasso.with(mcontext).load(imageurl).into(holder.image);

        return convertView;
    }

    private static class ViewHolder {
        TextView title;
        ImageView image;

    }*/
}
