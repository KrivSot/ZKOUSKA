package models.FileOperation;

import models.models.Penize;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CVSFileOperation implements FileOperation {
    final String FILEPATH = "output.csv";

    @Override
    public void Save(ArrayList<Integer> pocetKs) throws IOException {
        Penize values = new Penize();
        FileWriter file = new FileWriter(FILEPATH);
        for(int i = 0; i < pocetKs.size();i++)
        {
            if(pocetKs.get(i) != 0) {
                file.write(values.getTyp().get(i) + ";" + values.getHodnota().get(i) + ";" + pocetKs.get(i) + "\n");
            }
        }
        file.flush();
        file.close();
    }
}
