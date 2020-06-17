package Root;

/**
 *
 * @author JuanZea
 */
public class MatrizEnTripletas {
    private Tripleta[] V;

    public MatrizEnTripletas(Tripleta t) {
        int m = t.returnRow();
        int n = t.returnColumn();
        int p = m * n + 2;
        int i;
        V = new Tripleta[p];
        V[0] = t;
        for ( i = 1; i <= p; i++) {
            V[i] = null;
        }
    }

    public void setNumberTripletas(int n) {

    }

    public void setTripleta(Tripleta tx, int i) {

    }

    // public int returnNumberRows() {
    //     return null;
    // }

    // public int returnNumberColumns() {
    //     return null;
    // }

    // public int returnNumberTripletas() {
    //     return null;
    // }

    public Tripleta returnTripleta(int i) {
        return null;
    }

    public void showMatrizEnTripletas() {

    }

    public void insertTripleta(Tripleta tx) {

    }

    public MatrizEnTripletas sum(MatrizEnTripletas b) {
        return null;
    }

    public MatrizEnTripletas multiply(MatrizEnTripletas b) {
        return null;
    }

    public MatrizEnTripletas transpose() {
        return null;
    }

    public MatrizEnTripletas semiTranspose() {
        return null;
    }

    public MatrizEnTripletas fastTranspose() {
        return null;
    }
}