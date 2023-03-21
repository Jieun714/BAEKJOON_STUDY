package Tree;

/**
 * 작성자: 이지은
 * 문제: 트리가 주어졌을 때, 노드 하나를 지울 것이다. 그 때, 남은 트리에서 리프 노드의 개수를 구하는 프로그램을 작성하시오.
 *      노드를 지우면 그 노드와 노드의 모든 자손이 트리에서 제거된다.
 * 입력: 첫째 줄에 트리의 노드의 개수 N이 주어진다. N은 50보다 작거나 같은 자연수이다.
 *      둘째 줄에는 0번 노드부터 N-1번 노드까지, 각 노드의 부모가 주어진다. 만약 부모가 없다면 (루트) -1이 주어진다.
 *      셋째 줄에는 지울 노드의 번호가 주어진다.
 * 출력: 첫째 줄에 입력으로 주어진 트리에서 입력으로 주어진 노드를 지웠을 때, 리프 노드의 개수를 출력한다.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_1068 {
    static int N;  //노드의 개수
    static ArrayList <Integer> tree[]; //트리
    static int dNode; //지울 노드 번호
    static int root;
    static int leaf; //리프노드의 개수

    static void delete(int node) {
        if(node == dNode) return; //루트가 dNode인 경우
        if(tree[node].size() == 0) leaf++; //리프 노드 갯수 카운트
        for(int nextNode : tree[node]) {
            delete(nextNode);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];

        for(int i=0; i<tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) root = i;
            else tree[parent].add(i); //루트노드가 아닐 동안
        }

        dNode = Integer.parseInt(br.readLine());
        br.close();

        //해당 노드 삭제
        for(int i=0; i<N; i++) {
            tree[i].remove(Integer.valueOf(dNode));
        }

        //연관된 자식 노드 삭제
        delete(root);

        System.out.println(leaf);
    }
}
