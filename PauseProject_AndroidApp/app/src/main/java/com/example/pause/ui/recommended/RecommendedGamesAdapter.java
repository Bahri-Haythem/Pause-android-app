package com.example.pause.ui.recommended;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pause.R;
import com.example.pause.data.Game;
import com.example.pause.data.Games;
import com.example.pause.data.ImgDataClass;
import com.example.pause.ui.home.GameActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecommendedGamesAdapter extends RecyclerView.Adapter<RecommendedGamesAdapter.MyViewHolder> {

    public ArrayList<Game> gameList;
    public Context context;

    public RecommendedGamesAdapter(ArrayList<Game> gameList, Context context) {
        this.gameList = gameList;
        this.context = context;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tv;
        public ImageView iv,nextImageView;
        public CardView gameCardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.gameTextView);
            iv = itemView.findViewById(R.id.imageView2);
            nextImageView = itemView.findViewById(R.id.nextImageView);
            gameCardView = itemView.findViewById(R.id.game_card_view);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.game_view, parent, false);

        MyViewHolder vh = new RecommendedGamesAdapter.MyViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv.setText(gameList.get(position).getName());
        holder.gameCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RecommendedGameActivity.class);
                intent.putExtra("data", gameList.get(position));
                context.startActivity(intent);
            }
        });

        Picasso.with(context).load(gameList.get(position).getBackgroundImage())
                .resize(215,120)
                .centerCrop()
                .into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }
}
