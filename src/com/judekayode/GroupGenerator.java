package com.judekayode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by kayode.oguntimehin on 13/03/2017.
 */
public class GroupGenerator {

    public List<PairModel> generateGroup(ArrayList<String> namesToGroup, int noPerGroup) {
        List<PairModel> pairedValues = new ArrayList<>();
        int lowerBound = 0;
        double initialLength = (double) namesToGroup.size();
        int entriesLength = namesToGroup.size();

        int ceil = (int) Math.ceil(initialLength / noPerGroup);
        for (int i = 0; i < ceil; i++) {
            if(entriesLength >=noPerGroup) {
                Random rand = new Random();
                StringBuilder paird = new StringBuilder();
                for (int j = 0; j <noPerGroup; j++) {
                    int randomValue = rand.nextInt((namesToGroup.size()-1)-lowerBound+1)+lowerBound;
                    String val = namesToGroup.get(randomValue);
                    namesToGroup.remove(randomValue);
                    String app;
                    if(j== 0){
                        app = val;
                    } else {
                        app = "," + val;
                    }
                    paird.append(app);
                }

                pairedValues.add(new PairModel(paird.toString()));
                entriesLength -= noPerGroup;
            } else if(entriesLength > 0){
                StringBuilder paird = new StringBuilder();
                for (int k = 0; k < entriesLength; k++) {
                    String val = namesToGroup.get(k);
                    namesToGroup.remove(k);
                    String app;
                    if(k== 0){
                        app = val;
                    } else {
                        app = "," + val;
                    }

                    paird.append(app);
                }
                pairedValues.add(new PairModel(paird.toString()));
            }
        }
        return pairedValues;
    }


}
