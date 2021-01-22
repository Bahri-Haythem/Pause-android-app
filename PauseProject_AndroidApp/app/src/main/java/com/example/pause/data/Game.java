package com.example.pause.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class Game implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_original")
    @Expose
    private String nameOriginal;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("metacritic")
    @Expose
    private Integer metacritic;
    @SerializedName("metacritic_platforms")
    @Expose
    private List<Object> metacriticPlatforms = null;
    @SerializedName("released")
    @Expose
    private String released;
    @SerializedName("tba")
    @Expose
    private Boolean tba;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("background_image")
    @Expose
    private String backgroundImage;
    @SerializedName("background_image_additional")
    @Expose
    private String backgroundImageAdditional;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("rating_top")
    @Expose
    private Integer ratingTop;
    @SerializedName("ratings")
    @Expose
    private List<Rating> ratings = null;
    @SerializedName("reactions")
    @Expose
    private Reactions reactions;
    @SerializedName("added")
    @Expose
    private Integer added;
    @SerializedName("added_by_status")
    @Expose
    private AddedByStatus addedByStatus;
    @SerializedName("playtime")
    @Expose
    private Integer playtime;
    @SerializedName("screenshots_count")
    @Expose
    private Integer screenshotsCount;
    @SerializedName("movies_count")
    @Expose
    private Integer moviesCount;
    @SerializedName("creators_count")
    @Expose
    private Integer creatorsCount;
    @SerializedName("achievements_count")
    @Expose
    private Integer achievementsCount;
    @SerializedName("parent_achievements_count")
    @Expose
    private Integer parentAchievementsCount;
    @SerializedName("reddit_url")
    @Expose
    private String redditUrl;
    @SerializedName("reddit_name")
    @Expose
    private String redditName;
    @SerializedName("reddit_description")
    @Expose
    private String redditDescription;
    @SerializedName("reddit_logo")
    @Expose
    private String redditLogo;
    @SerializedName("reddit_count")
    @Expose
    private Integer redditCount;
    @SerializedName("twitch_count")
    @Expose
    private Integer twitchCount;
    @SerializedName("youtube_count")
    @Expose
    private Integer youtubeCount;
    @SerializedName("reviews_text_count")
    @Expose
    private Integer reviewsTextCount;
    @SerializedName("ratings_count")
    @Expose
    private Integer ratingsCount;
    @SerializedName("suggestions_count")
    @Expose
    private Integer suggestionsCount;
    @SerializedName("alternative_names")
    @Expose
    private List<Object> alternativeNames = null;
    @SerializedName("metacritic_url")
    @Expose
    private String metacriticUrl;
    @SerializedName("parents_count")
    @Expose
    private Integer parentsCount;
    @SerializedName("additions_count")
    @Expose
    private Integer additionsCount;
    @SerializedName("game_series_count")
    @Expose
    private Integer gameSeriesCount;
    @SerializedName("user_game")
    @Expose
    private Object userGame;
    @SerializedName("reviews_count")
    @Expose
    private Integer reviewsCount;
    @SerializedName("saturated_color")
    @Expose
    private String saturatedColor;
    @SerializedName("dominant_color")
    @Expose
    private String dominantColor;
    @SerializedName("parent_platforms")
    @Expose
    private List<ParentPlatform> parentPlatforms = null;
    @SerializedName("platforms")
    @Expose
    private List<Platform_> platforms = null;
    @SerializedName("stores")
    @Expose
    private List<Store> stores = null;
    @SerializedName("developers")
    @Expose
    private List<Developer> developers = null;
    @SerializedName("genres")
    @Expose
    private List<Genre> genres = null;
    @SerializedName("tags")
    @Expose
    private List<Tag> tags = null;
    @SerializedName("publishers")
    @Expose
    private List<Publisher> publishers = null;
    @SerializedName("esrb_rating")
    @Expose
    private EsrbRating esrbRating;
    @SerializedName("clip")
    @Expose
    private Clip clip;
    @SerializedName("description_raw")
    @Expose
    private String descriptionRaw;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOriginal() {
        return nameOriginal;
    }

    public void setNameOriginal(String nameOriginal) {
        this.nameOriginal = nameOriginal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(Integer metacritic) {
        this.metacritic = metacritic;
    }

    public List<Object> getMetacriticPlatforms() {
        return metacriticPlatforms;
    }

    public void setMetacriticPlatforms(List<Object> metacriticPlatforms) {
        this.metacriticPlatforms = metacriticPlatforms;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public Boolean getTba() {
        return tba;
    }

    public void setTba(Boolean tba) {
        this.tba = tba;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getBackgroundImageAdditional() {
        return backgroundImageAdditional;
    }

    public void setBackgroundImageAdditional(String backgroundImageAdditional) {
        this.backgroundImageAdditional = backgroundImageAdditional;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getRatingTop() {
        return ratingTop;
    }

    public void setRatingTop(Integer ratingTop) {
        this.ratingTop = ratingTop;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public Reactions getReactions() {
        return reactions;
    }

    public void setReactions(Reactions reactions) {
        this.reactions = reactions;
    }

    public Integer getAdded() {
        return added;
    }

    public void setAdded(Integer added) {
        this.added = added;
    }

    public AddedByStatus getAddedByStatus() {
        return addedByStatus;
    }

    public void setAddedByStatus(AddedByStatus addedByStatus) {
        this.addedByStatus = addedByStatus;
    }

    public Integer getPlaytime() {
        return playtime;
    }

    public void setPlaytime(Integer playtime) {
        this.playtime = playtime;
    }

    public Integer getScreenshotsCount() {
        return screenshotsCount;
    }

    public void setScreenshotsCount(Integer screenshotsCount) {
        this.screenshotsCount = screenshotsCount;
    }

    public Integer getMoviesCount() {
        return moviesCount;
    }

    public void setMoviesCount(Integer moviesCount) {
        this.moviesCount = moviesCount;
    }

    public Integer getCreatorsCount() {
        return creatorsCount;
    }

    public void setCreatorsCount(Integer creatorsCount) {
        this.creatorsCount = creatorsCount;
    }

    public Integer getAchievementsCount() {
        return achievementsCount;
    }

    public void setAchievementsCount(Integer achievementsCount) {
        this.achievementsCount = achievementsCount;
    }

    public Integer getParentAchievementsCount() {
        return parentAchievementsCount;
    }

    public void setParentAchievementsCount(Integer parentAchievementsCount) {
        this.parentAchievementsCount = parentAchievementsCount;
    }

    public String getRedditUrl() {
        return redditUrl;
    }

    public void setRedditUrl(String redditUrl) {
        this.redditUrl = redditUrl;
    }

    public String getRedditName() {
        return redditName;
    }

    public void setRedditName(String redditName) {
        this.redditName = redditName;
    }

    public String getRedditDescription() {
        return redditDescription;
    }

    public void setRedditDescription(String redditDescription) {
        this.redditDescription = redditDescription;
    }

    public String getRedditLogo() {
        return redditLogo;
    }

    public void setRedditLogo(String redditLogo) {
        this.redditLogo = redditLogo;
    }

    public Integer getRedditCount() {
        return redditCount;
    }

    public void setRedditCount(Integer redditCount) {
        this.redditCount = redditCount;
    }

    public Integer getTwitchCount() {
        return twitchCount;
    }

    public void setTwitchCount(Integer twitchCount) {
        this.twitchCount = twitchCount;
    }

    public Integer getYoutubeCount() {
        return youtubeCount;
    }

    public void setYoutubeCount(Integer youtubeCount) {
        this.youtubeCount = youtubeCount;
    }

    public Integer getReviewsTextCount() {
        return reviewsTextCount;
    }

    public void setReviewsTextCount(Integer reviewsTextCount) {
        this.reviewsTextCount = reviewsTextCount;
    }

    public Integer getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(Integer ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public Integer getSuggestionsCount() {
        return suggestionsCount;
    }

    public void setSuggestionsCount(Integer suggestionsCount) {
        this.suggestionsCount = suggestionsCount;
    }

    public List<Object> getAlternativeNames() {
        return alternativeNames;
    }

    public void setAlternativeNames(List<Object> alternativeNames) {
        this.alternativeNames = alternativeNames;
    }

    public String getMetacriticUrl() {
        return metacriticUrl;
    }

    public void setMetacriticUrl(String metacriticUrl) {
        this.metacriticUrl = metacriticUrl;
    }

    public Integer getParentsCount() {
        return parentsCount;
    }

    public void setParentsCount(Integer parentsCount) {
        this.parentsCount = parentsCount;
    }

    public Integer getAdditionsCount() {
        return additionsCount;
    }

    public void setAdditionsCount(Integer additionsCount) {
        this.additionsCount = additionsCount;
    }

    public Integer getGameSeriesCount() {
        return gameSeriesCount;
    }

    public void setGameSeriesCount(Integer gameSeriesCount) {
        this.gameSeriesCount = gameSeriesCount;
    }

    public Object getUserGame() {
        return userGame;
    }

    public void setUserGame(Object userGame) {
        this.userGame = userGame;
    }

    public Integer getReviewsCount() {
        return reviewsCount;
    }

    public void setReviewsCount(Integer reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public String getSaturatedColor() {
        return saturatedColor;
    }

    public void setSaturatedColor(String saturatedColor) {
        this.saturatedColor = saturatedColor;
    }

    public String getDominantColor() {
        return dominantColor;
    }

    public void setDominantColor(String dominantColor) {
        this.dominantColor = dominantColor;
    }

    public List<ParentPlatform> getParentPlatforms() {
        return parentPlatforms;
    }

    public void setParentPlatforms(List<ParentPlatform> parentPlatforms) {
        this.parentPlatforms = parentPlatforms;
    }

    public List<Platform_> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform_> platforms) {
        this.platforms = platforms;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    public EsrbRating getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(EsrbRating esrbRating) {
        this.esrbRating = esrbRating;
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }

    public String getDescriptionRaw() {
        return descriptionRaw;
    }

    public void setDescriptionRaw(String descriptionRaw) {
        this.descriptionRaw = descriptionRaw;
    }



    public class AddedByStatus implements Serializable {

        @SerializedName("yet")
        @Expose
        private Integer yet;
        @SerializedName("owned")
        @Expose
        private Integer owned;
        @SerializedName("beaten")
        @Expose
        private Integer beaten;
        @SerializedName("toplay")
        @Expose
        private Integer toplay;
        @SerializedName("dropped")
        @Expose
        private Integer dropped;
        @SerializedName("playing")
        @Expose
        private Integer playing;

        public Integer getYet() {
            return yet;
        }

        public void setYet(Integer yet) {
            this.yet = yet;
        }

        public Integer getOwned() {
            return owned;
        }

        public void setOwned(Integer owned) {
            this.owned = owned;
        }

        public Integer getBeaten() {
            return beaten;
        }

        public void setBeaten(Integer beaten) {
            this.beaten = beaten;
        }

        public Integer getToplay() {
            return toplay;
        }

        public void setToplay(Integer toplay) {
            this.toplay = toplay;
        }

        public Integer getDropped() {
            return dropped;
        }

        public void setDropped(Integer dropped) {
            this.dropped = dropped;
        }

        public Integer getPlaying() {
            return playing;
        }

        public void setPlaying(Integer playing) {
            this.playing = playing;
        }

    }

    public class Clip implements Serializable {

        @SerializedName("clip")
        @Expose
        private String clip;
        @SerializedName("clips")
        @Expose
        private Clips clips;
        @SerializedName("video")
        @Expose
        private String video;
        @SerializedName("preview")
        @Expose
        private String preview;

        public String getClip() {
            return clip;
        }

        public void setClip(String clip) {
            this.clip = clip;
        }

        public Clips getClips() {
            return clips;
        }

        public void setClips(Clips clips) {
            this.clips = clips;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getPreview() {
            return preview;
        }

        public void setPreview(String preview) {
            this.preview = preview;
        }

    }

    public class Clips implements Serializable {

        @SerializedName("320")
        @Expose
        private String _320;
        @SerializedName("640")
        @Expose
        private String _640;
        @SerializedName("full")
        @Expose
        private String full;

        public String get320() {
            return _320;
        }

        public void set320(String _320) {
            this._320 = _320;
        }

        public String get640() {
            return _640;
        }

        public void set640(String _640) {
            this._640 = _640;
        }

        public String getFull() {
            return full;
        }

        public void setFull(String full) {
            this.full = full;
        }

    }

    public class Developer implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("games_count")
        @Expose
        private Integer gamesCount;
        @SerializedName("image_background")
        @Expose
        private String imageBackground;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public Integer getGamesCount() {
            return gamesCount;
        }

        public void setGamesCount(Integer gamesCount) {
            this.gamesCount = gamesCount;
        }

        public String getImageBackground() {
            return imageBackground;
        }

        public void setImageBackground(String imageBackground) {
            this.imageBackground = imageBackground;
        }

    }

    public class EsrbRating implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("slug")
        @Expose
        private String slug;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

    }

    public class Genre implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("games_count")
        @Expose
        private Integer gamesCount;
        @SerializedName("image_background")
        @Expose
        private String imageBackground;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public Integer getGamesCount() {
            return gamesCount;
        }

        public void setGamesCount(Integer gamesCount) {
            this.gamesCount = gamesCount;
        }

        public String getImageBackground() {
            return imageBackground;
        }

        public void setImageBackground(String imageBackground) {
            this.imageBackground = imageBackground;
        }

    }

    public class ParentPlatform implements Serializable {

        @SerializedName("platform")
        @Expose
        private Platform platform;

        public Platform getPlatform() {
            return platform;
        }

        public void setPlatform(Platform platform) {
            this.platform = platform;
        }

    }

    public class Platform implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("slug")
        @Expose
        private String slug;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

    }

    public class Platform_ implements Serializable {

        @SerializedName("platform")
        @Expose
        private Platform__ platform;
        @SerializedName("released_at")
        @Expose
        private String releasedAt;
        @SerializedName("requirements")
        @Expose
        private Requirements requirements;

        public Platform__ getPlatform() {
            return platform;
        }

        public void setPlatform(Platform__ platform) {
            this.platform = platform;
        }

        public String getReleasedAt() {
            return releasedAt;
        }

        public void setReleasedAt(String releasedAt) {
            this.releasedAt = releasedAt;
        }

        public Requirements getRequirements() {
            return requirements;
        }

        public void setRequirements(Requirements requirements) {
            this.requirements = requirements;
        }

    }

    public class Platform__ implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("image")
        @Expose
        private Object image;
        @SerializedName("year_end")
        @Expose
        private Object yearEnd;
        @SerializedName("year_start")
        @Expose
        private Object yearStart;
        @SerializedName("games_count")
        @Expose
        private Integer gamesCount;
        @SerializedName("image_background")
        @Expose
        private String imageBackground;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public Object getImage() {
            return image;
        }

        public void setImage(Object image) {
            this.image = image;
        }

        public Object getYearEnd() {
            return yearEnd;
        }

        public void setYearEnd(Object yearEnd) {
            this.yearEnd = yearEnd;
        }

        public Object getYearStart() {
            return yearStart;
        }

        public void setYearStart(Object yearStart) {
            this.yearStart = yearStart;
        }

        public Integer getGamesCount() {
            return gamesCount;
        }

        public void setGamesCount(Integer gamesCount) {
            this.gamesCount = gamesCount;
        }

        public String getImageBackground() {
            return imageBackground;
        }

        public void setImageBackground(String imageBackground) {
            this.imageBackground = imageBackground;
        }

    }

    public class Publisher implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("games_count")
        @Expose
        private Integer gamesCount;
        @SerializedName("image_background")
        @Expose
        private String imageBackground;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public Integer getGamesCount() {
            return gamesCount;
        }

        public void setGamesCount(Integer gamesCount) {
            this.gamesCount = gamesCount;
        }

        public String getImageBackground() {
            return imageBackground;
        }

        public void setImageBackground(String imageBackground) {
            this.imageBackground = imageBackground;
        }

    }


    public class Rating implements Serializable  {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("count")
        @Expose
        private Integer count;
        @SerializedName("percent")
        @Expose
        private Double percent;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Double getPercent() {
            return percent;
        }

        public void setPercent(Double percent) {
            this.percent = percent;
        }

    }


    public class Reactions implements Serializable {

        @SerializedName("1")
        @Expose
        private Integer _1;
        @SerializedName("2")
        @Expose
        private Integer _2;
        @SerializedName("3")
        @Expose
        private Integer _3;
        @SerializedName("4")
        @Expose
        private Integer _4;
        @SerializedName("5")
        @Expose
        private Integer _5;
        @SerializedName("6")
        @Expose
        private Integer _6;
        @SerializedName("7")
        @Expose
        private Integer _7;
        @SerializedName("8")
        @Expose
        private Integer _8;
        @SerializedName("9")
        @Expose
        private Integer _9;
        @SerializedName("10")
        @Expose
        private Integer _10;
        @SerializedName("11")
        @Expose
        private Integer _11;
        @SerializedName("12")
        @Expose
        private Integer _12;
        @SerializedName("16")
        @Expose
        private Integer _16;
        @SerializedName("19")
        @Expose
        private Integer _19;
        @SerializedName("21")
        @Expose
        private Integer _21;

        public Integer get1() {
            return _1;
        }

        public void set1(Integer _1) {
            this._1 = _1;
        }

        public Integer get2() {
            return _2;
        }

        public void set2(Integer _2) {
            this._2 = _2;
        }

        public Integer get3() {
            return _3;
        }

        public void set3(Integer _3) {
            this._3 = _3;
        }

        public Integer get4() {
            return _4;
        }

        public void set4(Integer _4) {
            this._4 = _4;
        }

        public Integer get5() {
            return _5;
        }

        public void set5(Integer _5) {
            this._5 = _5;
        }

        public Integer get6() {
            return _6;
        }

        public void set6(Integer _6) {
            this._6 = _6;
        }

        public Integer get7() {
            return _7;
        }

        public void set7(Integer _7) {
            this._7 = _7;
        }

        public Integer get8() {
            return _8;
        }

        public void set8(Integer _8) {
            this._8 = _8;
        }

        public Integer get9() {
            return _9;
        }

        public void set9(Integer _9) {
            this._9 = _9;
        }

        public Integer get10() {
            return _10;
        }

        public void set10(Integer _10) {
            this._10 = _10;
        }

        public Integer get11() {
            return _11;
        }

        public void set11(Integer _11) {
            this._11 = _11;
        }

        public Integer get12() {
            return _12;
        }

        public void set12(Integer _12) {
            this._12 = _12;
        }

        public Integer get16() {
            return _16;
        }

        public void set16(Integer _16) {
            this._16 = _16;
        }

        public Integer get19() {
            return _19;
        }

        public void set19(Integer _19) {
            this._19 = _19;
        }

        public Integer get21() {
            return _21;
        }

        public void set21(Integer _21) {
            this._21 = _21;
        }

    }

    public class Requirements implements Serializable {


    }


    public class Store implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("store")
        @Expose
        private Store_ store;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Store_ getStore() {
            return store;
        }

        public void setStore(Store_ store) {
            this.store = store;
        }

    }

    public class Store_ implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("domain")
        @Expose
        private String domain;
        @SerializedName("games_count")
        @Expose
        private Integer gamesCount;
        @SerializedName("image_background")
        @Expose
        private String imageBackground;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public Integer getGamesCount() {
            return gamesCount;
        }

        public void setGamesCount(Integer gamesCount) {
            this.gamesCount = gamesCount;
        }

        public String getImageBackground() {
            return imageBackground;
        }

        public void setImageBackground(String imageBackground) {
            this.imageBackground = imageBackground;
        }

    }


    public class Tag implements Serializable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("language")
        @Expose
        private String language;
        @SerializedName("games_count")
        @Expose
        private Integer gamesCount;
        @SerializedName("image_background")
        @Expose
        private String imageBackground;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public Integer getGamesCount() {
            return gamesCount;
        }

        public void setGamesCount(Integer gamesCount) {
            this.gamesCount = gamesCount;
        }

        public String getImageBackground() {
            return imageBackground;
        }

        public void setImageBackground(String imageBackground) {
            this.imageBackground = imageBackground;
        }

    }

}

