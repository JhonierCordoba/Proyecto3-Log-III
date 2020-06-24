package Controladores;

import Modelos.ListaGeneralizada;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    Inventario inv = new Inventario();
    @FXML
    private TextField nomLg;
    @FXML
    private TextField strLg;
    @FXML
    private ListView invLg;
    @FXML
    private TextArea showLg;

    public void crearLg(MouseEvent event) {
        ListaGeneralizada lg = new ListaGeneralizada();
        lg.construirLista(this.strLg.getText());
        this.inv.guardarLg(this.nomLg.getText(), lg);
        this.invLg.setItems(this.inv.retornaNombresLg());
    }

    public void mostrarLg(MouseEvent event) {
        int seleccion = this.invLg.getSelectionModel().getSelectedIndex();
        ListaGeneralizada lg = this.inv.retornaLg(seleccion);
        String cadena = lg.mostrarLista();
        this.showLg.setText(cadena);
    }

    public void copiarLg(MouseEvent event) {
        int seleccion = this.invLg.getSelectionModel().getSelectedIndex();
        ListaGeneralizada lg = this.inv.retornaLg(seleccion);
        ListaGeneralizada copia = lg.copiarLista();
        this.inv.guardarLg(this.inv.retornaNombresLg().get(seleccion) + " - copia", copia);
        this.invLg.setItems(this.inv.retornaNombresLg());
        this.showLg.setText("Copiada exitosamente");
    }
}
