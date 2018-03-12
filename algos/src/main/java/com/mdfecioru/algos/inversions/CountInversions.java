package com.mdfecioru.algos.inversions;

import java.util.LinkedList;

public class CountInversions {

    public LinkedList<Integer> ll;

    public CountInversions(LinkedList<Integer> l) {
        ll = new LinkedList<>(l);
    }

    public long countInversions() {
        if (ll.size() <= 1) return 0;

        int i;
        LinkedList<Integer> lleft = new LinkedList<>();
        LinkedList<Integer> lright = new LinkedList<>();

        for (i=0; i<ll.size() / 2; i++) {
            lleft.add(ll.get(i));
        }
        for (; i<ll.size(); i++) {
            lright.add(ll.get(i));
        }

        CountInversions cleft = new CountInversions(lleft);
        CountInversions cright = new CountInversions(lright);

        long ileft = cleft.countInversions();
        long iright = cright.countInversions();

        ll = new LinkedList<>();
        lleft = cleft.ll;
        lright = cright.ll;

        int il = 0;
        int ir = 0;
        long inversions = 0;
        while ((il < lleft.size()) && (ir < lright.size())) {
            if (lleft.get(il) <= lright.get(ir)) {
                ll.add(lleft.get(il));
                il++;
            }
            else {
                ll.add(lright.get(ir));
                ir++;
                inversions += lleft.size() - il;
            }
        }

        while (il < lleft.size()) {
            ll.add(lleft.get(il));
            il++;
        }
        while (ir < lright.size()) {
            ll.add(lright.get(ir));
            ir++;
        }

        return inversions + ileft + iright;
    }

}
