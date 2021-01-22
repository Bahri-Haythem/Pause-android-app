package com.example.pause.ui.recommended;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pause.JsonParser;
import com.example.pause.R;
import com.example.pause.data.Game;
import com.example.pause.data.Games;
import com.example.pause.data.ImgDataClass;
import com.example.pause.ui.home.GameListAdapter;
import com.example.pause.ui.home.HomeFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;

import org.w3c.dom.CDATASection;

import java.util.ArrayList;

public class UploadRecommended extends AsyncTask {

    public int [] recommendedGames;
    public static String stringResult;
    public Context context;
    RecyclerView recommendedGameList;
    public ArrayList<Game> gameList = new ArrayList<>();

    public ProgressBar progressBar;
    public TextView textView;

    public UploadRecommended(Context context, RecyclerView recommendedGameList, ProgressBar progressBar, TextView textView) {
        this.context = context;
        this.recommendedGameList = recommendedGameList;
        this.progressBar = progressBar;
        this.textView = textView;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        RecommendedGamesAdapter recommendedGamesAdapter = new RecommendedGamesAdapter(gameList, context);
        recommendedGameList.setAdapter(recommendedGamesAdapter);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setVisibility(View.GONE);
        textView.setVisibility(View.GONE);
    }

    @Override
    protected ArrayList<Game> doInBackground(Object[] objects) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String ip = "10.0.2.2";
        String url="http://"+ip+":5000/api/Recommender/"+ user.getUid();
        stringResult = JsonParser.makeRequest(url);
        Gson gson = new Gson();
        recommendedGames = gson.fromJson(stringResult,int[].class);

        gameList = new ArrayList<>();
        if(recommendedGames.length==0){
            publishProgress(1);
            return gameList;
        }else{
            publishProgress(2);
        }
        for(int i:recommendedGames) {
            String ip2 = "10.0.2.2";
            String url2="http://"+ip2+":5000/api/game/" + i;

            String stringResult2 = JsonParser.makeRequest(url2);
            Gson gson2 = new Gson();
            Game game = gson2.fromJson(stringResult2, Game.class);
            gameList.add(game);
        }
        publishProgress(3);
        return gameList;
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
        if (values[0]==(Object)1){
            progressBar.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        }
        if (values[0]==(Object)2){
            progressBar.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
        }
        if (values[0]==(Object)3){
            progressBar.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);
        }
    }
}
