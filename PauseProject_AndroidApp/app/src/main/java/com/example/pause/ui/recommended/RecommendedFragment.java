package com.example.pause.ui.recommended;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pause.R;
import com.example.pause.data.Game;
import com.example.pause.data.Games;
import com.example.pause.data.ImgDataClass;
import com.example.pause.ui.home.GameListAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class RecommendedFragment extends Fragment {

    RecyclerView recommendedGames;
    ProgressBar progressBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_recommended, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        textView.setText("you must like some games for recommendation");
        recommendedGames = root.findViewById(R.id.recommended_games);
        progressBar = root.findViewById(R.id.progressBar2);
        DrawableCompat.setTint(progressBar.getIndeterminateDrawable(),
                root.getResources().getColor(R.color.purple_200));

        new UploadRecommended(this.getContext(),recommendedGames,progressBar,textView).execute();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(root.getContext());
        recommendedGames.setLayoutManager(linearLayoutManager);

        return root;
    }
}