import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < num; i++) {
        	int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            StringBuilder sb = new StringBuilder();
            sb.append("#" + (i + 1));
           	for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                if(p == 1) {
                    int k = Integer.parseInt(st.nextToken());
                    pq.add(k);
                } else {
                    if(pq.isEmpty())
                        sb.append(" -1");
            		else 
                        sb.append(" " + pq.poll());
                }
            }
            System.out.println(sb.toString());
        }
  }
}