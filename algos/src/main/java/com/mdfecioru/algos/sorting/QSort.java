package com.mdfecioru.algos.sorting;

import java.util.ArrayList;
import java.util.Collection;

public class QSort {
  private ArrayList<Integer> al;
  private int comparisions;

  public QSort(Collection<Integer> c) {
    al = new ArrayList<Integer>(c);
    comparisions = 0;
  }
  
  int choosePivot(int start, int end) {
    int v1 = al.get(start);
    int v2 = al.get( start + (end - start - 1) / 2);
    int v3 = al.get(end-1);

    int[] v = {v1, v2, v3};

    for (int i=0; i<2; i++) {
      for (int j=i+1; j<3; j++) {
        if (v[i] > v[j]) {
          int temp = v[i];
          v[i] = v[j];
          v[j] = temp;
        }
      }
    }

    if (v[1] == v1) return start;
    if (v[1] == v2) return start + (end - start - 1) / 2;
    return end - 1;
  }

  private void swap(int i, int j) {
    Integer temp = al.get(i);
    al.set(i, al.get(j));
    al.set(j, temp);
  }

  private int partitionAroundPivot(int start, int end, int pivotPosition) {
    swap(start, pivotPosition);
    int i, j;

    i = start+1;
    Integer pivot = al.get(start);
    for (j = start+1; j < end; j++) {
      if (al.get(j) < pivot) {
        swap(i, j);
        i++;
      }
    }
    swap(i-1, start);

    return i-1;
  }


  private void _sort(int start, int end) {
    if (end - start <= 1) return;

    int pivotPosition = choosePivot(start, end);
    pivotPosition = partitionAroundPivot(start, end, pivotPosition);
    
    if (pivotPosition - start >= 1) comparisions = comparisions + (pivotPosition - start - 1);
    _sort(start, pivotPosition);
   
    if (end - (pivotPosition+1) >= 1) comparisions = comparisions + (end - (pivotPosition+1) - 1);
    _sort(pivotPosition+1, end);
  }

  public int getComparisions() {
    return comparisions;
  }

  public ArrayList sort() {
    comparisions = comparisions + (al.size() - 1);
    _sort(0, al.size());
    return new ArrayList<Integer>(al);
  }

}
