import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
            max = num[i] > max ? num[i] : max;
        }
        
        int size = max > 3 ? max : 3;
        int[][] rslt = new int[size + 1][4];
        for(int i = 1; i <= 3; i++) {
            rslt[i][1] = 1;
            rslt[i][2] = i / 2;
            rslt[i][3] = i / 3;
        }
        for(int i = 4; i <= size; i++) {
            rslt[i][1] = rslt[i - 1][1];
            rslt[i][2] = rslt[i - 2][2] + rslt[i -2][1];
            rslt[i][3] = rslt[i - 3][3] + rslt[i - 3][2] + rslt[i - 3][1];
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int sum = rslt[num[i]][1] + rslt[num[i]][2] + rslt[num[i]][3];
            sb.append(sum + "\n");
        }
        
        System.out.print(sb.toString());
    }
}