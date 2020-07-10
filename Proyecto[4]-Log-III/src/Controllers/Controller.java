package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Random;

public class Controller {
    @FXML
    TextField in_n;
    @FXML
    TextField in_k;
    
    @FXML
    TextField out_Cantidad;
    
    @FXML
    TextArea tb_1;
    @FXML
    TextArea tb_2;
    
    @FXML
    ComboBox cb_Rango;
    
    public void generarEntero(){
        Random rnd = new Random();
        int n = rnd.nextInt(41) + 10;
    }
    public void generarVector(){
    
    }
    public void Ordenar(){
    
    }
    public void AlgoritmoNK(){
    
    }
    public void calcularPrimos(){
    
    }
}
