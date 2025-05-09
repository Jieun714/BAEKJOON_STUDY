package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_4963 {
    public static int [][] map;
    public static boolean [][] isVisited;
    public static int [] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; //서 북서 북 북동 동 낭동 남 남서
    public static int [] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int cnt;

    public static boolean isCheck(int y, int x) {
        if(y < 0 || y >= map.length || x < 0 || x >= map[0].length) return false;
        return map[y][x] == 1 && !isVisited[y][x];
    }

    public static void bfs(int y, int x) {
        cnt++; //섬의 개수 증가
        Queue<int []> que = new ArrayDeque<>();
        que.add(new int[]{y, x});
        isVisited[y][x] = true;

        while(!que.isEmpty()) {
            int [] now = que.poll();
            for(int i=0; i<8; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(isCheck(ny, nx)) {
                    isVisited[ny][nx] = true;
                    que.add(new int[]{ny, nx});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); //너비
            int h = Integer.parseInt(st.nextToken()); //높이

            if(w == 0 && h == 0) break; //종료 조건

            map = new int[h][w];
            isVisited = new boolean[h][w];
            for(int i = 0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<w; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            cnt = 0;
            for(int i = 0; i<h; i++) {
                for(int j = 0; j<w; j++) {
                    if(map[i][j] == 1 && !isVisited[i][j]) bfs(i, j);
                }
            }

            sb.append(cnt).append("\n"); //섬의 개수 저장
        }

        System.out.println(sb); //결과 출력
    }
}
