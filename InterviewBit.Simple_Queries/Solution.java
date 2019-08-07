public class Solution {
    private static final int MOD = 1_000_000_007;
    public ArrayList<Integer> solve(ArrayList<Integer> a, ArrayList<Integer> q) {
        int n = a.size();
        ArrayList<Integer> gright = nextGreater(a);
        ArrayList<Integer> lright = prevGreater(a);
        ArrayList<Pair> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int j = gright.get(i) - i;
            int k = i - lright.get(i);
            int f = j * k;

            int x = a.get(i);
            long prod = 1;
            for (int jj = 1; jj * jj <= x; jj++) {
                if (x % jj == 0) {
                    if (jj * jj == x) {
                        prod = ((prod * jj) % MOD);
                    } else {
                        prod = (((prod * jj) % MOD) * (x / jj)) % MOD;
                    }
                }
            }
            b.add(new Pair((int) prod, f));
        }

        Comparator<Pair> comp = (x, y) -> y.e - x.e;
        Collections.sort(b, comp);
        for (int i = 1; i < n; i++) {
            b.get(i).f += b.get(i - 1).f;
            // why do you need this check?
            // if (b.get(i).f > Integer.MAX_VALUE * 2L) {
            //     b.get(i).f = Integer.MAX_VALUE * 2L;
            // }
        }

        ArrayList<Long> c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            c.add(b.get(i).f);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < q.size(); i++) {
            int j = Collections.binarySearch(c, (long) q.get(i));
            if (j < 0) {
                j = Math.abs(j) - 1;
            }
            ans.add(b.get(j).e);
        }
        return ans;
    }

    ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
        int n = a.size();
        Deque<Integer> st = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(n);
        }
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a.get(i) > a.get(st.peekLast())) {
                int j = st.pollLast();
                ans.set(j, i);
            }
            st.offerLast(i);
        }
        return ans;
    }    

    ArrayList<Integer> prevGreater(ArrayList<Integer> a) {
        int n = a.size();
        Deque<Integer> st = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(-1);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && a.get(i) >= a.get(st.peekLast())) { // why?
                int j = st.pollLast();
                ans.set(j, i);
            }
            st.offerLast(i);
        }
        return ans;
    }
    
    static class Pair {
        int e;
        long f;
        public Pair(int ee, long ff) {
            e = ee;
            f = ff;
        }
    }
}