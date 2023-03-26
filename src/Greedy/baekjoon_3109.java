package Greedy;

/**
 * 문제: 원웅이 빵집의 모습이 주어졌을 때, 원웅이가 설치할 수 있는 가스관과 빵집을 연결하는 파이프라인의 최대 개수를 구하는 프로그램을 작성하시오.
 *
 * 그리디 알고리즘을 활용한 백트래킹
 * 각 칸은 오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선으로 연결할 수 있다 -> 오른쪽 위, 오른쪽, 오른쪽 아래 순으로 탐색
 * 가장 왼쪽 열에서 가장 오른쪽 열 방향으로 탐색
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_3109 {
    static int R, C;  //RxC
    static char[][] map;  //빵집 주변 2차원 영역
    static boolean[][] isVisited;  //방문 체크할 2차원 배열
    static int[] dx = {1, 1, 1};
    static int[] dy = {-1, 0, 1};
    static int cnt = 0; //최대 파이프라인 갯수
    static boolean flag;	// 길을 찾았는지 검사할 boolean 변수

    //재귀 사용 DFS
    static void dfs(int y, int x){
        if(flag) return;   // 만약 길을 찾았다면 해당 탐색 종료
        isVisited[y][x] = true;

        if (x == C - 1) {
//            flag = true;
            cnt++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (nx < 0 || nx >= C || ny < 0 || ny >= R || isVisited[ny][nx]) continue;

            if (map[ny][nx] == 'x') continue; //건물이 있으먼 패스

            dfs(ny, nx);  //다음좌표 탐색
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
        }

        isVisited = new boolean[R][C];

        //BFS 호출
        for (int i = 0; i < R; i++) {
            flag = false;
            dfs(i, 0 );
            if(flag) cnt++;  //flag가 true이면
        }

        //배열 확인
//        for(char [] a: map) {
//            System.out.println(Arrays.toString(a));
//        }

        System.out.println(cnt);
    }
}

