import java.io.*;
import java.util.*;

class Top {
    int idx;      
    int height; 

    Top(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] laser = new int[n + 1];
        Stack<Top> stack = new Stack<>();
        
        for(int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            Top top = new Top(i, num);
            
            while(!stack.isEmpty()) {
                if(stack.peek().height <= num)
                    stack.pop();
                else {
                    laser[i] = stack.peek().idx;
                    break;
                }
            }
            stack.push(top);
        }
        
        for(int i = 1; i <= n; i++)
            System.out.print(laser[i] + " ");
    }
}