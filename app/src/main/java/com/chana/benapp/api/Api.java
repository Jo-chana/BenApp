package com.chana.benapp.api;

public class Api {
    private static String BASE_URL = "https://search.naver.com/search.naver?where=image&sm=tab_jum&query=";
    private static String SEARCH = BASE_URL + "벤";

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getSEARCH() {
        return SEARCH;
    }
}
