package Dynamic;

/**
 * 문제: LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
 *      예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.
 *
 * * * 점화식 코드 * * *
 * if i == 0 or j == 0:  # 마진 설정
 *      LCS[i][j] = 0
 * elif string_A[i] == string_B[j]:
 *      LCS[i][j] = LCS[i - 1][j - 1] + 1
 * else:
 *      LCS[i][j] = max(LCS[i - 1][j], LCS[i][j - 1])
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_9251 {
    static char[] str1;
    static char[] str2;
    static int [][] LCS;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        //LCS 배열 생성
        LCS = new int[str1.length+1][str2.length+1];

        //탐색
//        for(int i=0; i<str1.length; i++){
//            for(int j=0; j<str2.length; j++){
//                if(i == 0 || j == 0) { //마진 설정
//                    LCS[i][j] = 0;
//                } else if(str1[i] == str2[j]){
//                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
//                } else {
//                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
//                }
//            }
//        }

        for(int i=1; i<=str1.length; i++){
            for(int j=1; j<=str2.length; j++){
                if(str1[i-1] == str2[j-1]){
                    LCS[i][j] = LCS[i-1][j-1] +1;
                }else{
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
                }
            }
        }

        System.out.println(LCS[str1.length][str2.length]);

        //2차원 배열 확인
//        for(int [] row:LCS){
//            System.out.println(Arrays.toString(row));
//        }

    }
}
