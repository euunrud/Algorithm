import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        String[] sList = new String[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            sList[i] = s.substring(i); 
        }
        
        for (int i = 0; i < s.length(); i++) {
            int now = i;
            for (int j = i + 1; j < s.length(); j++) {
                if (sList[now].compareTo(sList[j]) > 0) { 
                    now = j;
                }
            }
            String temp = sList[i];
            sList[i] = sList[now];
            sList[now] = temp;
        }
        
        for (int i = 0; i < s.length(); i++) {
            System.out.println(sList[i]);
        }
    }
}
