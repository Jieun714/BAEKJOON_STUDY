package basic_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//���� 4375�� 1
public class baekjoon_4375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String val = br.readLine();
			int N = Integer.parseInt(val); // N�� 2�� 5�� ������ �������� �ʴ� ����

			int num = 0;
			for (int i = 0; i < N; i++) {
				num *= 10 + 1;
				num %= N;

				if (num == 0) {
					sb.append(i).append('\n');
					break;
				}
			}

			if (val==null) {
				break;
			}
		}
		System.out.print(sb);
	}
}
