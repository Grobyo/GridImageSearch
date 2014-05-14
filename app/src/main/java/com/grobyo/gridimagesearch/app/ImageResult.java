package com.grobyo.gridimagesearch.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Andy Kettle on 4/1/2014.
 */
// Allows us to use the image rather than the url
public class ImageResult implements Serializable {

    private String fullUrl;
    private String thumburl;

    public ImageResult(JSONObject json){
        try {
            this.fullUrl = json.getString("url");
            this.thumburl = json.getString("tbUrl");
        } catch (JSONException e){
            this.fullUrl = null;
            this.thumburl = null;

        }
    }
    public String getFullUrl(){
        return fullUrl;
    }
    public String getThumburl(){
        return thumburl;

    }
    public String toString(){
        return this.thumburl;
    }

    public static ArrayList<ImageResult> fromJSONArray
            (JSONArray array) {
        ArrayList<ImageResult> results = new ArrayList<ImageResult>();
        for (int x=0; x < array.length(); x++){
            try {
                results.add(new ImageResult(array.getJSONObject(x)));
            } catch (JSONException e){
                e.printStackTrace();
            }
        }
        return results;

    }
}
