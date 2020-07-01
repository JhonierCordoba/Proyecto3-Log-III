package Controllers;

import Modelos.MatrizAdyacente;
import Modelos.Storage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import javax.swing.*;

public class WindowController {
    
    private Storage sg = new Storage();
    @FXML
    private TextField tfNom_Ma;
    @FXML
    private TextField tfVert_Ma;
    @FXML
    private ListView listN_Ma;
    @FXML
    private ListView listV_Ma;
    @FXML
    private ComboBox cbV1_Ma;
    @FXML
    private ComboBox cbV2_Ma;
    
    // OnKeyPressed - open
    
    public void btnAgregarNombre_Ma(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.agregarNombre_Ma();
        }
    }
    
    public void btnFinaliza_Ma(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.finaliza_Ma();
        }
    }
    
    public void btnConectarV_Ma(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.conectarV_Ma();
        }
    }
    
    public void tfNom_Ma(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.agregarNombre_Ma();
        }
    }
    
    public void tfVert_Ma(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.agregarVertice_Ma();
        }
    }
    
    // OnKeyPressed - close
    
    public void agregarNombre_Ma() {
        if (this.tfNom_Ma.isDisable()) {
            this.agregarVertice_Ma();
            return;
        }
        if (this.tfNom_Ma.getText().isEmpty()) {
            errors(0);
            return;
        }
        this.tfNom_Ma.setDisable(true);
        this.tfVert_Ma.setDisable(false);
        MatrizAdyacente m = new MatrizAdyacente();
        ObservableList<String> vts = FXCollections.observableArrayList();
        this.sg.save_Ma(this.tfNom_Ma.getText(), m, vts);
        this.listN_Ma.setItems(this.sg.returnN_Ma());
        this.listN_Ma.getSelectionModel().select(this.sg.returnN_Ma().size() - 1);
    }
    
    public void agregarVertice_Ma() {
        if (this.tfVert_Ma.getText().isEmpty()) {
            errors(1);
            return;
        }
        int pos = this.listN_Ma.getSelectionModel().getSelectedIndex();
        String vt = this.tfVert_Ma.getText();
        this.sg.addV_Ma(pos, vt);
        this.tfVert_Ma.setText("");
        this.tfVert_Ma.setPromptText("Agregado");
        this.listV_Ma.setItems(this.sg.returnV_Ma(pos));
    }
    
    public void actualizarVertices_Ma() {
        this.listV_Ma.setItems(this.sg.returnV_Ma(this.listN_Ma.getSelectionModel().getSelectedIndex()));
        this.cbV1_Ma.setItems(this.sg.returnV_Ma(this.listN_Ma.getSelectionModel().getSelectedIndex()));
        this.cbV2_Ma.setItems(this.sg.returnV_Ma(this.listN_Ma.getSelectionModel().getSelectedIndex()));
    }
    
    public void finaliza_Ma() {
        if(this.listN_Ma.getSelectionModel().isEmpty()){
            errors(0);
            return;
        }
        this.tfNom_Ma.setText("");
        this.tfNom_Ma.setDisable(false);
        this.tfVert_Ma.setText("");
        this.tfVert_Ma.setDisable(true);
        // Creación de matriz Adyacente
        int select = this.listN_Ma.getSelectionModel().getSelectedIndex();
        MatrizAdyacente m = this.sg.return_Ma(select);
        select = this.sg.returnNV_Ma(select);
        m.tamaño_Ma(select);
        System.out.println(select);
        // LLenar los combobox
        this.cbV1_Ma.setItems(this.listV_Ma.getItems());
        this.cbV2_Ma.setItems(this.listV_Ma.getItems());
        this.cbV1_Ma.setDisable(false);
        this.cbV2_Ma.setDisable(false);
    }
    
    public void conectarV_Ma() {
        if (this.cbV1_Ma.getSelectionModel().getSelectedIndex() == -1 || this.cbV2_Ma.getSelectionModel().getSelectedIndex() == -1) {
            errors(2);
            return;
        }
        if (this.cbV1_Ma.getSelectionModel().getSelectedIndex() == this.cbV2_Ma.getSelectionModel().getSelectedIndex()) {
            errors(3);
            return;
        }
        int i = this.listN_Ma.getSelectionModel().getSelectedIndex();
        MatrizAdyacente m = this.sg.return_Ma(i);
        int a = cbV1_Ma.getSelectionModel().getSelectedIndex();
        int b = cbV2_Ma.getSelectionModel().getSelectedIndex();
        m.agregarConexion(a, b);
    }
    
    /**
     * Errores de la aplicación
     *
     * @param tipo 0: Nombre vacío, 1: Vértices vacíos, 2: Faltan vértices, 3: Mismo vértice
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
        }
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}