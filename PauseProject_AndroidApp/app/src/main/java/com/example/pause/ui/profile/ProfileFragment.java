package com.example.pause.ui.profile;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.pause.DescriptionActivity;
import com.example.pause.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.ContentValues.TAG;

public class ProfileFragment extends Fragment {

    public TextView displaynameMain,displayname,email,createdAt,lastLogin,description,totalLikes;
    private FirebaseUser user;
    private FirebaseFirestore db;
    ProgressBar progressBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        displaynameMain = root.findViewById(R.id.text_displayname_main);
        displayname = root.findViewById(R.id.text_displayname);
        totalLikes = root.findViewById(R.id.text_totalLikes);
        email = root.findViewById(R.id.text_email);
        createdAt = root.findViewById(R.id.text_createdat);
        lastLogin = root.findViewById(R.id.text_lastlogin);
        description = root.findViewById(R.id.text_description);
        progressBar = root.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        DrawableCompat.setTint(progressBar.getIndeterminateDrawable(),getResources().getColor(R.color.purple_200));

        description.setOnClickListener(v->{
            Intent intent = new Intent(container.getContext(), DescriptionActivity.class);
            startActivity(intent);
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        db = FirebaseFirestore.getInstance();

        db.collection("users").whereEqualTo("uid",user.getUid()).get().addOnCompleteListener(
                new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            progressBar.setVisibility(View.GONE);
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                totalLikes.setText(document.getData().get("totalLikes").toString());
                                displaynameMain.setText(document.getData().get("displayName").toString());
                                displayname.setText(document.getData().get("displayName").toString());
                                description.setText(document.getData().get("description").toString());
                                email.setText(document.getData().get("email").toString());
                                long creationDate = (long)document.getData().get("createdAt");
                                createdAt.setText(printDate(creationDate));
                                if(document.getData().get("lastLoginAt").toString()=="0"){
                                    lastLogin.setText("this is your first login");
                                }else{
                                    long lastlogin = (long)document.getData().get("lastLoginAt");
                                    lastLogin.setText(printDate(lastlogin));
                                }
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                }
        );

        displayname.setText(user.getDisplayName());

        return root;
    }

    String printDate(long creationDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(creationDate);
        return dateFormat.format(date);
    }

    @Override
    public void onResume() {
        super.onResume();
        db.collection("users").whereEqualTo("uid",user.getUid()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        description.setText(document.getData().get("description").toString());
                    }
                }
            }
        });

        //getActivity().getSupportFragmentManager().beginTransaction().replace(ProfileFragment.this.getId(), new ProfileFragment()).commit();
        //getActivity().getWindow().getDecorView().findViewById(R.id.text_description).invalidate();
    }
}