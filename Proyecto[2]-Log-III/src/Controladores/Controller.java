package Controladores;

import Modelos.Arbol;
import Modelos.ArbolBinario;
import Modelos.ListaGeneralizada;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    Inventario inv = new Inventario();
    // Para Lg
    @FXML
    private TextField nomLg;
    @FXML
    private TextField strLg;
    @FXML
    private ListView listLg;
    @FXML
    private TextArea showLg;

    // Para An
    @FXML
    private TextField nomAn;
    @FXML
    private TextField strA;
    @FXML
    private ListView listA;
    @FXML
    private TextArea showA;
    @FXML
    private TextField primo1;
    @FXML
    private TextField primo2;
    @FXML
    private Label ansPrimos;
    // Para Ab
    @FXML
    private TextField nomAb;
    @FXML
    private TextField strAb;
    @FXML
    private ListView listAb;
    @FXML
    private TextArea showAb;

    public void crearLg(MouseEvent event) {
        ListaGeneralizada lg = new ListaGeneralizada();
        lg.construirLista(this.strLg.getText());
        this.inv.guardarLg(this.nomLg.getText(), lg);
        this.listLg.setItems(this.inv.retornaNombresLg());
    }

    public void mostrarLg(MouseEvent event) {
        int seleccion = this.listLg.getSelectionModel().getSelectedIndex();
        ListaGeneralizada lg = this.inv.retornaLg(seleccion);
        String cadena = lg.mostrarLista();
        this.showLg.setText(cadena);
    }

    public void copiarLg(MouseEvent event) {
        int seleccion = this.listLg.getSelectionModel().getSelectedIndex();
        ListaGeneralizada lg = this.inv.retornaLg(seleccion);
        ListaGeneralizada copia = lg.copiarLista();
        this.inv.guardarLg(this.inv.retornaNombresLg().get(seleccion) + " - copia", copia);
        this.listLg.setItems(this.inv.retornaNombresLg());
        this.showLg.setText("Copiada exitosamente");
    }

    public void crearA(MouseEvent event) {
        Arbol a = new Arbol();
        a.construirArbol(this.strA.getText());
        this.inv.guardarA(this.nomAn.getText(), a);
        this.listA.setItems(this.inv.retornaNombresA());
    }

    public void mostrarA(MouseEvent event) {
        int seleccion = this.listA.getSelectionModel().getSelectedIndex();
        Arbol an = this.inv.retornaA(seleccion);
        String cadena = an.mostrarArbol();
        this.showA.setText(cadena);
    }

    public void copiarA(){
        int seleccion = this.listA.getSelectionModel().getSelectedIndex();
        Arbol a = this.inv.retornaA(seleccion);
        Arbol copia = a.copiarArbol();
        this.inv.guardarA(this.inv.retornaNombresA().get(seleccion) + " - copia", copia);
        this.listA.setItems(this.inv.retornaNombresA());
        this.showA.setText("Copiada exitosamente");
    }

    public void hojasA() {
        int seleccion = this.listA.getSelectionModel().getSelectedIndex();
        Arbol a = this.inv.retornaA(seleccion);
        this.showA.setText("El árbol tiene " + a.hojas(a.retornaRaiz()) + " hojas");
    }

    public void gradoA() {
        int seleccion = this.listA.getSelectionModel().getSelectedIndex();
        Arbol a = this.inv.retornaA(seleccion);
        this.showA.setText("El árbol tiene grado " + a.grado(a.retornaRaiz()));
    }
    
    public void primosA(){
        int seleccion = this.listA.getSelectionModel().getSelectedIndex();
        if(seleccion != -1){
            this.ansPrimos.setText("???");
        }
        Arbol a = this.inv.retornaA(seleccion);
        String primo1 = this.primo1.getText();
        String primo2 = this.primo2.getText();
        Character p1 = primo1.charAt(0);
        Character p2 = primo2.charAt(0);
        boolean ans = a.primos(p1,p2);
        if(ans){
            this.ansPrimos.setText("SI");
        } else {
            this.ansPrimos.setText("NO");
        }
    }

    public void alturaA(){
        int seleccion = this.listA.getSelectionModel().getSelectedIndex();
        Arbol a = this.inv.retornaA(seleccion);
        this.showA.setText("La altura del árbol es " + a.altura(a.retornaRaiz()));
    }

    public void crearAbAleatorio(MouseEvent event) {
        ArbolBinario a = new ArbolBinario();
        String datos = this.strAb.getText();
        String[] vector = datos.split(",");
        a.construirArbolAleatorio(vector);
        this.inv.guardarAb(this.nomAb.getText(), a);
        this.listAb.setItems(this.inv.retornaNombresAb());
    }

    public void crearAbVector(MouseEvent event) {
        ArbolBinario a = new ArbolBinario();
        String datos = this.strAb.getText();
        String[] vector = datos.split(",");
        a.construirArbolVector(vector, 0);
        this.inv.guardarAb(this.nomAb.getText(), a);
        this.listAb.setItems(this.inv.retornaNombresAb());
    }
}
