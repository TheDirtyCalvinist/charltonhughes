

import java.util.Scanner;
import java.io.*;

/**
 * Write a description of class MVP here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MVPDATA {
    String name, list = "";

    String Year[] = new String[61];
    String FirstName[] = new String[61];
    String LastName[] = new String[61];
    String CityName[] = new String[61];
    String TeamName[] = new String[61];
    String Position[] = new String[55];
    int i = 0;
    int count;
    int searchtype;

    MVPDATA(String n, int type) {
        name = n;
        searchtype = type;

        try {
            Scanner scan = new Scanner(new File("MVPNFL.txt"));
            while (scan.hasNext()) {
                Year[i] = scan.next();
                FirstName[i] = scan.next();
                LastName[i] = scan.next();
                if (LastName[i].equals("Van")) {
                    LastName[i] = LastName[i] + " " + scan.next();
                }

                CityName[i] = scan.next();
                if (CityName[i].equals("Green") || CityName[i].equals("New") || CityName[i].equals("San") || CityName[i].equals("St.") || CityName[i].equals("Los")) {
                    CityName[i] = CityName[i] + " " + scan.next();
                }
                TeamName[i] = scan.next();
                Position[i] = scan.next();
                if (Position[i].equals("Running") || Position[i].equals("Defensive")) {
                    Position[i] = Position[i] + " " + scan.next();
                }
                i = i + 1;
            }
            scan.close();
        } catch (IOException e) {
            System.out.println("IO Error \n" + e);
        }


    }

    String MVPList() {
        if (searchtype == 1) {
            for (int x = 0; x < 55; x++) {
                if (FirstName[x].equals(name)){
                    list = list + Year[x] + " " + FirstName[x] + " " + LastName[x] + " " + CityName[x] + "\n";
                }
            }
        } else if (searchtype == 2) {
            for (int x = 0; x < 55; x++) {
                if (LastName[x].equals(name)){
                    list = list + Year[x] + " " + FirstName[x] + " " + LastName[x] + " " + CityName[x] + "\n";
                }
            }
        } else {
            for (int x = 0; x < 55; x++) {
                if (CityName[x].equals(name)) {
                    list = list + Year[x] + " " + FirstName[x] + " " + LastName[x] + " " + CityName[x] + "\n";
                }
            }
        }


        return list;

    }
}