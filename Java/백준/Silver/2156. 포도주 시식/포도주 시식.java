import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int idx;
	static int n, m;
	static int[] list;
	static int[] vst;
	static int max = 0;
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        list = new int[n + 1];
        vst = new int[n + 1];
        for(int i = 1; i <= n; i++) {
        	list[i] = Integer.parseInt(br.readLine());
        }
        
        if(n == 1) {
        	System.out.println(list[1]);
        	return;
        }
        vst[1] = list[1];
        vst[2] = list[2] + list[1];
        for(int i = 3; i <= n; i++) {
        	max = Math.max(vst[i - 1], Math.max(vst[i - 2] + list[i], vst[i - 3] + list[i - 1] + list[i]));
        	vst[i] = max;
        }
        System.out.print(vst[n]);
	}
	
}