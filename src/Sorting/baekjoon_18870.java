package Sorting;
/**
 * 문제: 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
 *      Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.
 *      X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
 * 입력: 첫째 줄에 N이 주어진다.
 *      둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
 * 출력: 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
 * 해결: 정렬 + 구현
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //좌표의 개수
        int [] arr = new int[N]; //좌표를 담을 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int [] copy = arr.clone(); //좌표를 담은 배열 복사
        Arrays.sort(copy); //복사한 배열 오름차순 정렬
        int idx = 0; //좌표 압축 시작
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<N; i++) {
            if(!map.containsKey(copy[i])) { //map에 들어가 있지 않은 좌표 값만 계산
                map.put(copy[i], idx);
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int n : arr) sb.append(map.get(n)).append(" "); //좌표 압축 결과 StringBuilder에 담기
        System.out.println(sb); //결과 출력
    }
}