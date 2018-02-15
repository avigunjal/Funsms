package com.funsms.Model;

import java.util.ArrayList;

/**
 * Created by AVI on 25-12-2017.
 */

public class Smsdata {

   private int result;
    private String message;
    private ArrayList<Data> data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }
}
