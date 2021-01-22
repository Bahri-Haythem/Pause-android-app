package com.example.pause.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pause.R;
import com.example.pause.data.Games;
import com.example.pause.data.ImgDataClass;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class HomeFragment extends Fragment {

    Button btnPrevious,btnNext;
    TextView homeText;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    public static int pageNumber = 1;

    ArrayList<ImgDataClass> data = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        progressBar = root.findViewById(R.id.progressBarGames);
        homeText = root.findViewById(R.id.text_home);

        recyclerView.setHasFixedSize(true);
        DrawableCompat.setTint(progressBar.getIndeterminateDrawable(),
                root.getResources().getColor(R.color.purple_200));

        new Upload(root.getContext(),recyclerView,progressBar).execute();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        /*Games.Result result = new Games.Result(1,"cj");
        Games.Result result2 = new Games.Result(2,"big smoke");
        List<Games.Result> l = new List<Games.Result>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(@Nullable Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Games.Result> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] a) {
                return null;
            }

            @Override
            public boolean add(Games.Result result) {
                return false;
            }

            @Override
            public boolean remove(@Nullable Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends Games.Result> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NonNull Collection<? extends Games.Result> c) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Games.Result get(int index) {
                return null;
            }

            @Override
            public Games.Result set(int index, Games.Result element) {
                return null;
            }

            @Override
            public void add(int index, Games.Result element) {

            }

            @Override
            public Games.Result remove(int index) {
                return null;
            }

            @Override
            public int indexOf(@Nullable Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(@Nullable Object o) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<Games.Result> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Games.Result> listIterator(int index) {
                return null;
            }

            @NonNull
            @Override
            public List<Games.Result> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        l.add(result);
        l.add(result2);
        Games games = new Games(11, l);
        GameListAdapter gameListAdapter = new GameListAdapter(root.getContext(),games,data);
        recyclerView.setAdapter(gameListAdapter);*/

        btnPrevious = root.findViewById(R.id.buttonPrevious);
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pageNumber>1){
                    pageNumber--;
                    homeText.setText("Games ("+ pageNumber +")");
                    new Upload(root.getContext(),recyclerView,progressBar).execute();
                }else{
                    Snackbar.make(v, "you are on the first page", Snackbar.LENGTH_LONG)
                            .setAction("Error", null).show();
                }
            }
        });

        btnNext = root.findViewById(R.id.buttonNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageNumber++;
                homeText.setText("Games ("+ pageNumber +")");
                new Upload(root.getContext(),recyclerView,progressBar).execute();
            }
        });
        return root;
    }
}