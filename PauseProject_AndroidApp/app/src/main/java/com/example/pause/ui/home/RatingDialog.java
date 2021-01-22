package com.example.pause.ui.home;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.pause.R;
import com.example.pause.data.GameStar;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class RatingDialog extends Dialog implements View.OnClickListener {

    Context context;
    public Button yes, no;
    ImageView s1,s2,s3,s4,s5;
    ImageView [] stars;
    int rating=0;
    FirebaseFirestore db;
    int gameID;

    public RatingDialog(@NonNull Context context,int gameID) {
        super(context);
        this.context = context;
        this.gameID = gameID;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_rating);

        db = FirebaseFirestore.getInstance();
        String userID = FirebaseAuth.getInstance().getUid();
        yes = findViewById(R.id.btn_yes);
        no = findViewById(R.id.btn_no);
        yes.setOnClickListener(v->{
            //action to perform when rating is selected
            GameStar gameStar = new GameStar(gameID,userID,rating);
            db.collection("gameStars").document(userID+"_"+gameID)
                    .set(gameStar);
            db.collection("users").whereEqualTo("uid",userID).get().addOnCompleteListener(
                    new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    int nblikes = Integer.parseInt(document.getData().get("totalLikes").toString());
                                    nblikes++;
                                    db.collection("users").document(userID)
                                            .update("totalLikes",nblikes);
                                }
                            }
                        }
                    }
            );
            dismiss();
        });
        no.setOnClickListener(v->{
            //dismiss dialog window
            dismiss();
        });
        s1 = findViewById(R.id.ratingStar1);
        s2 = findViewById(R.id.ratingStar2);
        s3 = findViewById(R.id.ratingStar3);
        s4 = findViewById(R.id.ratingStar4);
        s5 = findViewById(R.id.ratingStar5);
        s1.setOnClickListener(this);
        s2.setOnClickListener(this);
        s3.setOnClickListener(this);
        s4.setOnClickListener(this);
        s5.setOnClickListener(this);
        stars = new ImageView[]{s1,s2,s3,s4,s5};
        clear();
    }

    void clear(){
        for(ImageView s:stars){
            s.setImageResource(R.drawable.star);
        }
    }

    @Override
    public void onClick(View v) {
        clear();
        switch (v.getId()) {
            case R.id.ratingStar1:
                rating = 1;
                break;
            case R.id.ratingStar2:
                rating = 2;
                break;
            case R.id.ratingStar3:
                rating = 3;
                break;
            case R.id.ratingStar4:
                rating = 4;
                break;
            case R.id.ratingStar5:
                rating = 5;
                break;
        }
        for(int i=0;i<rating;i++){
            stars[i].setImageResource(R.drawable.star_filled);
        }
    }
}
