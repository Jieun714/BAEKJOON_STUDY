package step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//���� 8958�� OX Quiz
// https://st-lab.tistory.com/50 ���� StringBuilder ����
public class oxQuiz {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder(); 
		
		int N = Integer.parseInt(br.readLine()); // ����ȯ
		String[] arr = new String[N]; // N��ŭ �迭 ����
		
		for (int i = 0; i < N; i++) { // �迭�� ������ ����
			arr[i] = br.readLine();
		}

		// ���� ���
		for (int i = 0; i < arr.length; i++) {	
			//num�� sum�� for�� �ۿ� ���� �� ��� sum�� �����Ǵ� ������ �߻���
			int num = 0; // ����
			int sum = 0; // ����
			
			for (int j = 0; j < arr[i].length(); j++) {
				if (arr[i].charAt(j) == 'O') { //������ �ڸ��� ���ڸ� ��
					num++;	//���� ����
				} else {
					num = 0; //0���� �ʱ�ȭ
				}
				sum += num;
			}
			System.out.println(sum); //��� ���
			//sb.append(sum).append('\n'); //����
		}
		//System.out.println(sb); // StringBuilder�� ����Ͽ� ��� ���
	}
}
