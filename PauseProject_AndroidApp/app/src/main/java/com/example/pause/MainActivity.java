package com.example.pause;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.example.pause.ui.home.GameActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Date;

import angtrim.com.fivestarslibrary.FiveStarsDialog;
import angtrim.com.fivestarslibrary.NegativeReviewListener;
import angtrim.com.fivestarslibrary.ReviewListener;

public class MainActivity extends AppCompatActivity implements NegativeReviewListener, ReviewListener {

    private static final String TAG = GameActivity.class.getName();

    private AppBarConfiguration mAppBarConfiguration;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private TextView username,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_profile, R.id.nav_recommended)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        mAuth = FirebaseAuth.getInstance();
        Menu menu = navigationView.getMenu();

        menu.getItem(3).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                mAuth.signOut();

                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                finish();
                startActivity(intent);

                return false;
            }
        });
    }

    angtrim.com.fivestarslibrary.NegativeReviewListener negativeReviewListener = this::onNegativeReview;
    angtrim.com.fivestarslibrary.ReviewListener reviewListener = this::onReview;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_rate_my_app){
            FiveStarsDialog fiveStarsDialog = new FiveStarsDialog(MainActivity.this,"haythembahri@ieee.org");
            fiveStarsDialog.setRateText("select a rating for this App")
                    .setTitle("App rating")
                    .setForceMode(false)
                    // Market opened if a rating >= 2 is selected
                    .setUpperBound(2)
                    // OVERRIDE mail intent for negative review
                    .setNegativeReviewListener(negativeReviewListener)
                    // Used to listen for reviews (if you want to track them )
                    .setReviewListener(reviewListener)
                    .showAfter(0);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNegativeReview(int i) {
        Log.d(TAG, "haythem Negative review " + i);
    }

    @Override
    public void onReview(int i) {
        Log.d(TAG, "haythem Review " + i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        email = findViewById(R.id.emailTextViewHeader);
        username = findViewById(R.id.userNameTextViewHeader);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users").whereEqualTo("uid",user.getUid()).get().addOnCompleteListener(
                new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if(user!=null){
                                    email.setText(user.getEmail());
                                    username.setText(document.getData().get("displayName").toString());
                                }

                            }
                        }
                    }
                }
        );
        /*if(user!=null){
            email.setText(user.getEmail());
            username.setText(user.getDisplayName());
        }*/

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        FirebaseFirestore db;
        db = FirebaseFirestore.getInstance();
        db.collection("users").document(user.getUid())
                .update("lastLoginAt",new Date().getTime());
        super.onDestroy();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}