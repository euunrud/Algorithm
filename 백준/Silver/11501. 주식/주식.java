import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            int[] arr = new int[n];
            for (int j = 0; j < n; j++)
                arr[j] = Integer.parseInt(st.nextToken());
                
            int max = 0;
            long total = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j] > max)
                    max = arr[j];
                else
                    total += max - arr[j];
            }
            
            System.out.println(total);
        }
        
    }
}