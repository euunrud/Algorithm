import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] scores = new int[num];
		int[] check = new int[num];
		for(int i = 0; i < num; i++) {
		    scores[i] = Integer.parseInt(st.nextToken());
		    if(i > 0) {
		        check[i] = scores[i] < scores[i - 1] ?check[i - 1] + 1:check[i - 1];
		    }
		} 
		
		int qNum = Integer.parseInt(br.readLine());
		int[] cnt = new int[qNum];
		for(int i = 0; i < qNum; i++) {
		    st = new StringTokenizer(br.readLine());
		    int num1 = Integer.parseInt(st.nextToken());
		    int num2 = Integer.parseInt(st.nextToken());
		    
		    cnt[i] = check[num2 - 1] - check[num1 - 1];
		}
		
        for(int i = 0; i < qNum; i++) {
            System.out.println(cnt[i]);
        }
    }
}