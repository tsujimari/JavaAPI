package Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise2 {

	public static void main(String[] args) {
		// CSV�t�@�C���p�X
		String path = "C:\\exercise\\book.csv";
		
		// try-with-resources
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			// 1�s���ǂݍ���
			String line = br.readLine();
			// �s�����݂���i=null�łȂ��j�ꍇ�͏o�͂Ɠǂݍ��݂����{
			while (line != null) {
				// �J���}�ŋ�؂�
				String[] books = line.split(",");
				
				// �{���𐮌`���ďo�͂��鏈��
				for (int i = 0; i < books.length; i++) {
					String str = "�y�ԍ��z";
					if (i == 1) {
						str = "�y�{�̖��O�z";
					} else if (i == 2) {
						str = "�y�l�i�z";
					}
					System.out.print(str + books[i]);
				}
				// ���s
				System.out.println();
				
				// ����1�s��ǂݍ���
				line = br.readLine();
			}

		} catch (IOException e) {
			// ��O�������͂��̏��������{
			e.printStackTrace();
			System.out.println("�\�����ʃG���[���������܂���");
		}
	}
}
