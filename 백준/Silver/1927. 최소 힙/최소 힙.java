import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(pq.isEmpty()) 
                    sb.append("0");
                else 
                    sb.append(pq.poll());
                sb.append("\n");
            }else {
                pq.offer(num);
            }
        }
        
        System.out.print(sb.toString());
    }
}