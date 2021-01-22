package com.example.pause.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pause.R;
import com.example.pause.data.Games;
import com.example.pause.data.ImgDataClass;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.MyViewHolder> {

    public Games games;
    public ArrayList<ImgDataClass> data;
    public Context context;

    public GameListAdapter(Context context,Games games,ArrayList<ImgDataClass> data) {
        this.games = games;
        this.data = data;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tv;
        public ImageView iv,nextImageView;
        public CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.gameTextView);
            iv = itemView.findViewById(R.id.imageView2);
            cardView = itemView.findViewById(R.id.game_card_view);
            nextImageView = itemView.findViewById(R.id.nextImageView);
            for(Games.Result game:games.results){
                data.add(new ImgDataClass(game.backgroundImage));
            }
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.game_view, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv.setText(games.results.get(position).name);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GameActivity.class);
                intent.putExtra("data", games.results.get(position));
                context.startActivity(intent);
            }
        });

        Picasso.with(context).load(games.results.get(position).backgroundImage)
                .resize(215,120)
                .centerCrop()
                .into(holder.iv);

    }

    @Override
    public int getItemCount() {
        return games.results.size();
    }
}
