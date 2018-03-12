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
}