package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_10844 {
    public static int MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //자연수

        long[][] dp = new long[N + 1][10]; //N개의 자릿값을 위해 2차원배열 사용
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        //Botton Up 방식의 DP
        //모든 분기에서 모듈러 연산 실행
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % MOD;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % MOD;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) { //각 자릿값마다의 경우의 수를 모두 더함
            result = (result + dp[N][i]) % MOD;
        }

        System.out.println(result); //결과 출력
    }
}

