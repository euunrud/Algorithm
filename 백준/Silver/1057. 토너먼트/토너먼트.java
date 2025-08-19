import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int round = Integer.parseInt(st.nextToken());
        int[] nums = new int[2];
        nums[0] = Integer.parseInt(st.nextToken());;
        nums[1] = Integer.parseInt(st.nextToken());;
        
        int meetRound = 1;
        while(meetRound <= round) {
            if(check(nums[0], nums[1])){
                break;
            }
            for(int i = 0; i < 2; i++) {
                if(nums[i] % 2 == 0) {
                    nums[i] /= 2;
                }else {nums[i]++;
                    nums[i] /= 2;
                }
            }
            //System.out.println(meetRound +", " + nums[0] + ", " + nums[1]);
            meetRound++;
        }
        
        System.out.println(meetRound);
    }
    
    static boolean check(int jm, int hs) {
        if(jm > hs) {
            if(jm - hs == 1 && jm % 2 == 0) {
                return true;
            }
        }else {
            if(hs - jm == 1 && hs % 2 == 0) {
                return true;
            }
        }
        return false;
    }
}