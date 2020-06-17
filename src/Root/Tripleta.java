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

    public int returnRow() {
        return row;
    }

    public int returnColumn() {
        return column;
    }

    public Object returnValue() {
        return value;
    }
}