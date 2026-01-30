import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[m];
        int max = 0;
        int idx = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
            if(max == arr[i])
                idx = i;
        }
        
        Stack<Integer> stack = new Stack<>();
        int scd = 0;
        int rslt = 0;
        for(int i = 0; i < idx; i++) {
           if(arr[i] >= scd) {
               while(scd != 0 && !stack.isEmpty())
                    rslt += scd - stack.pop();
               scd = arr[i];
            }
            stack.push(arr[i]);
        }
        
        while(!stack.isEmpty())
            rslt += scd - stack.pop();
        
        stack.clear();
        scd = 0;
        for(int i = m - 1; i > idx; i--) {
           if(arr[i] >= scd) {
               while(!stack.isEmpty())
                    rslt += scd - stack.pop();
               scd = arr[i];
            }
            stack.push(arr[i]);
        }
        
        while(scd != 0 && !stack.isEmpty())
            rslt += scd - stack.pop();
        System.out.print(rslt);
    }
}