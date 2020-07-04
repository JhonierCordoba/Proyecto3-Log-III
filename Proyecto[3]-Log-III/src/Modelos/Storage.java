package Modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Storage {
    private ArrayList<MatrizAdyacente> sg = new ArrayList<>();
    private ObservableList<String> nom = FXCollections.observableArrayList();
    
    public void save(String name, MatrizAdyacente m) {
        nom.add(name);
        sg.add(m);
    }
    
    public MatrizAdyacente returnM(int i) {
        return this.sg.get(i);
    }
    
    public ObservableList returnN() {
        return nom;
    }
    
    public ObservableList returnNv(int i) {
        ObservableList vts = FXCollections.observableArrayList();
        for (int j = 1; j <= this.sg.get(i).retornaNv(); j++) {
            vts.add(j);
        }
        return vts;
    }
    
//    public Integer search(String pName) {
//        int i = -1;
//        for (String name : nom) {
//            i++;
//            if (name.equals(pName)) {
//                return i;
//            }
//        }
//        return null;
//    }
}
