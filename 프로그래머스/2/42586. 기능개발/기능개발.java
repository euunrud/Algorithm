import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] ss = new int[speeds.length];
        for(int i = 0; i < progresses.length; i++) {
            queue.add(progresses[i]);
            ss[i] = speeds[i];
        }
        int num = 0;
        while(queue.size() > 0) {
            cnt = 0;
            //if(num > 0) {
                
            //}
            while (!queue.isEmpty() && queue.peek() + speeds[num] >= 100) {
                //System.out.println(queue.peek());
                queue.poll();
                cnt++;
                if (num < speeds.length - 1) {
                    num++;
                }else {
                    break;
                }

            }
            if(cnt > 0) {
                list.add(cnt);
            }
            for(int i = num; i < speeds.length; i++) {
                    speeds[i] += ss[i];
            }
        }

        int[] arr = list.stream()
                .mapToInt(i -> i)
                .toArray();

        return arr;
    }
}