package com.wjc.lc.twenty.tree.twentysix;


import java.io.IOException;

/**
 * @Description
 * @Date 2020/3/26 0026 下午 13:33
 * @Created by wjc
 * <p>
 * https://leetcode-cn.com/problems/available-captures-for-rook/
 */
public class 车的可用捕获量 {
    public int test(char[][] board){
        int[] x = {1,-1,0,0};
        int[] y = {0,0,1,-1};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R'){
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int a = i,b = j;
                        while (true) {
                            a += x[k];
                            b += y[k];
                            if (a < 0 || a >= 8 || b < 0 || b >= 8 || board[a][b] == 'B') {
                                break;
                            }else if (board[a][b] == 'p'){
                                count++;
                                break;
                            }
                        }
                    }
                    return count;
                }
            }
        }
        return 0;
    }
    public static int numRookCaptures(char[][] board) {
        int x = 0;
        int y = 0;
        int count = 0;
        int length = board.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        System.out.println("x = " + x);
        System.out.println("x = " + y);
        for (int i = x; i >= 0; i--) {
            if (board[i][y] == 'B') {
                break;
            } else if (board[i][y] == 'p') {
                count++;
                System.out.println(1+","+count);
                break;
            }
        }
        for (int i = x; i < length; i++) {
            if (board[i][y] == 'B') {
                break;
            } else if (board[i][y] == 'p') {
                count++;
                System.out.println(2+","+count);
                break;
            }
        }
        for (int i = y; i >= 0; i--) {
            if (board[x][i] == 'B') {
                break;
            } else if (board[x][i] == 'p') {
                count++;
                System.out.println(3+","+count);
                break;
            }
        }
        for (int i = y; i < length; i++) {
            if (board[x][i] == 'B') {
                break;
            } else if (board[x][i] == 'p') {
                count++;
                System.out.println(4+","+count);
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        char[][] chars = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};


        int ret = numRookCaptures(chars);

        String out = String.valueOf(ret);

        System.out.print(out);
    }

}
