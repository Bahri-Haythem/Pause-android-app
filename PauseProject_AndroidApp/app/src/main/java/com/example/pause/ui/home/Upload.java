package com.example.pause.ui.home;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pause.JsonParser;
import com.example.pause.data.Games;
import com.example.pause.data.ImgDataClass;
import com.example.pause.ui.home.GameListAdapter;
import com.example.pause.ui.home.HomeFragment;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Upload extends AsyncTask {

    public Games games;
    public static String stringResult;
    public RecyclerView recyclerView;
    public Context context;
    public ProgressBar progressBar;
    ArrayList<ImgDataClass> data= new ArrayList<>();

    public Upload(Context context, RecyclerView recyclerView, ProgressBar progressBar) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.progressBar = progressBar;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        GameListAdapter gameListAdapter = new GameListAdapter(context,games,data);
        recyclerView.setAdapter(gameListAdapter);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        recyclerView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected Games doInBackground(Object[] objects) {
        String ip = "10.0.2.2";
        String url="http://"+ip+":5000/api/games/"+ HomeFragment.pageNumber;

        stringResult = JsonParser.makeRequest(url);
        publishProgress(1);

        Gson gson = new Gson();
        Games games = gson.fromJson(stringResult,Games.class);
        this.games = games;

        for(Games.Result game:games.results){
            data.add(new ImgDataClass(game.backgroundImage));
        }

        return games;
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
        if(values[0]==(Object) 1){
            recyclerView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }
}
