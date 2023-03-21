package TwoPointer;

/**
 * 작성자: 이지은
 * 문제: 민호가 만들 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하자.
 *      단 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급한다.
 * 입력: 첫 번째 줄에 민호가 임의로 만든 DNA 문자열 길이 |S|와 비밀번호로 사용할 부분문자열의 길이 |P| 가 주어진다.
 *      두번 째 줄에는 민호가 임의로 만든 DNA 문자열이 주어진다.
 *      세번 째 줄에는 부분문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수가 공백을 구분으로 주어진다.
 *      각각의 수는 |S| 보다 작거나 같은 음이 아닌 정수이며 총 합은 |S| 보다 작거나 같음이 보장된다.
 * 출력: 첫 번째 줄에 민호가 만들 수 있는 비밀번호의 종류의 수를 출력해라.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_12891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int S = Integer.parseInt(st.nextToken()); //DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken()); //비밀번호로 사용할 부분문자열의 길이

        char[] dnaArr = br.readLine().toCharArray(); //임의로 만든 DNA 문자열

        st = new StringTokenizer(br.readLine());
        int [] partArr = new int[4];  //{‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수를 담을 배열
        for(int i=0; i<4; i++) {
            partArr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0; //부분 문자열을 만들 수 있는 개수
        int a = 0, c = 0, g = 0, t = 0;

        //첫 윈도우(부분 문자열)
        for(int i=0; i<P; i++) {
            if(dnaArr[i] == 'A') a++;
            else if(dnaArr[i] == 'C') c++;
            else if(dnaArr[i] == 'G') g++;
            else if(dnaArr[i] == 'T') t++;
        }

        if(a>=partArr[0] && c>=partArr[1] && g>=partArr[2] && t>=partArr[3])
            cnt++;
        System.out.println("for문 전"+a+" "+c+" "+g+" "+t+" ");

        //이후 윈도우 체크
        for(int i=0; i<S-P; i++) {
            //맨 앞에 문자 제거
            if(dnaArr[i] == 'A') a--;
            else if(dnaArr[i] == 'C') c--;
            else if(dnaArr[i] == 'G') g--;
            else if(dnaArr[i] == 'T') t--;

            System.out.println(a+" "+c+" "+g+" "+t+" ");

            //맨 뒤에 문자 추가
            if(dnaArr[i+P] == 'A') a++;
            else if(dnaArr[i+P] == 'C') c++;
            else if(dnaArr[i+P] == 'G') g++;
            else if(dnaArr[i+P] == 'T') t++;

            System.out.println(a+" "+c+" "+g+" "+t+" ");
            if(a>=partArr[0] && c>=partArr[1] && g>=partArr[2] && t>=partArr[3])
                cnt++;
        }

        System.out.println(cnt);
    }
}
