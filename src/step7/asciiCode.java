package step7;

import java.io.*;

//���� 11654 ����, ���ڸ� �Է� �޾� �ƽ�Ű�ڵ带 ��ȯ
public class asciiCode {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int asc = (int)br.readLine().charAt(0);  //�Է°� ���ÿ� �ƽ�Ű�ڵ� ������ ��ȯ
		
		// https://st-lab.tistory.com/59 ����. BufferedReader �� ������� �ʰ� �ٷ� �Է� �޾Ƽ� �� ���
		//int asc = System.in.read();
		
		System.out.println(asc);
	}

}
