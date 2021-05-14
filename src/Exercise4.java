package Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Exercise4 {

	public static void main(String[] args) {
		// CSV�t�@�C���p�X
		String path = "C:\\exercise\\book.csv";

		// try-with-resources
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Map<String, String> bookMap = new HashMap<>();

			// 1�s���ǂݍ���
			String line = br.readLine();
			// �s�����݂���i=null�łȂ��j�ꍇ�͏o�͂Ɠǂݍ��݂����{
			while (line != null) {

				// �J���}�ŋ�؂�
				String[] books = line.split(",");
				// �o��
				systemOutPreBookData(books);

				// Map�ɒl��ێ�
				for (int i = 0; i < books.length; i++) {
					bookMap.put(books[0], books[1]);
				}
				// ����1�s��ǂݍ���
				line = br.readLine();
			}

			// �W�����͂��󂯎��
			String inputStr = getSystemIn();

			// �w�����b�Z�[�W�\��
			systemOutBuyMessage(inputStr, bookMap);

		} catch (IOException e) {
			// ��O�������͂��̏��������{
			e.printStackTrace();
			System.out.println("�\�����ʃG���[���������܂���");
		}
	}

	/**
	 * �{���𐮌`���ďo�͂���
	 * 
	 * @param books String[] csv�t�@�C����1�s���J���}��؂�ɂ����z��
	 */
	static void systemOutPreBookData(String[] books) {

		// �o��
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
	}

	/**
	 * �W�����͂��擾����
	 * 
	 * @return String �W������
	 */
	@SuppressWarnings("resource")
	static String getSystemIn() {
		System.out.println("�w���������{�̔ԍ�����͂��Ă��������B");
		// �W�����͂��󂯎��
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.print("�{�̔ԍ� > ");
		return scanner.nextLine();
	}

	/**
	 * �w�����b�Z�[�W���o�͂���
	 * 
	 * @param inputStr String �W������
	 * @param bookMap �{�̏��Map
	 */
	static void systemOutBuyMessage(String inputStr, Map<String, String> bookMap) {
		if (inputStr.isEmpty()) {
			System.out.println("�{�̔ԍ������͂���Ă��܂���B�Ď��s���Ă��������B");
			return;
		}
		if (bookMap.containsKey(inputStr)) {
			String bookName = bookMap.get(inputStr);
			System.out.println(bookName + "���w�����܂����B");
		} else {
			System.out.println("���͂��ꂽ�ԍ������݂��܂���B�Ď��s���Ă��������B");
		}
	}
}
