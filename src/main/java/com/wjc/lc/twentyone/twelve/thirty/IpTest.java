package com.wjc.lc.twentyone.twelve.thirty;

import java.util.*;

public class IpTest {
//    private static int[] ints = {0, 128, 192, 224, 240, 248, 252, 254, 255};
//    private static ArrayList<Integer> list = new ArrayList(Arrays.asList(ints));
    private static HashSet<Integer> set =new HashSet();
    static {
        set.add(0);
        set.add(128);
        set.add(192);
        set.add(224);
        set.add(240);
        set.add(248);
        set.add(252);
        set.add(254);
        set.add(255);
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] res = new int[7];
        boolean flag = scanner.hasNext();
        while (flag) {
            String s = scanner.nextLine();
            if ("end".equals(s)) {
                flag = false;
                continue;
            }
            String[] split = s.split("~");
            if (split.length == 2) {
                String[] s1 = split[0].split("\\.");
                String[] s2 = split[1].split("\\.");
                if (s1.length == 4 && s2.length == 4) {
                    int[] int1 = new int[4];
                    int[] int2 = new int[4];
                    try {
                        for (int i = 0; i < 4; i++) {
                            int1[i] = Integer.valueOf(s1[i]);
                            int2[i] = Integer.valueOf(s2[i]);
                        }
                    } catch (NumberFormatException e) {
                        res[5]++;
                        continue;
                    }
                    if (isGood(int1) && isGood(int2)) {
                        if (0 == int1[0]) {
                            continue;
                        }
                        if (127 == int1[0]) {
                            continue;
                        }
                        if (isMask(int2)) {
                            res[5]++;
                            continue;
                        } else {
                            if (1 <= int1[0] && int1[0] <= 126) {
                                res[0]++;
                            }
                            if (128 <= int1[0] && int1[0] <= 191) {
                                res[1]++;
                            }
                            if (192 <= int1[0] && int1[0] <= 223) {
                                res[2]++;
                            }
                            if (224 <= int1[0] && int1[0] <= 239) {
                                res[3]++;
                            }
                            if (240 <= int1[0] && int1[0] <= 255) {
                                res[4]++;
                            }
                            if (10 == int1[0]) {
                                res[6]++;
                            }
                            if (172 == int1[0] && 16 <= int1[1] && int1[1] <= 31) {
                                res[6]++;
                            }
                            if (192 == int1[0] && 168 == int1[1]) {
                                res[6]++;
                            }
                        }
                    } else {
                        res[5]++;
                    }
                } else {
                    res[5]++;
                }
            } else {
                res[5]++;
            }
        }
        System.out.println(Arrays.toString(res));
    }

    private static boolean isMask(int[] int2) {
        for (int i : int2) {
            if (!set.contains(i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isGood(int[] int1) {
        if (int1[0] < 0 || int1[0] > 255) {
            return false;
        }
        if (int1[1] < 0 || int1[1] > 255) {
            return false;
        }
        if (int1[2] < 0 || int1[2] > 255) {
            return false;
        }
        if (int1[3] < 0 || int1[3] > 255) {
            return false;
        }
        return true;
    }
}
