package com.mdfecioru.algos.sorting;

import org.junit.Test;
import com.mdfecioru.util.io.ReadFromFile;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class QSortTest {

    @Test
    public void checkSortFromFile() {
        ArrayList<Integer> al = new ArrayList<Integer>();
        //ReadFromFile.readIntegers(this.getClass().getResourceAsStream("../../../../QSortTest1.txt"), al);
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(3);
        al.add(4);
        al.add(6);
        al.add(23);
        al.add(42);
        al.add(54);

        QSort qs = new QSort(al);
        al = qs.sort();
        assertArrayEquals(new int[]{1, 2, 3, 3, 4, 6, 23, 42, 54},
                          al.stream().mapToInt(i -> i).toArray());
    }

}