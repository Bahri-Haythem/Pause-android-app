package com.example.pause.ui.recommended;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pause.R;
import com.example.pause.data.Game;
import com.example.pause.data.Games;
import com.example.pause.ui.home.GameActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import me.gujun.android.taggroup.TagGroup;

public class RecommendedGameActivity extends AppCompatActivity {

    Game game;
    TextView Title,Rating,PlayTime,Release,Description,Url;
    ImageView imageView,imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended_game);

        Url = findViewById(R.id.textViewURLLink);
        Title = findViewById(R.id.textViewTitle);
        Description = findViewById(R.id.description);
        Rating = findViewById(R.id.textViewRating);
        PlayTime = findViewById(R.id.textViewPlayTime);
        imageView = findViewById(R.id.gameImageView);
        imageView2 = findViewById(R.id.gameImageView2);
        Release = findViewById(R.id.textViewReleaseDate);
        TagGroup Tags = findViewById(R.id.tag_group);
        TagGroup Platforms = findViewById(R.id.platform_group);
        TagGroup Genres = findViewById(R.id.Genre_group);

        Intent intent = getIntent();
        if(intent.getExtras()!=null) {
            game = (Game) intent.getSerializableExtra("data");
            Title.setText(game.getName());
            Url.setText(game.getWebsite());
            Rating.setText(game.getRating()+" / 5");
            PlayTime.setText(game.getPlaytime()+" h");
            Description.setText(game.getDescriptionRaw());
            Release.setText(game.getReleased().substring(0,10));

            ArrayList<String> platforms = new ArrayList<>(),genres = new ArrayList<>(),tags = new ArrayList<>();

            for (Game.Platform_ platform:game.getPlatforms()
            ) {
                Game.Platform__ platform_ = platform.getPlatform();
                platforms.add(platform_.getName()+" ");
            }
            Platforms.setTags(platforms);

            for (Game.Genre genre:game.getGenres()
            ) {
                genres.add(genre.getName()+" ");
            }
            Genres.setTags(genres);

            for (Game.Tag tag:game.getTags()
            ) {
                tags.add(tag.getName()+" ");
            }
            Tags.setTags(tags);

            Picasso.with(RecommendedGameActivity.this).load(game.getBackgroundImage())
                    .resize(215,120)
                    .centerCrop()
                    .into(imageView);
            Picasso.with(RecommendedGameActivity.this).load(game.getBackgroundImageAdditional())
                    .resize(215,120)
                    .centerCrop()
                    .into(imageView2);
            getSupportActionBar().setTitle(game.getName());
        }

    }
}