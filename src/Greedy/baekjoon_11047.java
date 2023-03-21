package Greedy;

/**
 * 작성자: 이지은
 * 문제: 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
 * 입력: 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
 *      둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. 1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
 * 출력: 첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
 *
 * ** 그리디 알고리즘 사용
 * */
import java.util.Scanner;

public class baekjoon_11047 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int [] coin = new int[N];

        for(int i=0; i<N; i++) {
            coin[i] = sc.nextInt();
        }

        int cnt = 0; //동전의 갯수 카운트
        int i= N;
        /**
         * 이 문제에서는 입력이 오름차순으로 주어지지만,
         * 만약 순서가 없이 입력이된다면 sort로 오름차순으로 변경
         */
        while(M!=0 || i!=0) {
            i--;
            if(M/coin[i] != 0) {
                cnt += (M/coin[i]);
                M = M%coin[i];
            }
        }
        System.out.println(cnt);
    }
}
