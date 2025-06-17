package Dijkstra;
/**
 * 문제: 농부 현서는 농부 찬홍이에게 택배를 배달해줘야 합니다. 그리고 지금, 갈 준비를 하고 있습니다. 평화롭게 가려면 가는 길에 만나는 모든 소들에게 맛있는 여물을 줘야 합니다. 물론 현서는 구두쇠라서 최소한의 소들을 만나면서 지나가고 싶습니다.
 *      농부 현서에게는 지도가 있습니다. N (1 <= N <= 50,000) 개의 헛간과, 소들의 길인 M (1 <= M <= 50,000) 개의 양방향 길이 그려져 있고, 각각의 길은 C_i (0 <= C_i <= 1,000) 마리의 소가 있습니다.
 *      소들의 길은 두 개의 떨어진 헛간인 A_i 와 B_i (1 <= A_i <= N; 1 <= B_i <= N; A_i != B_i)를 잇습니다. 두 개의 헛간은 하나 이상의 길로 연결되어 있을 수도 있습니다. 농부 현서는 헛간 1에 있고 농부 찬홍이는 헛간 N에 있습니다.
 * 농부 현서의 지도가 주어지고, 지나가는 길에 소를 만나면 줘야할 여물의 비용이 주어질 때 최소 여물은 얼마일까요? 농부 현서는 가는 길의 길이는 고려하지 않습니다.
 * 입력: 첫째 줄에 N과 M이 공백을 사이에 두고 주어집니다.
 *      둘째 줄부터 M+1번째 줄까지 세 개의 정수 A_i, B_i, C_i가 주어집니다.
 * 출력: 첫째 줄에 농부 현서가 가져가야 될 최소 여물을 출력합니다.
 * 해결: 데이크스트라
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_5972 {
    static class Node {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static int N, M; //헛간, 소들의 길이
    public static List<Node> [] graph; //그래프 정보를 담는 배열
    public static int [] dist;

    public static void dijkstra() {
        //우선 순위 큐 - 가중치를 기준으로 오름차순 정렬
        PriorityQueue<Node> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        que.add(new Node(1, 0));
        dist[1] = 0; //시작노드는 0으로 초기화

        while(!que.isEmpty()) {
            Node now = que.poll();

            if(dist[now.node] < now.cost) continue; //처리된 적이 있는 노드라면 무시
            for(Node next : graph[now.node]) {
                int nextCost = now.cost + next.cost;
                if(dist[next.node] > nextCost) {
                    dist[next.node] = nextCost;
                    que.add(new Node(next.node, dist[next.node]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE; //최대값으로 초기화
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); //헛간 A
            int B = Integer.parseInt(st.nextToken()); //헛간 B
            int C = Integer.parseInt(st.nextToken()); //A와 B의 비용
            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        dijkstra(); //함수 호출
        System.out.println(dist[N]);
    }
}