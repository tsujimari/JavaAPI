package Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise1 {
	public static void main(String[] args) {
		// CSV�t�@�C���p�X
		String path = "C:\\exercise\\book.csv";

		// try-with-resources
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			// 1�s���ǂݍ���
			String line = br.readLine();
			// �s�����݂���i=null�łȂ��j�ꍇ�͏o�͂Ɠǂݍ��݂����{
			while (line != null) {
				// �o��
				System.out.println(line);
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
