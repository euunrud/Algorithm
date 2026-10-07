import java.io.*;
import java.util.*;

class Solution {
    int len = 0;
    String rslt = "";
    public void dfs(String[] arr, boolean[] vst, int num, int idx, String rt) {           
        if(rslt.length() > 1) {  return;    }
        if(num == len) {
            rslt = rt + " " + arr[idx].substring(3, 6);
            return;
        }
        
        boolean flag = false;
        String dpt = arr[idx].substring(3, 6);
        for(int i = 0; i < len; i++) {
            if(vst[i] == false && arr[i].substring(0, 3).equals(dpt)) {
                flag = true;
                vst[i] = true;
                dfs(arr, vst, num + 1, i, rt + " " + dpt);
                vst[i] = false;
            } else {
                if(flag) break;
            }
        }
    }
    public String[] solution(String[][] tickets) {
        len = tickets.length;
        
        String[] tArr = new String[len];
        
        for(int i = 0; i < len; i++) {
            tArr[i] = tickets[i][0] + "" + tickets[i][1];
        }
        Arrays.sort(tArr);
        
        boolean[] vst = new boolean[len];
        boolean flag = false;
        for(int i = 0; i < len; i++) {
            if(tArr[i].substring(0, 3).equals("ICN")) {
                flag = true;
                vst[i] = true;
                dfs(tArr, vst, 1, i, "ICN");
                vst[i] = false;
            }else {
                if(flag) break;
            }
        }
        
        String[] answer = rslt.split(" ");
        return answer;
    }
}