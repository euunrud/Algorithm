import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] arr;
    static int cnt = 0;
    static void calc(int idx, int sum) {
        if(idx != 0 && sum == m)
            cnt++;
        if(idx >= n)
            return;
        for(int i = idx; i < n; i++)
            calc(i + 1, sum + arr[i]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        calc(0, 0);
        System.out.print(cnt);
    }
}