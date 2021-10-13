package com.example.market_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class ItemAdapter extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> haircuts=new ArrayList<String>();
    ArrayList<Integer> costs=new ArrayList<Integer>();
    ArrayList<Integer> pictures=new ArrayList<Integer>();


    public ItemAdapter(Context context,ArrayList<String> haircuts, ArrayList<Integer> costs,ArrayList<Integer> pictures) {
        super(context, R.layout.single_item,R.id.title,haircuts);
        this.context=context;
        this.haircuts=haircuts;
        this.costs=costs;
        this.pictures=pictures;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View singleItem=convertView;
        ItemViewHolder holder=null;
        if(singleItem == null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            singleItem=layoutInflater.inflate(R.layout.single_item,parent,false);
            holder=new ItemViewHolder(singleItem);
            singleItem.setTag(holder);
        }
        else
        {
            holder= (ItemViewHolder) singleItem.getTag();
        }

        holder.image.setImageResource(pictures.get(position));
        holder.title.setText(haircuts.get(position));
        holder.description.setText("Cost:" + Integer.toString(costs.get(position)));
        return singleItem;
    }
}
