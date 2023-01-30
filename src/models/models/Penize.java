package models.models;

import java.util.ArrayList;

public class Penize {

    ArrayList<String> typ = new ArrayList<>();
    ArrayList<Integer> hodnota = new ArrayList<>();

    public Penize(){
        typ.add("Bankovky");
        typ.add("Bankovky");
        typ.add("Bankovky");
        typ.add("Bankovky");
        typ.add("Bankovky");
        typ.add("Bankovky");
        typ.add("Mince");
        typ.add("Mince");
        typ.add("Mince");
        typ.add("Mince");
        typ.add("Mince");
        typ.add("Mince");
        hodnota.add(5000);
        hodnota.add(2000);
        hodnota.add(1000);
        hodnota.add(500);
        hodnota.add(200);
        hodnota.add(100);
        hodnota.add(50);
        hodnota.add(20);
        hodnota.add(10);
        hodnota.add(5);
        hodnota.add(2);
        hodnota.add(1);
    }

    public ArrayList<String> getTyp() {
        return typ;
    }

    public ArrayList<Integer> getHodnota() {
        return hodnota;
    }
}
