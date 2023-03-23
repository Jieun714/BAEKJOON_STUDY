package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_2589 {
    static int N, M;
    static char [][] map;
    static boolean [][] isVisited;
    static int [][] check;
    static int max = 0; //최단 거리
    static int cnt;
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {1, -1, 0, 0};

    static void bfs(int x, int y) {
        Queue <int []> que = new ArrayDeque<>();
        que.add(new int [] {x, y});
        isVisited[x][y] = true;

        for(int i=0; i<N; i++) {
            Arrays.fill(check[i], 0);
        }

        while(!que.isEmpty()) {
            int [] now = que.poll();

            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                //이동할 수 있는 구간일 때
                if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny] == 'L') {
                    if(!isVisited[nx][ny]) {
                        que.offer(new int [] {nx, ny});
                        check[nx][ny] = check[now[0]][now[1]] + 1;
                        max = Math.max(max, check[nx][ny]);
                        isVisited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  //가로
        M = Integer.parseInt(st.nextToken());  //세로

        map = new char[N][M];
        check = new int[N][M];

        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                cnt = 0;
                isVisited = new boolean[N][M];
                if(map[i][j] == 'L') bfs(i,j);
            }
        }

        System.out.println(max);
    }
}
