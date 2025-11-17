import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sp = new int[n];
        for(int i = 0; i < n; i++)
            sp[i] = Integer.parseInt(br.readLine());
        Arrays.sort(sp);
        
        //인접한 거리를 이진탐색으로 구함. 1 ~ 최대 거리
        int left = 1; 
        int right = sp[n - 1] - sp[0];
        int answer = right;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int cnt = 1;
            int num = sp[0];
            for(int i = 1; i < n; i++)
                if(num + mid <= sp[i]) {
                    cnt++;
                    num = sp[i];
                }
            
            if(cnt >= c) {
                answer = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        
        System.out.println(answer);
    }
}