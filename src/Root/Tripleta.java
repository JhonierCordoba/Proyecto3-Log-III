package Root;

/**
 *
 * @author JuanZea
 */
public class Tripleta {

    private int fila;
    private int columna;
    private Object valor;

    public Tripleta(int fila, int columna, Object valor) {
        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
    }

    public void asignaFila(int r) {
        this.fila = r;
    }

    public void asignaColumna(int c) {
        this.columna = c;
    }

    public void asignaValor(Object v) {
        this.valor = v;
    }

    public int retornaFila() {
        return fila;
    }

    public int retornaColumna() {
        return columna;
    }

    public Object retornaValor() {
        return valor;
    }
}