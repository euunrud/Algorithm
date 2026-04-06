import java.io.*;
import java.util.*;

class Main {
    static class Ball {
        int r;
        int c;
        int mi;
        int s;
        int d;

        Ball(int r, int c, int mi, int s, int d) {
            this.r = r;
            this.c = c;
            this.mi = mi;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Ball> balls = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int mi = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            balls.add(new Ball(r, c, mi, s, d));
        }

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 0; i < k; i++) {
            Map<String, List<Ball>> map = new HashMap<>();

            for (Ball b : balls) {
                int r = (b.r - 1 + dx[b.d] * (b.s % n) + n * n) % n + 1;
                int c = (b.c - 1 + dy[b.d] * (b.s % n) + n * n) % n + 1;

                Ball nb = new Ball(r, c, b.mi, b.s, b.d);
                String key = r + " " + c;

                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(nb);
            }

            balls = new ArrayList<>();

            for (List<Ball> list : map.values()) {
                if (list.size() == 1) {
                    balls.add(list.get(0));
                    continue;
                }

                int sumM = 0;
                int sumS = 0;
                boolean same = true;
                int first = list.get(0).d % 2;

                for (Ball b : list) {
                    sumM += b.mi;
                    sumS += b.s;
                    if (first != b.d % 2) same = false;
                }

                int nm = sumM / 5;
                if (nm == 0) continue;

                int ns = sumS / list.size();
                int d = same ? 0 : 1;

                for (int j = 0; j < 4; j++) {
                    Ball nb = new Ball(list.get(0).r, list.get(0).c, nm, ns, d + 2 * j);
                    balls.add(nb);
                }
            }
        }

        int rslt = 0;
        for (Ball b : balls) {
            rslt += b.mi;
        }

        System.out.println(rslt);
    }
}