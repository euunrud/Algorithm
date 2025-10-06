import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int count = 0;
        int open = 0;
        
        char[] pr = s.toCharArray();
        for(int i = 0; i< pr.length; i++) {
            if(pr[i] == '(' && pr[i + 1] == ')') {
                count += open;
                i++;
            }else if(pr[i] == '(') {
                open++;
            }else if(pr[i] == ')') {
                count++;
                open--;
            }
        }
        
        System.out.println(count);
    }
}