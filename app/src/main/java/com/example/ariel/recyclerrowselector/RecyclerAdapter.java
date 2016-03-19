package com.example.ariel.recyclerrowselector;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ariel on 3/10/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public int getListPosition(){
        return this.listPosition;
    }


    int listPosition = 0;
    ArrayList<String> array = new ArrayList<>();

    //holds reference to each view in recyclerview so we can select and deselect them
    ArrayList<View> viewArrayList;


    public RecyclerAdapter(ArrayList<String> array){

        this.array = array;
        viewArrayList = new ArrayList<>();


    }



    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        ViewHolder vh = new ViewHolder(v);

       //if our arraylist is empty which means this is the first view set it as selected
        if(!viewArrayList.isEmpty()) {
            viewArrayList.get(0).setSelected(true);
        }

        //each time we instantiate a view add it to the view array
        viewArrayList.add(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapter.ViewHolder holder, final int position) {


        holder.textView.setText(array.get(position));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listPosition = position;
                holder.textView.setSelected(true);
                for(int i = 0 ; i < array.size(); i++){
                    if(i==position){
                        viewArrayList.get(position).setSelected(true);
                    }else{
                        viewArrayList.get(i).setSelected(false);
                    }
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return array.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View view;
        TextView textView;
        public ViewHolder(View v) {
            super(v);
            view = v;
            textView = (TextView) v.findViewById(R.id.textView);

        }
    }



}