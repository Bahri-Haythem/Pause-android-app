package com.example.pause.ui.home;

import android.content.Intent;
import android.os.Bundle;

import com.example.pause.data.Games;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pause.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import me.gujun.android.taggroup.TagGroup;


public class GameActivity extends AppCompatActivity  {

    TextView Title,Rating,PlayTime,Release;
    ImageView imageView;
    Games.Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Title = findViewById(R.id.textViewTitle);
        Rating = findViewById(R.id.textViewRating);
        PlayTime = findViewById(R.id.textViewPlayTime);
        imageView = findViewById(R.id.gameImageView);
        Release = findViewById(R.id.textViewReleaseDate);
        TagGroup Tags = (TagGroup)findViewById(R.id.tag_group);
        TagGroup Platforms = (TagGroup)findViewById(R.id.platform_group);
        TagGroup Genres = (TagGroup)findViewById(R.id.Genre_group);


        Intent intent = getIntent();
        if(intent.getExtras()!=null){
            result = (Games.Result) intent.getSerializableExtra("data");
            Title.setText(result.name);
            Rating.setText(result.rating+" / 5");
            PlayTime.setText(result.playTime+" h");
            Release.setText(result.released.substring(0,10));

            ArrayList<String> platforms = new ArrayList<>(),genres = new ArrayList<>(),tags = new ArrayList<>();

            for (Games.Platform platform:result.platforms
            ) {
                Games.Platform_ platform_ =platform.platform;
                platforms.add(platform_.name+" ");
            }
            Platforms.setTags(platforms);

            for (Games.Genre genre:result.genres
            ) {
                genres.add(genre.name+" ");
            }
            Genres.setTags(genres);

            for (Games.Tag tag:result.tags
                 ) {
                tags.add(tag.name+" ");
            }
            Tags.setTags(tags);

            Picasso.with(GameActivity.this).load(result.backgroundImage)
                    .resize(215,120)
                    .centerCrop()
                    .into(imageView);
            getSupportActionBar().setTitle(result.name);
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RatingDialog ratingDialog = new RatingDialog(GameActivity.this,result.gameId);
                ratingDialog.show();
            }
        });
    }


}