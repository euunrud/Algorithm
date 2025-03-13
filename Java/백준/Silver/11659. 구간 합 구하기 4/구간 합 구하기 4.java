import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] S = new int[n + 1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++) {
            if(i == 1) {
                S[i] = Integer.parseInt(st.nextToken());
            }else {
                S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(a != 1) {
                System.out.println(S[b] - S[a - 1]);
            }else {
                System.out.println(S[b]);
            }
        }
        
    }
}