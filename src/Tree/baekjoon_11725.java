package Tree;

/**
 * 작성자: 이지은
 * 문제 : 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
 * 입력 : 첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
 * 출력 : 첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
 * */

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon_11725 {
    //인접 리스트
    static int N;
    static ArrayList <Integer> tree[];
    static boolean [] isVisited;
    static int [] parent;  //정답을 담을 배열

    /*
     * node -> nextNoe
     * 부모  -> 자식
     * parent[자식] = 부모
     * */
    static void Search(int node) {
        for(int nextNode : tree[node]) {
            //한번 방문한 노드는 다시 방문하지 않도록
            if(!isVisited[nextNode]) {
                isVisited[nextNode] = true;
                Search(nextNode);
                parent[nextNode] = node;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        tree = new ArrayList[N+1];
        isVisited = new boolean[N+1];
        parent = new int[N+1];

        for(int i=0; i<tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        //RoteNode 부터 탐색
        isVisited[1] = true;
        Search(1);

        for(int i=2; i<N+1; i++) {
            System.out.println(parent[i]);
        }

    }
}
