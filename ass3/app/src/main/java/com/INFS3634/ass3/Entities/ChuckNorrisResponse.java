package com.INFS3634.ass3.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChuckNorrisResponse {
    @SerializedName("value")
    @Expose
    private String value;

    public String getValue() {
        return value;
    }

}
