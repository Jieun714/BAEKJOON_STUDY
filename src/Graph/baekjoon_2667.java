package Graph;
/**
 * 문제: <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
 *      여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
 *      지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 * 입력: 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
 * 출력: 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
 * 해결: BFS
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_2667 {
    public static int N;
    public static int [][] map;
    public static boolean [][] isVisited;
    public static int [] dx = {0, 0, -1, 1}; //상하좌우 탐색
    public static int [] dy = {1, -1, 0, 0};

    public static boolean isChecked(int y, int x, int num) {
        if(y < 0 || y >= N || x < 0 || x >= N) return false; //범위를 넘어가면 false
        return !isVisited[y][x] && map[y][x] == num; //방문한 적 없고, 탐색하고 있는 단지번호와 현재 단지번호가 동일할 때
    }

    public static int bfs(int y, int x, int num) {
        int cnt = 1; //현재 위치 포함이기 때문에 1로 초기화
        Queue<int []> que = new ArrayDeque<>();
        que.add(new int[]{y, x});
        isVisited[y][x] = true; //방문 처리

        while(!que.isEmpty()) {
            int [] now = que.poll();
            for(int i=0; i<4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(isChecked(ny, nx, num)) {
                    que.add(new int[]{ny, nx});
                    isVisited[ny][nx] = true; //방문 처리
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++)  map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
        }

        List<Integer> list = new ArrayList<>(); //단지 내 집 수를 담는 리스트
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!isVisited[i][j] && map[i][j] != 0) { //방문하지 않는 단지일 때만 로직 수행
                    list.add(bfs(i, j, map[i][j]));
                }
            }
        }

        Collections.sort(list); //각 단지내 집의 수를 오름차순으로 정렬
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for(int num : list) sb.append(num).append("\n");
        System.out.println(sb); //결과 출력
    }
}