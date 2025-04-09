import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String s = br.readLine();
        String[] arr = s.split("-");
        int result = calc(arr[0]);
        for(int i = 1; i < arr.length; i++) {
        	result -= calc(arr[i]);
        }
        
        System.out.println(result);
	}
	
	static int calc(String a) {
		String[] nums = a.split("\\+");
		int num = 0;
		for(int i = 0; i < nums.length;i++) {
			//System.out.println("n[] = " + nums[i]);
			if(!nums[i].equals("+")) {
				num += Integer.parseInt(nums[i]);
			}
		}
		return num;
	}
}
