import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 10; i++) {
        	int n = Integer.parseInt(br.readLine());
            char[] str = new char[n];
            String s = br.readLine();
            str = s.toCharArray();
            
            int f = 1;
            Set<Character> set = new HashSet<>();
            set.add('(');
            set.add('<');
            set.add('{');
            set.add('[');
            
            Deque<Character> stack = new ArrayDeque<>();
            for(int j = 0; j < n; j++) {
                if(set.contains(str[j]))
                    stack.push(str[j]);
                else {
                     if(stack.isEmpty()) {
                         f = 0;
                         break;
                     }
                     if((str[j] == ')' && !stack.pop().equals('(')) ||  (str[j] == '>' && !stack.pop().equals('<')) || (str[j] == '}' && !stack.pop().equals('{')) || (str[j] == ']' && !stack.pop().equals('['))) {
                         f = 0;
                         break;
                     }
                }
            }
            
            System.out.println("#" + (i + 1) + " " + f);
        }
  }
}