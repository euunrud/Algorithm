import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[4][8];
        for(int i = 0; i < 4; i++) {
            String s = br.readLine();
            for(int j = 0; j < 8; j++)
                arr[i][j] = s.charAt(j) - '0';
        }
        
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] std = {0, 0, 0, 0};
        
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            int idx1 = n - 1;
            int idx2 = n + 1;
            int dir1 = dir;
            int dir2 = dir;
            int before = std[n];
            while(idx1 >= 0) {
                if(arr[idx1 + 1][(before + 6) % 8] == arr[idx1][(std[idx1] + 2) % 8])
                    break;
                
                before = std[idx1];
                if(dir1 == 1)
                    std[idx1] = (std[idx1] + 1) % 8;
                else
                    std[idx1] = (std[idx1] - 1 + 8) % 8;
                    
                idx1--;
                dir1 *= -1;
            }
            
            before = std[n];
            while(idx2 < 4) {
                if(arr[idx2 - 1][(before + 2) % 8] == arr[idx2][(std[idx2] + 6) % 8])
                    break;
                before = std[idx2];
                if(dir2 == 1)
                    std[idx2] = (std[idx2] + 1) % 8;
                else
                    std[idx2] = (std[idx2] - 1 + 8) % 8;
            
                idx2++;
                dir2 *= -1;
            }
            if(dir == 1)
                std[n] = (std[n] - 1 + 8) % 8;
            else
                std[n] = (std[n] + 1) % 8;
        }
        
        int sum = 0;
        int c = 1;
        for(int i = 0; i < 4; i++) {
            if(arr[i][std[i]] == 1)
                sum += c;
            c *= 2;
        }
        
        System.out.print(sum);
    }
}