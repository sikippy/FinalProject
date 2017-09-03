package com.iak3.vina.finalproject.utils;

/**
 * Created by vwinata on 29/08/2017.
 */


public class ImageUtils {
    public static final String BASE_IMAGE_URL
            = "http://image.tmdb.org/t/p/";

    public static String generateImageUrl(String imagePath) {
        return BASE_IMAGE_URL + "w185" + imagePath;
    }
}
