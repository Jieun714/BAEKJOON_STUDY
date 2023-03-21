package Tree;

/**
 * 작성자: 이지은
 * 문제: 이진 트리를 입력받아 전위 순회, 중위 순회, 후위 순회한 결과를 출력하는 프로그램을 작성하시오.
 * 입력 예시
 * 7
 * A B C
 * B D .
 * C E F
 * E . .
 * F . G
 * D . .
 * G . .
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class baekjoon_1991 {
    static int N;
    static int [][] tree;

    //전위 순회
    static void perorder(int nowNode) {
        if(nowNode == -19) return;
        System.out.print((char)(nowNode +65));
        perorder(tree[nowNode][0]);
        perorder(tree[nowNode][1]);
    }

    //중위 순회
    static void inrorder(int nowNode) {
        if(nowNode == -19) return;
        inrorder(tree[nowNode][0]);
        System.out.print((char)(nowNode +65));
        inrorder(tree[nowNode][1]);
    }

    //후위 순회
    static void postrorder(int nowNode) {
        if(nowNode == -19) return;
        postrorder(tree[nowNode][0]);
        postrorder(tree[nowNode][1]);
        System.out.print((char)(nowNode +65));
    }

    //BFS
    static void bfs(int root) {
        Queue <Integer> que = new ArrayDeque<>();
        que.add(root);

        while(!que.isEmpty()) { //큐가 빌때까지
            int nowNode = que.poll();
            if(nowNode == -19) continue;  //말단 노드인 경우
            System.out.print((char)( nowNode + 65));  //현재 노드 출력
            for(int nextNode : tree[nowNode]) {
                que.add(nextNode);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new int[N][2];

        for(int i=0; i<N; i++) {
            String [] temp = br.readLine().split(" ");
            int node = temp[0].charAt(0) - 'A';
            int left = temp[1].charAt(0) - 'A';
            int right = temp[2].charAt(0) - 'A';

            tree[node][0] = left;
            tree[node][1] = right;
        }

        //전위
        perorder(0);
        System.out.println();

        //중위
        inrorder(0);
        System.out.println();

        //후위
        postrorder(0);
        System.out.println();

        //bfs 사용
        bfs(0);

    }
}
