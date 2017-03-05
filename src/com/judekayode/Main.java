package com.judekayode;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the names you want to group together in comma seperated format");

        try {
            String[] strings = sc.next().split(",");
            ArrayList<String> entries = new ArrayList<String>(Arrays.asList(strings));

            System.out.println("Please enter number of people per group");
            int noPerGroup = sc.nextInt();

            if(noPerGroup > entries.size() || noPerGroup <=0) {
                System.out.println("Invalid number Per group specified");

            } else {
                int index = 0;
                for (PairModel model : main.Pairs(entries, noPerGroup)) {
                    System.out.println("Group " + (index + 1) + " - " + model.ToString());
                    index++;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid name format");
        }

    }

    private  List<PairModel> Pairs(ArrayList<String> namesToGroup, int noPerGroup) {
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
