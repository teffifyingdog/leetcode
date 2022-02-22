import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        char[] chars = line.toCharArray();
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ints[i] = (int) chars[i];
        }

    }

    public static int BDF(int i, int j, int[] ints, int res) {
        if (j > ints.length) {
            return res;
        }
        if (i == j) {
            if (99 < ints[i]) {
                if (ints[i] < 1000) {
                    boolean f = isF(ints[i]);
                    if (f) {
                        return BDF(i + 1, j + 1, ints, res++);
                    } else {
                        BDF(i, j + 1, ints, res);
                    }
                }
            } else {
                BDF(i, j + 1, ints, res);
            }
        } else if (j > i) {
            int num = 0;
            for (int k = i; k <= j; k++) {
                num = num + ints[k];
            }
            if (99 < num) {
                if (num < 1000) {
                    boolean f = isF(num);
                    if (f) {
                        return BDF(j + 1, j + 1, ints, res++);
                    } else {
                        BDF(i, j + 1, ints, res);
                    }
                }
            } else {
                BDF(i, j + 1, ints, res);
            }
        }
        return 1;
    }

    public static int getACSII(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (char c : chars) {
            res = res + (int) c;
        }
        return res;
    }

    public static boolean isF(int x) {
        int a = x % 10;
        int b = (x / 10) % 10;
        int c = x / 100;
        if (x == (a * a * a + b * b * b + c * c * c)) {
            return true;
        }
        return false;
    }
}
