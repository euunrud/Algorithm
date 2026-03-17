import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        int p1 = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            int num = map.getOrDefault(arr[i], 0) + 1;
            while(num > k) {
                if(arr[p1] == arr[i])  num--;
                map.put(arr[p1], map.getOrDefault(arr[p1], 0) - 1);
                p1++;
                if(p1 == i) break;
            }
            map.put(arr[i], num);
            max = Math.max(max, i - p1 + 1);
        }
        
        System.out.print(max);
    }
}