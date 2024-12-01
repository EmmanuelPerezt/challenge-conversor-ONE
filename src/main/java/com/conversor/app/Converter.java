package com.conversor.app;

import com.google.gson.annotations.SerializedName;

public class Converter {
    @SerializedName("conversion_result")
    Float value;


    public Float getValue() {
        return value;
    }

    
    public void setValue(Float value) {
        this.value = value;
    }
    

}
