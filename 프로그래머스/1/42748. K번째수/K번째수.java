import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i =0; i < commands.length; i++) {
            int leng = commands[i][1] - commands[i][0] + 1;
            int[] arr = new int[leng];
            int k = 0;
            for(int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                arr[k++] = array[j];
            }
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2]-1];
        }

        //System.out.println(Arrays.toString(answer));
        return answer;
    }
}