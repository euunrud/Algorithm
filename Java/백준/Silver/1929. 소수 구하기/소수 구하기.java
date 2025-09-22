import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static boolean[] ert;
    public static void eratos(int num) {
        for(int i = 2; i <= n; i++) {
            ert[i] = true;
        }
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(ert[i] == true) {
                for(int j = i * i; j <= num; j += i){
                    ert[j] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        ert = new boolean[n + 1];
        eratos(n);
        
        for(int i = m; i <= n; i++) {
            if(ert[i]) {
                System.out.println(i);
            }
        }
    }
}