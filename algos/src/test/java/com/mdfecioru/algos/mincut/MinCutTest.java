package com.mdfecioru.algos.mincut;

import com.mdfecioru.util.io.ReadFromFile;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class MinCutTest {
    @Test
    public void checkMinCut() {
        ArrayList<LinkedList<Integer>> adj =
            ReadFromFile.readGraphToAdjList(this.getClass().getResourceAsStream("../../../../ReadGraphTest1.txt"), 0);
        MinCut mc = new MinCut(adj);
        assertEquals(2, mc.getMinCut());
    }

}