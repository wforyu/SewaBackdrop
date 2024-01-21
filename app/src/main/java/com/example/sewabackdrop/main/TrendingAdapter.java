package com.example.sewabackdrop.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sewabackdrop.R;

import java.util.List;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder>{

    List<ModelTrending> modelTrendingList;
    Context ctx;

    public TrendingAdapter(Context context, List<ModelTrending> items){
        this.ctx = context;
        this.modelTrendingList = items;
    }

    @Override
    public TrendingAdapter.ViewHolder onCreatViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_trending,parent,false);
        return new TrendingAdapter.ViewHolder(view);
    }
}
