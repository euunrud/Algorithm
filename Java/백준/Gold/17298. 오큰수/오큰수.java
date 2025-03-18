
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> S = new Stack<>();
        int idx = 0;
        int[] A = new int[n];
        int[] rslt = new int[n];
        
        for(int i = 0; i < n; i++) {
        	A[i] = Integer.parseInt(st.nextToken());
        	rslt[i] = -1;
        }
        
        for (int i = 0; i < n; i++) {
        		while(!S.isEmpty() && A[i] > A[S.peek()]) {
        			rslt[S.pop()] = A[i];
        		}
        	S.push(i);
        }
                //print사용하면 시간 오래 걸림
//        for(int i = 0; i < n; i++) {
//        	System.out.print(rslt[i] + " ");
//        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < n; i++) {
        	bw.write(rslt[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
	}
}
