package Root;

/**
 *
 * @author JuanZea
 */
public class MatrizEnTripletas {

    private Tripleta[] V;

    public MatrizEnTripletas(Tripleta t) { // Modificado
        int n = t.getColumn();
        int m = t.getRow();
        int p = n * m + 1;
        // int i; // se usa en docs
        V = new Tripleta[p];
        V[0] = t;
        // for (i = 1; i <= p; i++) { // se usa en docs
        // }
    }

    public MatrizEnTripletas(int m, int n) {
        int p = m * n;
        Tripleta[] V = new Tripleta[p + 1];
        V[0] = new Tripleta(m, n, 0);
        this.V = V;
    }

    public void setNumberTripletas(int n) {
        this.V[0].setValue(n);
    }

    public void setTripleta(Tripleta t, int i) {
        this.V[i] = t;
    }

    public int getNumberRows() {
        return this.V[0].getRow();
    }

    public int getNumberColumns() {
        return this.V[0].getColumn();
    }

    public int getNumberTripletas() {
        return (int) this.V[0].getValue();
    }

    public Tripleta getTripleta(int i) {
        return this.V[i];
    }

    public void showMatrizEnTripletas() { // Modificado
        System.out.println("------------------------------");
        System.out.println("id. | Fila | Columna | Valor");
        System.out.println("------------------------------");
        for (int i = 1; i <= (int) this.V[0].getValue(); i++) {
            System.out.println(i + "." + " | " + this.V[i].getRow() + " | " + this.V[i].getColumn() + " | "
                    + this.V[i].getValue());
        }
    }

    public void printMatriz() { // Original
        for (int f = 1; f <= this.V[0].getRow(); f++) {
            for (int c = 1; c <= this.V[0].getColumn(); c++) {
                for (int i = 1; i <= (int) this.V[0].getValue(); i++) {
                    if (f == this.V[i].getRow() && c == this.V[i].getColumn()) {
                        System.out.print(this.V[i].getValue() + "\t");
                        break;
                    } else if (i == (int) this.V[0].getValue()) {
                        System.out.print("0" + "\t");
                        break;
                    }
                }
            }
            System.out.println("");
        }
    }

    public void insertTripleta(Tripleta t) { // Defectuoso
        int f = t.getRow();
        int c = t.getColumn();
        int i = 0;
        int p = (int) this.V[0].getValue();
        while (i <= p && f > this.V[i].getRow()) {
            i++;
        }
        while (i <= p && f == this.V[i].getRow() && c > this.V[i].getColumn()) {
            i++;
        }
        int j = p;
        while (j >= i) {
            this.V[j + 1] = this.V[j];
            j--;
        }
        this.V[i] = t;
        p++;
        this.V[0].setValue(p);
    }

    public void insertTripleta_v2(Tripleta t) { // i comienza en 1, para que las tripletas a insertar no se comparen con
        // V[0]
        int f = t.getRow();
        int c = t.getColumn();
        int i = 1;
        int p = (int) this.V[0].getValue();
        while (i <= p && f > this.V[i].getRow()) {
            i++;
        }
        while (i <= p && f == this.V[i].getRow() && c > this.V[i].getColumn()) {
            i++;
        }
        int j = p;
        while (j >= i) {
            this.V[j + 1] = this.V[j];
            j--;
        }
        this.V[i] = t;
        p++;
        this.V[0].setValue(p);
    }

    public MatrizEnTripletas sum(MatrizEnTripletas b) {
        return null;
    }

    public MatrizEnTripletas multiply(MatrizEnTripletas b) {
        return null;
    }

    public MatrizEnTripletas transpose_obsoleto() { // Modificado (140)
        int m = this.V[0].getRow();
        int n = this.V[0].getColumn();
        int p = (int) this.V[0].getValue();
        Tripleta tx = new Tripleta(n, m, 0);
        MatrizEnTripletas at = new MatrizEnTripletas(tx);
        int i = 1;
        while (i <= p) {
            int f = this.V[i].getRow();
            int c = this.V[i].getColumn();
            Object v = this.V[i].getValue();
            Tripleta t = new Tripleta(c, f, v);
            at.insertTripleta_v2(t);
            i++;
        }
        return at;
    }

    public MatrizEnTripletas transpose() { // Modificado (165)
        int m = this.V[0].getRow();
        int n = this.V[0].getColumn();
        Object p = this.V[0].getValue();
        Tripleta t = new Tripleta(n, m, p);
        MatrizEnTripletas at = new MatrizEnTripletas(t);
        int[] s = new int[n + 1];
        for (int i = 1; i <= (int)p; i++) {
            s[this.V[i].getColumn()] = s[this.V[i].getColumn()] + 1;

        }
        int[] pos = new int[n + 1];
        pos[0] = 1;
        for (int i = 1; i <= n; i++) {
            pos[i] = pos[i - 1] + s[i - 1];
        }
        for (int i = 1; i <= (int)p; i++) {
            int f = this.V[i].getRow();
            int c = this.V[i].getColumn();
            Object v = this.V[i].getValue();
            t = new Tripleta(c, f, v);
            int k = pos[c];
            at.setTripleta(t, k);
            pos[c] = pos[c] + 1;
        }
        return at;
    }

    public MatrizEnTripletas semiTranspose() {
        return null;
    }

    public MatrizEnTripletas fastTranspose() {
        return null;
    }
}