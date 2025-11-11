import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] sArr = new String[n];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++)
            sArr[i] = br.readLine();
        
        for(String a : sArr) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            ArrayDeque<Character> stack2 = new ArrayDeque<>();
            char[] cArr = a.toCharArray();
            for(char c: cArr) {
                if(c == '<') {
                    if(!stack.isEmpty())
                        stack2.push(stack.pop());
                } else if(c == '>') {
                    if(!stack2.isEmpty())
                        stack.push(stack2.pop());
                } else if(c == '-') {
                    if (!stack.isEmpty())
                        stack.pop();
                }else {
                    stack.push(c);
                }
            }
            
            while(!stack2.isEmpty())
                stack.push(stack2.pop());
                
            while(!stack.isEmpty()) 
                stack2.push(stack.pop());
            while(!stack2.isEmpty())
                sb.append(stack2.pop());
            sb.append('\n');
        }
        
        System.out.print(sb);
    }
}