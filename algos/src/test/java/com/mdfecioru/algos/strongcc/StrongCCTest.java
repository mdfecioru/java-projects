package com.mdfecioru.algos.strongcc;

import com.mdfecioru.util.io.ReadFromFile;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class StrongCCTest {
    @Test
    public void checkStrongCC() {
        ArrayList<ArrayList<LinkedList<Integer>>> adj =
                ReadFromFile.readDirectedGraphForSCC(this.getClass().getResourceAsStream("../../../../ReadDirectedGraphSCC.txt"), 1);
        ArrayList<Integer> result = StrongCC.getSCCSize(adj);

        assertEquals(4, result.size());
        assertArrayEquals(new int[]{4, 3, 3, 1}, result.stream().mapToInt(i -> i).toArray());
    }

}