package com.mdfecioru.algos.sorting;

import org.junit.Test;
import com.mdfecioru.util.io.ReadFromFile;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class QSortTest {

    @Test
    public void checkSortFromVector() {
        ArrayList<Integer> al = new ArrayList<Integer>();        

        al.add(4); al.add(3); al.add(3); al.add(1); al.add(23); 
        al.add(54);al.add(2); al.add(6);al.add(42);

        QSort qs = new QSort(al);
        al = qs.sort();
    
        assertArrayEquals(new int[]{1, 2, 3, 3, 4, 6, 23, 42, 54},
                          al.stream().mapToInt(i -> i).toArray());
    }

    @Test
    public void checkSortFromFile() {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int i;
        ReadFromFile.readIntegers(this.getClass().getResourceAsStream("../../../../QSortTest1.txt"), al);

        QSort qs = new QSort(al);
        al = qs.sort();
        
        boolean testPassed = true;
        for (i=0; i<al.size()-1; i++) {
          if (al.get(i) > al.get(i+1)) {
            testPassed = false;
            break;
          }
        }

        System.out.println("Comparisions: " + qs.getComparisions());

        assertTrue("Test failed at index " + i, testPassed);
    }

    @Test
    public void checkchoosePivotEven() {
      ArrayList<Integer> al = new ArrayList<Integer>();        

        al.add(8); al.add(2); al.add(4); al.add(5); al.add(7); al.add(1); 

        QSort qs = new QSort(al);
        assertEquals(qs.choosePivot(0, al.size()), 2);        
    }

    @Test
    public void checkchoosePivotOdd() {
      ArrayList<Integer> al = new ArrayList<Integer>();        

        al.add(8); al.add(2); al.add(4); al.add(3); al.add(7); al.add(1); al.add(5);

        QSort qs = new QSort(al);
        assertEquals(qs.choosePivot(0, al.size()), 6);        
    }

    @Test
    public void checkchoosePivotInsideArray() {
      ArrayList<Integer> al = new ArrayList<Integer>();        

        al.add(8); al.add(12); al.add(4); al.add(3); al.add(7); al.add(10); al.add(5);
        al.add(1); al.add(17); al.add(1); al.add(2);

        QSort qs = new QSort(al);
        assertEquals(qs.choosePivot(2, 9), 5);        
    }

}