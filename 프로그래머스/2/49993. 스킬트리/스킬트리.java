class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i = 0; i < skill_trees.length; i++) {
            char[] std = skill.toCharArray();
            char[] tree = skill_trees[i].toCharArray();
            int idx = 0;
            boolean f = true;
            for(char t : tree) {
                if(t == std[idx])
                    idx++;
                else if(skill.contains(Character.toString(t))){
                    f = false;
                    break;
                }
                if(idx == std.length){
                    break;
                }
            }
            
            if(f == true){
                answer++;
            }
        }
        return answer;
    }
}