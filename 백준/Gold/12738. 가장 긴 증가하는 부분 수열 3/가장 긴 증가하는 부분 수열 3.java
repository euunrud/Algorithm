import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        list.add(arr[idx++]);
        
        while(idx < n) {
            if(arr[idx] > list.get(list.size() - 1)) {
                list.add(arr[idx]);
            } else {
                int left = 0;
                int right = list.size() - 1;
                
                while(left <= right) {
                    int mid = (left + right) / 2;
                    
                    if(list.get(mid) >= arr[idx])
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
                
                list.set(left, arr[idx]);
            }
            idx++;
        }
        
        System.out.print(list.size());
    }
}