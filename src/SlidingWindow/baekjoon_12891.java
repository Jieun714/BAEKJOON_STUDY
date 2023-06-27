package SlidingWindow;
/**
 * 문제: 민호가 만든 임의의 DNA 문자열과 비밀번호로 사용할 부분분자열의 길이, 그리고 {‘A’, ‘C’, ‘G’, ‘T’} 가 각각 몇번 이상 등장해야 비밀번호로 사용할 수 있는지 순서대로 주어졌을 때
 *      민호가 만들 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하자. 단 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급한다.
 * 입력: 첫 번째 줄에 민호가 임의로 만든 DNA 문자열 길이 |S|와 비밀번호로 사용할 부분문자열의 길이 |P| 가 주어진다. (1 ≤ |P| ≤ |S| ≤ 1,000,000)
 *      두번 째 줄에는 민호가 임의로 만든 DNA 문자열이 주어진다.
 *      세번 째 줄에는 부분문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수가 공백을 구분으로 주어진다. 각각의 수는 |S| 보다 작거나 같은 음이 아닌 정수이며 총 합은 |S| 보다 작거나 같음이 보장된다.
 * 출력: 첫 번째 줄에 민호가 만들 수 있는 비밀번호의 종류의 수를 출력해라.
 * 해결: 슬라이딩 윈도우
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); //DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken()); //비밀번호로 사용할 부분문자열의 길이
        String dna = br.readLine();
        int [] arr = new int[4]; //{‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수를 담을 배열
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0; //부분 문자열을 만들 수 있는 개수
        int a = 0, c = 0, g = 0, t = 0;

        //첫 윈도우(부분 문자열)
        for(int i=0; i<P; i++) {
            if(dna.charAt(i) == 'A') a++;
            else if(dna.charAt(i) == 'C') c++;
            else if(dna.charAt(i) == 'G') g++;
            else if(dna.charAt(i) == 'T') t++;
        }

        if(a>=arr[0] && c>=arr[1] && g>=arr[2] && t>=arr[3]) cnt++;

        //이후 윈도우 체크
        for(int i=0; i<S-P; i++) {
            //맨 앞에 문자 제거
            if(dna.charAt(i) == 'A') a--;
            else if(dna.charAt(i) == 'C') c--;
            else if(dna.charAt(i) == 'G') g--;
            else if(dna.charAt(i) == 'T') t--;

            //맨 뒤에 문자 추가
            if(dna.charAt(i+P) == 'A') a++;
            else if(dna.charAt(i+P) == 'C') c++;
            else if(dna.charAt(i+P) == 'G') g++;
            else if(dna.charAt(i+P) == 'T') t++;

            if(a>=arr[0] && c>=arr[1] && g>=arr[2] && t>=arr[3]) cnt++;
        } //for end

        System.out.println(cnt); //결과출력
    }
}