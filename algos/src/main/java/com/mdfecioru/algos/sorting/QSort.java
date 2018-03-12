package com.mdfecioru.algos.sorting;

import java.util.ArrayList;
import java.util.Collection;

public class QSort {
  private ArrayList al;

  public QSort(Collection<Integer> c) {
    al = new ArrayList<Integer>(c);
  }
  
  ArrayList sort() {
    return new ArrayList<Integer>(al);
  }

}