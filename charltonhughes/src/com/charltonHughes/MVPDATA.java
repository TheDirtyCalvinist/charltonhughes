package com.charltonHughes;

import java.util.Scanner;
import java.io.*;

/**
 * Write a description of class MVP here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MVPData {
    String name, list = "";

    String year[] = new String[61];
    String firstName[] = new String[61];
    String lastName[] = new String[61];
    String cityName[] = new String[61];
    String teamName[] = new String[61];
    String position[] = new String[55];
    int i = 0;
    int count;
    int searchType;

    MVPData(String n, int type) {
        name = n;
        searchType = type;

        try {
            Scanner scan = new Scanner(new File("MVPNFL.txt"));
            while (scan.hasNext()) {
                year[i] = scan.next();
                firstName[i] = scan.next();
                lastName[i] = scan.next();
                if (lastName[i].equals("Van")) {
                    lastName[i] = lastName[i] + " " + scan.next();
                }

                cityName[i] = scan.next();
                if (cityName[i].equals("Green") || cityName[i].equals("New") || cityName[i].equals("San") || cityName[i].equals("St.") || cityName[i].equals("Los")) {
                    cityName[i] = cityName[i] + " " + scan.next();
                }
                teamName[i] = scan.next();
                position[i] = scan.next();
                if (position[i].equals("Running") || position[i].equals("Defensive")) {
                    position[i] = position[i] + " " + scan.next();
                }
                i = i + 1;
            }
            scan.close();
        } catch (IOException e) {
            System.out.println("IO Error \n" + e);
        }


    }

    String MVPList() {
        if (searchType == 1) {
            for (int x = 0; x < 55; x++) {
                if (firstName[x].equals(name)){
                    list = list + year[x] + " " + firstName[x] + " " + lastName[x] + " " + cityName[x] + "\n";
                }
            }
        } else if (searchType == 2) {
            for (int x = 0; x < 55; x++) {
                if (lastName[x].equals(name)){
                    list = list + year[x] + " " + firstName[x] + " " + lastName[x] + " " + cityName[x] + "\n";
                }
            }
        } else {
            for (int x = 0; x < 55; x++) {
                if (cityName[x].equals(name)) {
                    list = list + year[x] + " " + firstName[x] + " " + lastName[x] + " " + cityName[x] + "\n";
                }
            }
        }


        return list;

    }
}