import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] stack = new int[n];
        int top = 0;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                int x = Integer.parseInt(st.nextToken());
                stack[top++] = x;
            } else if (cmd == 2) {
                if (top == 0) 
                    sb.append(-1).append('\n');
                else 
                    sb.append(stack[--top]).append('\n');
            } else if (cmd == 3) {
                sb.append(top).append('\n');
            } else if (cmd == 4) {
                sb.append(top == 0 ? 1 : 0).append('\n');
            } else {
                if (top == 0) 
                    sb.append(-1).append('\n');
                else 
                    sb.append(stack[top - 1]).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}
