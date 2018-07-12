package com.mdfecioru.util.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collection;

public class ReadFromFile {
    public static void readIntegers (InputStream inputStream, Collection<Integer> c) {

        Scanner scanner = null;

        try {
            scanner = new Scanner(inputStream);

            while (scanner.hasNextInt()) {
                c.add(scanner.nextInt());
            }
        }
        catch (Exception ex) {
            System.out.println("ERROR: " + ex);
        }
        finally {
            if (scanner != null) scanner.close();
        }

        return;
    }

    public static ArrayList<LinkedList<Integer>> readGraphToAdjList (InputStream inputStream, int offset) {
        ArrayList<LinkedList<Integer>> adj = null;
        String line;
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

        try {
            line = in.readLine();
            adj = new ArrayList<>(Integer.parseInt(line));

            line = in.readLine();
            while (line != null) {
                LinkedList<Integer> ll = new LinkedList<>();
                String[] valueStr = new String(line).trim().split("\\s+");
                int index = Integer.parseInt(valueStr[0]) - offset;
                for (int i=1; i<valueStr.length; i++) {
                    ll.add(Integer.parseInt(valueStr[i]) - offset);
                }
                adj.add(index, ll);
                line = in.readLine();
            }
        }
        catch (Exception ex) {
            System.out.println("ERROR: " + ex);
        }

        return adj;
    }

    private static void addEdgeToAdjSCC(ArrayList<ArrayList<LinkedList<Integer>>> adj, Integer src, Integer dst, Integer direction) {
        ArrayList<LinkedList<Integer>> src_al = adj.get(direction);
        src_al.get(src).add(dst);
    }


    private static void addEdgesToAdjSCC(ArrayList<ArrayList<LinkedList<Integer>>> adj, Integer src, Integer dst) {
        addEdgeToAdjSCC(adj, src, dst, 0);
        addEdgeToAdjSCC(adj, dst, src, 1);
    }

    public static ArrayList<ArrayList<LinkedList<Integer>>> readDirectedGraphForSCC(InputStream inputStream, int offset) {
        ArrayList<ArrayList<LinkedList<Integer>>> adj = null;
        String line;
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

        try {
            line = in.readLine();
            int adj_size = Integer.parseInt(line);
            adj = new ArrayList<>(2);

            for (int i=0; i<2; i++) {
                ArrayList<LinkedList<Integer>> al = new ArrayList<>(adj_size);
                for (int j = 0; j < adj_size; j++) {
                    al.add(j, new LinkedList<>());
                }
                adj.add(i, al);
            }

            line = in.readLine();
            while (line != null) {
                String[] valueStr = new String(line).trim().split("\\s+");
                int src = Integer.parseInt(valueStr[0]) - offset;
                int dst = Integer.parseInt(valueStr[1]) - offset;

                addEdgesToAdjSCC(adj, src, dst);
                line = in.readLine();
            }
        }
        catch (Exception ex) {
            System.out.println("ERROR: " + ex);
        }

        return adj;
    }
}
