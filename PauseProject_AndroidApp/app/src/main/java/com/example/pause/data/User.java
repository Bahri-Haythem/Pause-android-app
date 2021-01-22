package com.example.pause.data;

import androidx.annotation.Nullable;

public class User {
    public String uid;
    public String email;
    public String displayName;
    public String photoURL;
    public boolean emailVerified;
    @Nullable
    public String description;
    @Nullable
    public long createdAt;
    @Nullable
    public int lastLoginAt;
    @Nullable
    public int totalLikes;
    @Nullable
    public String fullName;

    public User(String uid, String email, String displayName, String photoURL, boolean emailVerified) {
        this.uid = uid;
        this.email = email;
        this.displayName = displayName;
        this.photoURL = photoURL;
        this.emailVerified = emailVerified;
    }

    public User(String uid, String email, String displayName, String photoURL, boolean emailVerified, @Nullable String description, long createdAt, int lastLoginAt, int totalLikes, @Nullable String fullName) {
        this.uid = uid;
        this.email = email;
        this.displayName = displayName;
        this.photoURL = photoURL;
        this.emailVerified = emailVerified;
        this.description = description;
        this.createdAt = createdAt;
        this.lastLoginAt = lastLoginAt;
        this.totalLikes = totalLikes;
        this.fullName = fullName;
    }
}
