class Solution {
    static String change(String s) {
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '#') {
                char c = s.charAt(i - 1);
                c += 32;
                s = s.substring(0, i - 1) + c + s.substring(i + 1, s.length());
                i--;
            }
        }
        return s;
    }
    static int calc(String s1, String s2) {
        int hh1 = Integer.parseInt(s1.split(":")[0]);
        int mm1 = Integer.parseInt(s1.split(":")[1]);
        int hh2 = Integer.parseInt(s2.split(":")[0]);
        int mm2 = Integer.parseInt(s2.split(":")[1]);
        
        if(hh1 == hh2)
            return mm2 - mm1;
        return (hh2 - hh1 - 1) * 60 + (60 - mm1) + mm2;
    }
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int len = musicinfos.length;
        String[][] infos = new String[len][4];
        
        m = change(m);
        for(int i = 0; i < len; i++) {
            infos[i] = musicinfos[i].split(",");
            int play = calc(infos[i][0], infos[i][1]);
            infos[i][3] = change(infos[i][3]);
            String ns = "";
            
            while(play > 0) {
                if(play >= infos[i][3].length()) {
                    ns += infos[i][3];
                    play -= infos[i][3].length();
                } else {
                    ns += infos[i][3].substring(0, play);
                    play = 0;
                }
            }
            infos[i][3] = ns;
        }
        
        String rslt = "";
        int pTime = -1;
        for(int i = 0; i < len; i++)
            if(infos[i][3].contains(m)) {
                int t = calc(infos[i][0], infos[i][1]);
                if(t > pTime) {
                    rslt = infos[i][2];
                    pTime = t;
                }
            }
        
        if(pTime == -1) rslt = "(None)";
        return rslt;
    }
}