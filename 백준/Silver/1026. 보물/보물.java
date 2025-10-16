import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            list.add(b[i]);
        }
        
        int sum = 0;
        for(int i = 0; i < n; i++) {
            int max = 0;
            int maxIdx = 0;
            for(int j = 0; j < list.size(); j++) {
                if(list.get(j) > max) {
                    max = list.get(j);
                    maxIdx = j;
                }
            }
            
            sum += a[i] * max;
            list.remove(maxIdx);
        }
        
        System.out.println(sum);
    }
}