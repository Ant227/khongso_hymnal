package com.deveant.broahlemkhng.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.deveant.broahlemkhng.LyricActivity;
import com.deveant.broahlemkhng.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private ArrayList<String> songList;
    private EditText search;

    private int row_index = -1;



    public Adapter(Context context, ArrayList<String> songList,EditText search) {
        this.context = context;
        this.songList = songList;
        this.search = search;

    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.song_layout,parent,false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Adapter.MyViewHolder holder, final int position) {

        if(position %2 == 1)
        { holder.cardView.setBackgroundColor(Color.parseColor("#D3FBFBFB")); }
        else
        { holder.cardView.setBackgroundColor(Color.parseColor("#FFFFFF")); }


        holder.songName.setText(songList.get(position).replace("_",""));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(context, LyricActivity.class);
                intent.putExtra("songNameTitle", holder.songName.getText().toString());
                context.startActivity(intent);
                search.clearFocus();

                row_index=position;
                notifyDataSetChanged();

            }
        });
        if(row_index==position){
            holder.cardView.setBackgroundColor(context.getResources().getColor(R.color.colorSelected));

        }
        else
        {
            if(position %2 == 1)
            { holder.cardView.setBackgroundColor(Color.parseColor("#D3FBFBFB")); }
            else
            { holder.cardView.setBackgroundColor(Color.parseColor("#FFFFFF")); }
        }


    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView songName;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            songName = itemView.findViewById(R.id.song_layout_song_name);
            cardView = itemView.findViewById(R.id.song_layout_card_view);
        }
    }

    public void filterList(ArrayList<String>  filteredList){
         songList = filteredList;
         notifyDataSetChanged();
    }
}
