import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Three {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a1 = -1;
        int a2 = -1;
        int b1 = -1;
        int b2 = -1;
        int m = s.nextInt();
        int n = s.nextInt();
        int[][] ints = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int a = s.nextInt();
                if (a == 2) {
                    if (a1 < 0) {
                        a1 = i;
                        a2 = j;
                    } else {
                        b1 = i;
                        b2 = j;
                    }
                }
                ints[i][j] = a;
            }
        }
        HashMap<Integer, Integer> h1 = new HashMap<>();
        HashMap<String, Integer> his1 = new HashMap<>();
        getResMap(a1, a2, ints, h1, his1);
        HashMap<Integer, Integer> h2 = new HashMap<>();
        HashMap<String, Integer> his2 = new HashMap<>();
        getResMap(b1, b2, ints, h2, his2);
        System.out.println(h1);
        System.out.println(h2);
        AtomicInteger res = new AtomicInteger();
        h1.forEach((k, v) -> {
            if (v == h2.get(k)) {
                res.getAndIncrement();
            }
        });
        System.out.println(res.get());
    }

    private static void getResMap(int a, int b, int[][] ints, HashMap map, HashMap<String, Integer> his) {
//        System.out.println(a+","+b);
        if (a < 0 || a >= ints.length) {
            return;
        }
        if (b < 0 || b >= ints[0].length) {
            return;
        }
        if (ints[a][b] == 1) {
            return;
        }
        if (his.get(a+"_"+b) != null && his.get(a+"_"+b) == 1) {
            return;
        }
        his.put(a+"_"+b, 1);
        if (ints[a][b] == 3) {
            map.put(a, b);
        }
        if (ints[a][b] == 0 || ints[a][b] == 2) {
            getResMap(a + 1, b, ints, map, new HashMap<>(his));
            getResMap(a - 1, b, ints, map, new HashMap<>(his));
            getResMap(a, b + 1, ints, map, new HashMap<>(his));
            getResMap(a, b - 1, ints, map, new HashMap<>(his));
        }
    }
}
