package Root;

/**
 *
 * @author JuanZea
 */
public class Tripleta {

    private int row;
    private int column;
    private Object value;

    public Tripleta(int row, int column, Object value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public void setRow(int r) {
        this.row = r;
    }

    public void setColumn(int c) {
        this.column = c;
    }

    public void setValue(Object v) {
        this.value = v;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Object getValue() {
        return value;
    }
}