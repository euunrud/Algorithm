import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.replace("{{", "");
        s = s.replace("}}", "");
        
        String[] arr = s.split("\\},\\{");
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        int len = arr[arr.length - 1].split(",").length;
        int[] answer = new int[len];
        Set<Integer> set = new TreeSet<>();
        
        for(int i = 0; i < arr.length; i++) {
            String[] list = arr[i].split(",");
            for(int j = 0; j < list.length; j++) {
                int n = Integer.parseInt(list[j]);
                if(!set.contains(n)) {
                    answer[i] = n;
                    set.add(n);
                    break;
                }
            }
        }
        return answer;
    }
}