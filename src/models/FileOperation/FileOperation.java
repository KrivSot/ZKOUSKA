package models.FileOperation;


import java.io.IOException;
import java.util.ArrayList;

public interface FileOperation {
    void Save(ArrayList<Integer> pocetKs) throws IOException;
}
