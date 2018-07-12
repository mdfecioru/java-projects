package com.mdfecioru.util.io;

import org.junit.Test;

import java.util.LinkedList;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ReadFromFileTest {

    @Test
    public void readIntFromFiletoLinkList() {
        LinkedList<Integer> ll = new LinkedList<Integer>();

        //ReadFromFile.readIntegers(this.getClass().getClassLoader().getResourceAsStream("io/ReadIntTest.txt"), ll);
        //ReadFromFile.readIntegers(this.getClass().getResourceAsStream("/io/ReadIntTest.txt"), ll);
        ReadFromFile.readIntegers(this.getClass().getResourceAsStream("../../../../io/ReadIntTest.txt"), ll);
        assertArrayEquals(new int[]{123, 342, 11242, 0, 2, 4},
                          ll.stream().mapToInt(i -> i).toArray());
    }

    @Test
    public void readIntFromFiletoArrayList() {
        ArrayList<Integer> al = new ArrayList<Integer>();

        ReadFromFile.readIntegers(this.getClass().getResourceAsStream("../../../../io/ReadIntTest.txt"), al);
        assertArrayEquals(new int[]{123, 342, 11242, 0, 2, 4},
                          al.stream().mapToInt(i -> i).toArray());
    }

    @Test
    public void readGraphToAdjListTest() {

        ArrayList<LinkedList<Integer>> adj =
                ReadFromFile.readGraphToAdjList(this.getClass().getResourceAsStream("../../../../io/ReadGraphTest.txt"), 1);
        assertEquals(10, adj.size());
        assertArrayEquals(new int[]{2, 6, 5}, adj.get(0).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{3, 7}, adj.get(1).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{0, 6, 8, 9}, adj.get(2).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{1, 8, 9}, adj.get(3).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{5, 7, 8}, adj.get(4).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{0, 4}, adj.get(5).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{0, 2, 9}, adj.get(6).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{1, 4}, adj.get(7).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{2, 3, 4}, adj.get(8).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{2, 3, 6}, adj.get(9).stream().mapToInt(i -> i).toArray());
    }


    @Test
    public void readDirectedGraphForSCCTest() {

        ArrayList<ArrayList<LinkedList<Integer>>> adj =
                ReadFromFile.readDirectedGraphForSCC(this.getClass().getResourceAsStream("../../../../io/ReadDirectedGraphSCC.txt"), 1);
        assertEquals(11, adj.get(0).size());
        assertEquals(11, adj.get(1).size());
        assertArrayEquals(new int[]{1, 3}, adj.get(0).get(0).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{2}, adj.get(1).get(0).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{2, 7}, adj.get(0).get(1).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{0}, adj.get(1).get(1).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{0, 6, 7}, adj.get(0).get(2).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{1}, adj.get(1).get(2).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{4}, adj.get(0).get(3).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{0, 6}, adj.get(1).get(3).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{5}, adj.get(0).get(4).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{3}, adj.get(1).get(4).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{6}, adj.get(0).get(5).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{4, 9}, adj.get(1).get(5).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{3}, adj.get(0).get(6).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{2, 5, 8}, adj.get(1).get(6).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{8, 10}, adj.get(0).get(7).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{1, 2}, adj.get(1).get(7).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{9, 6}, adj.get(0).get(8).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{7, 10}, adj.get(1).get(8).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{5, 10}, adj.get(0).get(9).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{8}, adj.get(1).get(9).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{8}, adj.get(0).get(10).stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{7, 9}, adj.get(1).get(10).stream().mapToInt(i -> i).toArray());
    }


}