import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        
        for(int i = 0; i < arr1.length; i++)
            if(arr1[i] >= 'A' && arr1[i] <= 'Z')
                arr1[i] += 32;
        
        for(int i = 0; i < arr2.length; i++)
            if(arr2[i] >= 'A' && arr2[i] <= 'Z')
                arr2[i] += 32;
                
        int total = 0;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(int i = 0; i < arr1.length - 1; i++) {
            String s = arr1[i] + "" + arr1[i + 1];
            if(arr1[i] >= 'a' && arr1[i] <= 'z' && arr1[i + 1] >= 'a' && arr1[i + 1] <= 'z')
                map1.put(s, map1.getOrDefault(s, 0) + 1);
        }       
        
        for(int i = 0; i < arr2.length - 1; i++) {
            String s = arr2[i] + "" + arr2[i + 1];
            if(arr2[i] >= 'a' && arr2[i] <= 'z' && arr2[i + 1] >= 'a' && arr2[i + 1] <= 'z')
                map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        
        int cnt = 0;
        for(String s : map1.keySet()) {
            if(map2.containsKey(s)) {
                cnt += Math.min(map1.get(s), map2.get(s));
                total += Math.max(map1.get(s), map2.get(s));
            }else
                total += map1.get(s);
        }
        
        for(String s : map2.keySet())
            if(!map1.containsKey(s))
                total += map2.get(s);
        
        double rslt = (double)cnt / total * 65536;
        if(total == 0) rslt = 65536;
        else if(cnt == 0) rslt = 0;
        
        return (int)rslt;
    }
}