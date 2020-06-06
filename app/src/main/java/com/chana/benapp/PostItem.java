package com.chana.benapp;

import android.net.Uri;

public class PostItem {
    boolean isUserLike;
    int postLikeCount;

    String userName;
    String postImgUrl;
    String postText;



    public PostItem(boolean isUserLike, int postLikeCount, String userName, String postImgUrl, String postText) {
        this.isUserLike = isUserLike;
        this.postLikeCount = postLikeCount;
        this.userName = userName;
        this.postImgUrl = postImgUrl;
        this.postText = postText;
    }

    public boolean isUserLike() {
        return isUserLike;
    }

    public int getPostLikeCount() {
        return postLikeCount;
    }

    public String getUserName() {
        return userName;
    }

    public String getPostImgUrl() {
        return postImgUrl;
    }

    public String getPostText() {
        return postText;
    }
}
