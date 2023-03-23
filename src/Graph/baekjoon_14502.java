package Graph;

/**
 * 작성자: 이지은
 * 문제: 인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.
 *       연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다.
 *       일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
 *
 * 1. 총 3개의 벽 세우기 - DFS
 * 2. 바이러스 퍼트리기 - BFS
 * 3. 안전지대 최댓값 찾기
 *
 * 0: 빈칸  1: 가벽  2: 바이러스
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_14502 {
    static int N, M;
    static int[][] map, newMap;
    static int max = 0; //최대 갯수
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };
    static Queue<int[]> que = new ArrayDeque<>();

    // 벽을 만들기 위한 dfs
    public static void dfs(int depth) {
        if (depth == 3) { // 3개의 벽을 세우면
            newMap = new int[N][M]; // 추가한 벽을 포함한 새로운 배열

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    newMap[i][j] = map[i][j]; // 새로운 맵에 기존 맵 삽입

                    if (newMap[i][j] == 2)
                        que.offer(new int [] {i, j}); // offer로 시작할 노드 삽입
                }
            }
            bfs(); // 바이러스를 퍼트릴 bfs 호출

            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) { // 빈칸이면
                    map[i][j] = 1;    //가벽 세움
                    dfs(depth + 1);  // 재귀
                    map[i][j] = 0;
                }
            }
        }
    }

    // 바이러스 퍼트리기
    public static void bfs() {
        while (!que.isEmpty()) {
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                //해당 범위 안에 존재 시
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && newMap[nx][ny] == 0) {
                    newMap[nx][ny] = 2; // 바이러스로 전환
                    que.offer(new int[] { nx, ny });
                } ///if문 end
            } // for문  end
        }
        safeCount();
    }

    // 안전지대 찾기
    public static void safeCount() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newMap[i][j] == 0) {
                    count++; // 배열의 값이 0인 지점 ++
                }
            }
        }
        max = Math.max(max, count); // 최대를 찾음
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);  //벽 세우기

        System.out.println(max);  //안전 영역의 최대 크기 출력
    }
}
