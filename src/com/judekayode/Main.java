package com.judekayode;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        GroupGenerator main = new GroupGenerator();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the names you want to group together in comma seperated format");

        try {
            String trimmedString = sc.nextLine().replaceAll("\\s","");
            String[] strings = trimmedString.split(",");
            ArrayList<String> entries = new ArrayList<String>(Arrays.asList(strings));

            System.out.println();
            System.out.println("Please enter number of people per group");
            int noPerGroup = sc.nextInt();
            System.out.println();

            if(noPerGroup > entries.size() || noPerGroup <=0) {
                System.out.println("Invalid number Per group specified");

            } else {
                System.out.println("The groups are :");
                int index = 0;
                for (PairModel model : main.generateGroup(entries, noPerGroup)) {
                    System.out.println("Group " + (index + 1) + " - " + model.ToString());
                    index++;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid name format");
        }

    }


}
