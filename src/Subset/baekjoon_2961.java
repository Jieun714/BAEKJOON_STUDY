package Subset;

/**
 * 작성자: 이지은
 * 문제: 재료의 신맛과 쓴맛이 주어졌을 때, 신맛과 쓴맛의 차이가 가장 작은 요리를 만드는 프로그램을 작성하시오.
 *      재료는 적어도 하나 사용해야 한다. -> 공집합 제
 * 입력: 첫째 줄에 재료의 개수 N(1 ≤ N ≤ 10)이 주어진다. 다음 N개 줄에는 그 재료의 신맛과 쓴맛이 공백으로 구분되어 주어진다.
 *      모든 재료를 사용해서 요리를 만들었을 때, 그 요리의 신맛과 쓴맛은 모두 1,000,000,000보다 작은 양의 정수이다.
 * 출력: 첫째 줄에 신맛과 쓴맛의 차이가 가장 작은 요리의 차이를 출력한다.
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2961 {
    static int N;
    static int [] S, B;
    static boolean [] isSelected;
    static int sSum, bSum;
    static int min = 1000000000; //Integer.MAX_VALUE

    public static void subset(int num) {
        //종료 조건
        if(num == N) {
            sSum = 1;
            bSum = 0;
            for(int i=0; i<N; i++) {
                if(isSelected[i]) {
                    sSum *= S[i];
                    bSum += B[i];

                    min = Math.min(Math.abs(sSum-bSum),min);
                }
            }
            return;
        }

        /// 분할 ///
        isSelected[num] = true;
        subset(num+1);

        isSelected[num] = false;
        subset(num+1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); //재료의 갯수

        S = new int[N];
        B = new int[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            S[i] = Integer.parseInt(st.nextToken());  //신맛 *
            B[i] = Integer.parseInt(st.nextToken());  //쓴맛 +
        }
        isSelected = new boolean[N];

        subset(0);
        System.out.println(min);
    }
}
