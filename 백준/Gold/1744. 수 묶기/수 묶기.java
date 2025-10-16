import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        
        int sum = 0;
        int[] arr2 = {};
        
        for(int i = 0; i < n; i++) {
            if(i + 1 < n)
                if(arr[i] <= 0 && arr[i + 1] <= 0) {
                    sum += arr[i] * arr[i + 1];
                    i++;
                    continue;
                }
           
            if(arr[i] <= 0) {
                sum += arr[i];
                continue;
            }
            arr2 = Arrays.copyOfRange(arr, i, n);
            break;
        }
        
        for(int i = arr2.length - 1; i >= 0; i--) {
            if(i - 1 >= 0) 
                if(arr2[i] > 1 && arr2[i - 1] > 1) {
                    sum += arr2[i] * arr2[i - 1];
                    i--;
                    continue;
                }
            
            sum += arr2[i];
        }
        
        System.out.println(sum);
    }
}