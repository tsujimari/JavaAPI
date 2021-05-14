package Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Exercise4 {

	public static void main(String[] args) {
		// CSVファイルパス
		String path = "C:\\exercise\\book.csv";

		// try-with-resources
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Map<String, String> bookMap = new HashMap<>();

			// 1行ずつ読み込み
			String line = br.readLine();
			// 行が存在する（=nullでない）場合は出力と読み込みを実施
			while (line != null) {

				// カンマで区切る
				String[] books = line.split(",");
				// 出力
				systemOutPreBookData(books);

				// Mapに値を保持
				for (int i = 0; i < books.length; i++) {
					bookMap.put(books[0], books[1]);
				}
				// 次の1行を読み込み
				line = br.readLine();
			}

			// 標準入力を受け取る
			String inputStr = getSystemIn();

			// 購入メッセージ表示
			systemOutBuyMessage(inputStr, bookMap);

		} catch (IOException e) {
			// 例外発生時はこの処理を実施
			e.printStackTrace();
			System.out.println("予期せぬエラーが発生しました");
		}
	}

	/**
	 * 本情報を整形して出力する
	 * 
	 * @param books String[] csvファイルの1行をカンマ区切りにした配列
	 */
	static void systemOutPreBookData(String[] books) {

		// 出力
		for (int i = 0; i < books.length; i++) {
			String str = "【番号】";
			if (i == 1) {
				str = "【本の名前】";
			} else if (i == 2) {
				str = "【値段】";
			}
			System.out.print(str + books[i]);
		}
		// 改行
		System.out.println();
	}

	/**
	 * 標準入力を取得する
	 * 
	 * @return String 標準入力
	 */
	@SuppressWarnings("resource")
	static String getSystemIn() {
		System.out.println("購入したい本の番号を入力してください。");
		// 標準入力を受け取る
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.print("本の番号 > ");
		return scanner.nextLine();
	}

	/**
	 * 購入メッセージを出力する
	 * 
	 * @param inputStr String 標準入力
	 * @param bookMap 本の情報Map
	 */
	static void systemOutBuyMessage(String inputStr, Map<String, String> bookMap) {
		if (inputStr.isEmpty()) {
			System.out.println("本の番号が入力されていません。再実行してください。");
			return;
		}
		if (bookMap.containsKey(inputStr)) {
			String bookName = bookMap.get(inputStr);
			System.out.println(bookName + "を購入しました。");
		} else {
			System.out.println("入力された番号が存在しません。再実行してください。");
		}
	}
}
