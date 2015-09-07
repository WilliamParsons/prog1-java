package assignment1;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by mikeryan on 9/7/15.
 */
public class TableTest {

    @Test
    public void testGetRowAndPutRow() throws Exception {
        Table table = new Table(1, 1);
        int[] set = { 1 };
        table.putRow(0, set);

        assertArrayEquals("Gets the row at the provided index", set, table.getRow(0));
    }

    @Test(expected= Exception.class)
    public void testGetRowThrows() throws Exception{
        new Table(1, 1).getRow(3);
    }

    @Test
    public void testGetNamedCol() throws Exception {

    }

    @Test
    public void testValueAt() throws Exception {

    }

    @Test
    public void testGetColNames() throws Exception {

    }

    @Test
    public void testWidth() throws Exception {

    }

    @Test
    public void testHeight() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {
        Table source = new Table(3, 1);
        Table target = new Table(3, 1);
        Table different = new Table(4, 4);
        int[] set = {1, 2, 3};

        source.putRow(0, set);
        target.putRow(0, set);

        assertTrue(source.equals(target));
        assertFalse(source.equals(different));
    }

    @Test
    public void testDifferences() throws Exception{
        Table source = new Table(3, 1);
        Table target = new Table(3, 1);
        int[] sourceSet = {1, 2, 3};
        int[] targetSet = {1, 5, 3};
        int[] differences = {1, 0};

        source.putRow(0, sourceSet);
        target.putRow(0, targetSet);

        ArrayList<int[]> result = source.differences(target);

        assertArrayEquals(result.get(0), differences);
    }

    @Test(expected = Exception.class)
    public void testDifferencesThrows() throws Exception{
        Table source = new Table(5, 5);
        Table target = new Table(3, 3);

        source.differences(target);
    }
}