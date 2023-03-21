package Permutation;

/**
 * 작성자: 이지은
 * 문제: 서로 다른 숫자와 문자로 이루어진 집합과 위치가 주어졌을 때, 그 집합의 순열 중 주어진 위치의 순열을 구하는 프로그램을 작성하시오.
 * 입력: 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있다.
 *      첫 번째 문자열은 서로 다른 숫자와 알파벳으로 이루어져 있으며, 길이는 최대 10이다. 사전순 순서대로 주어진다.
 *      문자열 다음에는 찾아야 하는 위치가 주어지며, 이 값은 3,628,800보다 작거나 같은 자연수이다.
 * 출력: 각각의 테스트 케이스마다, 입력으로 주어진 위치에 해당하는 순열을 공백없이 출력한다.
 *      만약, 해당하는 순열이 없는 경우에는 "No permutation"을 출력한다.
 *
 * 여러개의 입력이 주어짐으로 java EOF처리를 해줘야함
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_9742 {
    static char [] arr;
    static int N;
    static int k;

    static int cnt;
    static char [] selection;
    static boolean [] isSelected;

    static void permutation(int r) {
        //종료조건
        if(r == N) {
            if(++cnt == k) {
                System.out.print(String.valueOf(arr)+ " " + k + " = ");
                for(int i=0; i<N; i++) System.out.print(selection[i]);
                System.out.println();
            }
            return;
        }

        for(int i =0; i<N; i++) {
            if(isSelected[i]) continue;
            isSelected[i] = true;
            selection[r] = arr[i];
            permutation(r+1);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = br.readLine();
            if(str == null) break;

            StringTokenizer st = new StringTokenizer(str);
            arr = st.nextToken().toCharArray();
            k = Integer.parseInt(st.nextToken());
            N = arr.length;

            selection = new char[N];
            isSelected = new boolean[N];

            cnt = 0;
            permutation(0);

            if(k>cnt) { //해당하는 순열이 없는 경우
                System.out.print(String.valueOf(arr)+ " " + k + " = ");
                System.out.println("NO permutaion");
            }
        }
    }
}
