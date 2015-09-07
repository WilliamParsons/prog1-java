package assignment1;

import java.util.ArrayList;
import java.util.Arrays;


public class Table {
    private int[][] table;
    private int rows = 0;
    private int cols = 0;


    public Table(int cols, int rows) {
        this.rows = rows;
        this.cols = cols;

        this.makeTable();
    }

    private void makeTable() {
        this.table = new int[this.width()][this.height()];
    }

    public int[] getRow(int n) throws Exception{
        if(n > this.rows + 1){
            throw new Exception("Row out of bounds");
        }

        int[] row = new int[this.height()];

        for(int col = 0; col < this.height(); col++){
            row[col] = this.table[n][col];
        }

        return row;
    }

    public void putRow (int row, int[] data) throws Exception{
        if(row >= this.rows){
            throw new Exception("Row out of bounds");
        }
        else if(data.length != this.cols){
            throw new Exception("Column size is incorrect");
        }

        table[row] = data;
    }

    public int valueAt(int col, int row) throws Exception{
        if(row >= this.rows || col >= this.cols){
            throw new Exception("Value does not exist");
        }

        return this.table[row][col];
    }

    public int width(){
        return this.cols;
    }

    public int height(){
        return this.rows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Table table1 = (Table) o;

        if (rows != table1.rows) return false;
        if (cols != table1.cols) return false;

        try{
            for(int row = 0; row < this.height(); row++){
                for(int col = 0; col < this.width(); col++){
                    int source = this.valueAt(col, row);
                    int target = table1.valueAt(col, row);
                    if(source != target){
                        return false;
                    }
                }
            }

            return true;
        }
        catch(Exception e){
            return false;
        }

    }

    @Override
    public int hashCode() {
        int result = table != null ? Arrays.deepHashCode(table) : 0;
        result = 31 * result + rows;
        result = 31 * result + cols;
        return result;
    }

    public ArrayList<int[]> differences(Table target) throws Exception{
        if(target.width() != width() || target.height() != height()){
            throw new Exception("Tables must have same width and height");
        }

        ArrayList<int[]> destination = new ArrayList<>();

        for(int row = 0; row < this.height(); row++){
            for(int col = 0; col < this.width(); col++){
                int source = valueAt(col, row);
                int against = target.valueAt(col, row);
                if(source != against){
                    int[] difference = { col, row };

                    destination.add(difference);
                }
            }
        }

        return destination;
    }
}
