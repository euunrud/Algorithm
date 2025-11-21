import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = { -1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i = 0; i < 10; i++) {
        	int n = Integer.parseInt(br.readLine());
            int[][] arr= new int[16][16];
            for(int j = 0; j < 16; j++) {
                String s = br.readLine();
                for(int k = 0; k < 16; k++)
                    arr[j][k] = s.charAt(k) - '0';
            }

            Queue<int[]> que = new ArrayDeque<>();
            que.offer(new int[]{1, 1});
            int flag = 0;
            while(!que.isEmpty() && flag == 0) {
                int[] a = que.poll();
                for(int j = 0; j < 4; j++) {
                    int x = a[0] + dx[j];
                    int y = a[1] + dy[j];
                    if(arr[x][y] == 0) {
                        que.offer(new int[]{x, y});
                        arr[x][y] = 1;
                    } else if (arr[x][y] == 3) {
                        flag = 1;
                        break;
                    }
                }
            }
            System.out.println("#" + (i + 1) + " " + flag);
        }
  }
}