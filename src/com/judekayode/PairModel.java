package com.judekayode;

/**
 * Created by kayode.oguntimehin on 05/03/2017.
 */
public class PairModel {

    private String pair;

    public String getPairing() {
        return pair;
    }

    public void setPairing(String pair) {
        this.pair = pair;
    }


    PairModel(String pair) {
        this.pair = pair;
    }

    String ToString(){
        return this.pair;

    }
}
