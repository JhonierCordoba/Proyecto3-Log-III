package Controllers;

import Modelos.MatrizAdyacente;
import Modelos.Storage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
import java.util.ArrayList;

public class WindowController {
    
    private Storage sg = new Storage();
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfVert;
    @FXML
    private TextField tfPrice;
    @FXML
    private TextArea taMostrar;
    @FXML
    private TextArea taRecorrer;
    @FXML
    private ListView listN;
    @FXML
    private ListView listN_2;
    @FXML
    private ListView listN_3;
    @FXML
    private ListView listV;
    @FXML
    private ComboBox cbV1;
    @FXML
    private ComboBox cbV2;
    
    // OnKeyPressed - open
    
    public void btnAgregar(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.agregar();
        }
    }
    
    public void btnConectarV(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.conectarV();
        }
    }
    
    public void tfNom(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.agregar();
        }
    }
    
    public void tfVert(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.agregar();
        }
    }
    
    // OnKeyPressed - close
    
    public void agregar() {
        if (!this.restricciones(0)) {
            return;
        }
        int vts = Integer.parseInt(this.tfVert.getText());
        MatrizAdyacente m = new MatrizAdyacente(vts);
        this.sg.save(this.tfNom.getText(), m);
        this.listN.setItems(this.sg.returnN());
        this.listN_2.setItems(this.sg.returnN());
        this.listN_3.setItems(this.sg.returnN());
        this.listN.getSelectionModel().select(this.sg.returnN().size() - 1);
        this.tfNom.setText("");
        this.tfVert.setText("");
        this.tfVert.setPromptText("Agregado");
        this.actualizarVertices();
        // LLenar los combobox
        this.cbV1.setItems(this.listV.getItems());
        this.cbV2.setItems(this.listV.getItems());
        this.cbV1.setDisable(false);
        this.cbV2.setDisable(false);
    }
    
    public void actualizarVertices() {
        this.listV.setItems(this.sg.returnNv(this.listN.getSelectionModel().getSelectedIndex()));
        this.cbV1.setItems(this.sg.returnNv(this.listN.getSelectionModel().getSelectedIndex()));
        this.cbV2.setItems(this.sg.returnNv(this.listN.getSelectionModel().getSelectedIndex()));
    }
    
    public void conectarV() {
        if(!this.restricciones(1)){
            return;
        }
        int select = this.listN.getSelectionModel().getSelectedIndex();
        MatrizAdyacente m = this.sg.returnM(select);
        int a = cbV1.getSelectionModel().getSelectedIndex() + 1;
        int b = cbV2.getSelectionModel().getSelectedIndex() + 1;
        int price = Integer.parseInt(this.tfPrice.getText());
        m.agregarConexion(a, b,price);
    }
    
    public void actualizarMuestra(){
        int select = this.listN_2.getSelectionModel().getSelectedIndex();
        MatrizAdyacente m = this.sg.returnM(select);
        this.taMostrar.setText(m.retornaM1().imprimeMatriz());
    }
    
    public void DFS(){
        int select = this.listN_3.getSelectionModel().getSelectedIndex();
        MatrizAdyacente m = this.sg.returnM(select);
        String d = tfInicio.getText();
        select = this.sg.searchV(d, select);
        ArrayList<Integer> o = m.DFS(select);
        String pv = "";
        for(Integer ent: o){
            pv += this.sg.vts.get(select).get(ent) + " ";
        }
        this.taRecorrer.setText(pv);
    }
    
    public void BFS(){
        int select = this.listN_3.getSelectionModel().getSelectedIndex();
        MatrizAdyacente m = this.sg.returnM(select);
        String d = tfInicio.getText();
        select = this.sg.searchV(d, select);
        ArrayList<Integer> o = m.DFS(select);
        String pv = "";
        for(int ent = o.size() - 1; ent >= 0; ent--){
            pv += this.sg.vts.get(select).get(ent) + " ";
        }
        this.taRecorrer.setText(pv);
    }
    
    /**
     * Restricciones de la aplicación
     *
     * @param tipo 0: Agregar, 1: Conectar
     */
    public Boolean restricciones(int tipo) {
        switch (tipo) {
            case 0: {
                if (this.tfNom.getText().isEmpty()) {
                    errors(0);
                    return false;
                }
                if (this.tfVert.getText().isEmpty()) {
                    errors(1);
                    return false;
                }
                int n;
                try {
                    n = Integer.parseInt(this.tfVert.getText());
                } catch (NumberFormatException exception) {
                    errors(4);
                    return false;
                }
                if (n < 0) {
                    errors(4);
                    return false;
                }
                break;
            }
            case 1: {
                if (this.cbV1.getSelectionModel().getSelectedIndex() == -1 || this.cbV2.getSelectionModel().getSelectedIndex() == -1) {
                    errors(2);
                    return false;
                }
                if (this.cbV1.getSelectionModel().getSelectedIndex() == this.cbV2.getSelectionModel().getSelectedIndex()) {
                    errors(3);
                    return false;
                }
                if(this.tfPrice.getText().isEmpty()){
                    errors(5);
                    return false;
                }
                int n;
                try {
                    n = Integer.parseInt(this.tfPrice.getText());
                } catch (NumberFormatException exception) {
                    errors(6);
                    return false;
                }
                if (n < 0) {
                    errors(6);
                    return false;
                }
                break;
            }
        }
        return true;
    }
    
    /**
     * Errores de la aplicación
     *
     * @param tipo 0: Nombre vacío, 1: Vértices vacíos, 2: Faltan vértices, 3: Mismo vértice, 4: No numérico positivo, 5: Sin Precio, 6: Formato Precio
     */
    public void errors(int tipo) {
        String message = "error";
        switch (tipo) {
            case 0: {
                message = "Ingrese un nombre primero";
                break;
            }
            case 1: {
                message = "No se admiten vértices vacíos";
                break;
            }
            case 2: {
                message = "Seleccione 2 vértices";
                break;
            }
            case 3: {
                message = "No se permiten loops en las matrices";
                break;
            }
            case 4: {
                message = "El número de vértices debe ser un entero positivo";
                break;
            }
            case 5:{
                message = "Ingrese un precio";
                break;
            }
            case 6:{
                message = "El precio debe ser un entero positivo";
            }
        }
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}