import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] num;
	static int[] cnt;
	static char[] arr;
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sl = Integer.parseInt(st.nextToken());
        int pl = Integer.parseInt(st.nextToken());
        arr = new char[sl];
        arr = br.readLine().toCharArray();
        num = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
        	num[i] = Integer.parseInt(st.nextToken());
        }
        cnt = new int[4];// A C G T
        int start = 0;
        int end = pl - 1;
        int sum = 0;

        for(int i = 0; i < pl; i++) {
        	add(i);
        }
        
        while(end < sl) {
        	//System.out.println("0/ " + cnt[0] + " 1/ " + cnt[1] +" 2/ " + cnt[2] + " 3/ " + cnt[3]);
        	if((num[0] <= cnt[0]) && (num[1] <= cnt[1]) && (num[2] <= cnt[2]) && (num[3] <= cnt[3])) {
        		sum++;
        		remove(start);
        		start++;
        		end++;
        		if(end == sl) {
        			break;
        		}
        		add(end);
        	} else {
        		remove(start);
        		start++;
        		end++;
        		if(end == sl) {
        			break;
        		}
        		add(end);        		
        	}
        }
        System.out.println(sum);
	}
	
	private static void remove(int i) { 
		//System.out.println("s- " + i);
		if(arr[i] == 'A') {
    		cnt[0]--;
    	}else if(arr[i] == 'C') {
    		cnt[1]--;
    	}else if(arr[i] == 'G') {
    		cnt[2]--;
    	}else if(arr[i] == 'T') {
    		cnt[3]--;
    	}
	}

	private static void add(int i) { 
		//System.out.println("e- " + i);
		if(arr[i] == 'A') {
    		cnt[0]++;
    	}else if(arr[i] == 'C') {
    		cnt[1]++;
    	}else if(arr[i] == 'G') {
    		cnt[2]++;
    	}else if(arr[i] == 'T') {
    		cnt[3]++;
    	}
	}
}