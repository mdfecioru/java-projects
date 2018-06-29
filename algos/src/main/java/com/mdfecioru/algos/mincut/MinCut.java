package com.mdfecioru.algos.mincut;

import java.util.*;

public class MinCut {
    private LinkedList<Node> cuts;
    private LinkedList<Tuple<Integer, Integer>> edgeList;
    private ArrayList<LinkedList<Integer>> local_input;

    public class Node {
        private Integer id;
        private HashSet<Integer> contractedIDs;

        public Node(Integer node_id) {
            id = node_id;
            contractedIDs = new HashSet<>();
        }
    }

    public class Tuple<A, B> {

        public final A a;
        public final B b;

        public Tuple(A a, B b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Tuple<?, ?> tuple = (Tuple<?, ?>) o;
            if (!a.equals(tuple.a)) return false;
            return b.equals(tuple.b);
        }

        @Override
        public int hashCode() {
            int result = a.hashCode();
            result = 31 * result + b.hashCode();
            return result;
        }
    }

    private void initMinCut(ArrayList<LinkedList<Integer>> input) {
        cuts = new LinkedList<>();
        edgeList = new LinkedList<>();

        for (int i=0; i< input.size(); i++) {
            LinkedList<Integer> ll = input.get(i);
            if (ll != null) {
                Node n = new Node(i);
                for (int j=0; j<ll.size(); j++) {
                    int node_id = ll.get(j);
                    if (i < node_id) edgeList.add(new Tuple<>(i, node_id));
                }
                cuts.add(n);
            }
        }
    }

    public MinCut(ArrayList<LinkedList<Integer>> input) {
        local_input = input;
    }

    private Tuple<Integer, Integer> removeRandomTupleFromEdges() {
        Random r = new Random(System.currentTimeMillis());
        int index = Math.abs(r.nextInt());
        index = index % edgeList.size();
        return edgeList.remove(index);
    }

    private void updateEdgesWithContraction(Tuple<Integer, Integer> t) {
        LinkedList<Tuple<Integer, Integer>> edgeListNew = new LinkedList<>();
        for (int i=0; i<edgeList.size(); i++) {
            Tuple<Integer, Integer> elm = edgeList.get(i);
            if (elm.equals(t)) {
                continue; // remove edges that become loops after contraction.
            }
            if (elm.a.equals(t.b)) {
                if (t.a.compareTo(elm.b) < 0) edgeListNew.add(new Tuple<>(t.a, elm.b));
                else edgeListNew.add(new Tuple<>(elm.b, t.a));
            }
            else if (elm.b.equals(t.b)) {
                if (elm.a.compareTo(t.a) < 0) edgeListNew.add(new Tuple<>(elm.a, t.a));
                else edgeListNew.add(new Tuple<>(t.a, elm.a));
            }
            else edgeListNew.add(elm);
        }
        edgeList = edgeListNew;
    }

    private void updateCutsWithContraction(Tuple<Integer, Integer> t) {
        Node a = null;
        Node b = null;

        for (Node n: cuts) {
            if (n.id.equals(t.a)) a = n;
            if (n.id.equals(t.b)) b = n;
            if ((a != null) && (b != null)) break;
        }

        cuts.remove(b);
        a.contractedIDs.add(b.id);
        for (Integer i: b.contractedIDs) {
            a.contractedIDs.add(i);
        }
    }

    private int runMinCut() {
        while (cuts.size() > 2) {
            Tuple<Integer, Integer> t = removeRandomTupleFromEdges();
            updateEdgesWithContraction(t);
            updateCutsWithContraction(t);
        }
        return edgeList.size();
    }

    private void printDebug() {

        System.out.print("Edge List: ");
        for (Tuple<Integer, Integer> t: edgeList) {
            System.out.print("(" + t.a + ", " + t.b + ")");
        }
        System.out.println();

        System.out.print("Cuts List: ");
        for (Node n: cuts) {
            System.out.print(n.id + ", ");
        }
        System.out.println();
        System.out.println();
    }

    public int getMinCut() {
        int iterations = 100;
        int minCut = 100000;

        for (int i=0; i<iterations; i++) {
            initMinCut(local_input);
            minCut = Math.min(minCut, runMinCut());
        }
        return minCut;
    }
}
