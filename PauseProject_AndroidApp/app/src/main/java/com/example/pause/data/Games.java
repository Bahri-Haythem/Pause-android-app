package com.example.pause.data;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Games {

    @SerializedName("count")
    @Expose
    public Integer count;
    @SerializedName("results")
    @Expose
    public List<Result> results = null;

    public Games(Integer count, List<Result> results) {
        this.count = count;
        this.results = results;
    }

    public class Genre implements Serializable {

        @SerializedName("name")
        @Expose
        public String name;

    }
    public class Platform implements  Serializable {

        @SerializedName("platform")
        @Expose
        public Platform_ platform;

    }
    public class Platform_ implements Serializable {

        @SerializedName("name")
        @Expose
        public String name;

    }
    public static class Result implements Serializable {

        @SerializedName("gameId")
        @Expose
        public Integer gameId;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("released")
        @Expose
        public String released;
        @SerializedName("background_image")
        @Expose
        public String backgroundImage;
        @SerializedName("rating")
        @Expose
        public Double rating;
        @SerializedName("playTime")
        @Expose
        public Integer playTime;
        @SerializedName("platforms")
        @Expose
        public List<Platform> platforms = null;
        @SerializedName("genres")
        @Expose
        public List<Genre> genres = null;
        @SerializedName("tags")
        @Expose
        public List<Tag> tags = null;

        public Result(Integer gameId, String name) {
            this.gameId = gameId;
            this.name = name;
        }
    }
    public class Tag implements Serializable {

        @SerializedName("name")
        @Expose
        public String name;

    }

}
