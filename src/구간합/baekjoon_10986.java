package 구간합;

/**
 * 작성자: 이지은
 *
 * 문제: 수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
 *       즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.
 * 입력: 첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)
 *       둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)
 * 출력: 첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력한다.
 *
 * 풀이: 구간 합과 조합공식을 사용.
 *      cnt과 mArr배열의 타입을 long으로 변경해주니 ArrayIndexOutOfBounds 해결
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_10986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N =Integer.parseInt(st.nextToken()); //주어진 수의 개수
        int M =Integer.parseInt(st.nextToken()); //나누는 수

        int[] arr= new int[N+1]; //누적합을 담을 배
        long cnt = 0; //연속된 합이 M으로 나누어떨어지는 (i,j) 쌍의 개수
        long [] mArr = new long[M]; // 같은 나머지의 인덱스를 카운트하는 배열

        st = new StringTokenizer(br.readLine(), " ");
        arr[0] = 0;

        for(int i=1; i<N+1; i++) {
            arr[i]= (arr[i-1] + Integer.parseInt(st.nextToken()))%M; //모듈러 연산
            if(arr[i] == 0) cnt++; //나누어 떨어지면 카운
            mArr[arr[i]]++; // 나머지가 동일한 인덱스의 수를 카운팅
        }

        for(int i=0; i<M; i++) { //조합공식을 사용
            cnt += mArr[i]*(mArr[i]-1)/2;
        }
        System.out.println(cnt);
    }
}
