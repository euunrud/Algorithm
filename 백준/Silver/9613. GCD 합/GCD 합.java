import java.util.*;
import java.io.*;

class Main {
    static int gcd(int a, int b) {
        if (b == 0) 
            return a;
        return gcd(b, a %  b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int j = 0; j < n; j++)
                arr[j] = Integer.parseInt(st.nextToken());
            
            Arrays.sort(arr);
            long sum = 0;
            for(int a = 0; a < n; a++)
                for(int b = a + 1; b < n; b++){
                    int gc = gcd(arr[b], arr[a]);
                    sum += gc;
                }
        
            System.out.println(sum);
        }
    }
}