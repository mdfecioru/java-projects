package com.mdfecioru.algos.strongcc;

import java.util.*;

public class StrongCC {

    private static void initVisited(ArrayList visited, int size) {
        for (int i=0; i<size; i++) {
            try {
                visited.set(i, false);
            } catch (IndexOutOfBoundsException e) {
                visited.add(i, false);
            }
        }
    }


    private static void runFirstDFS(ArrayList<LinkedList<Integer>> adj, int nodeID,
                                   ArrayList<Boolean> visited, ArrayList<Integer> finishTime) {
        visited.set(nodeID, true);
        for (Integer child: adj.get(nodeID)) {
            if (visited.get(child) == false) {
                runFirstDFS(adj, child, visited, finishTime);
            }
        }
        finishTime.add(nodeID);
    }

    private static void runSecondDFS(ArrayList<LinkedList<Integer>> adj, int nodeID,
                                   ArrayList<Boolean> visited, HashMap<Integer, Integer> scc, Integer scc_id) {
        visited.set(nodeID, true);
        scc.put(scc_id, scc.get(scc_id)+1);
        for (Integer child: adj.get(nodeID)) {
            if (visited.get(child) == false)
                runSecondDFS(adj, child, visited, scc, scc_id);
        }
    }

    public static ArrayList<Integer> getSCCSize(ArrayList<ArrayList<LinkedList<Integer>>> scc_adj) {
        int size = scc_adj.get(0).size();
        ArrayList<Integer> finishTime = new ArrayList<>(size);
        ArrayList<Boolean> visited = new ArrayList<>(size);
        HashMap<Integer, Integer> scc = new HashMap<>();

        initVisited(visited, size);
        for (int i=(size-1); i>=0; i--) {
            if (visited.get(i) == false) {
                runFirstDFS(scc_adj.get(1), i, visited, finishTime);
            }
        }

        initVisited(visited, size);
        for (int i=(size-1); i>=0; i--) {
            Integer nodeID = finishTime.get(i);
            if (visited.get(nodeID) == false) {
                scc.put(nodeID, 0);
                runSecondDFS(scc_adj.get(0), nodeID, visited, scc, nodeID);
            }
        }

        ArrayList<Integer> result = new ArrayList<>(scc.values());
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}
