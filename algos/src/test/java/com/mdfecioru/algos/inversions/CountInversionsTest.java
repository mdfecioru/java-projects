package com.mdfecioru.algos.inversions;

import org.junit.Test;
import com.mdfecioru.util.io.ReadFromFile;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class CountInversionsTest {

    @Test
    public void checkInversionsFromFile() {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ReadFromFile.readIntegers(this.getClass().getResourceAsStream("../../../../InversionsTest1.txt"), ll);
        CountInversions ci = new CountInversions(ll);
        assertEquals(17, ci.countInversions(), 0.1);
    }

}