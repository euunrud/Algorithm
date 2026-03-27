import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        String s = br.readLine();
        char[] arr = s.toCharArray();
        int cnt = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 'P') {
                int min = i - k >= 0 ? i - k : 0;
                int max = i + k < arr.length ? i + k : arr.length - 1;
                
                while(min <= max){
                    if(arr[min] == 'H') {
                        arr[min] = 'h';
                        cnt++;
                        break;
                    }
                    min++;
                }
            }
        }
        
        System.out.println(cnt);
    }
}