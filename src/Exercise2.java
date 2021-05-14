package Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise2 {

	public static void main(String[] args) {
		// CSVファイルパス
		String path = "C:\\exercise\\book.csv";
		
		// try-with-resources
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			// 1行ずつ読み込み
			String line = br.readLine();
			// 行が存在する（=nullでない）場合は出力と読み込みを実施
			while (line != null) {
				// カンマで区切る
				String[] books = line.split(",");
				
				// 本情報を整形して出力する処理
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
				
				// 次の1行を読み込み
				line = br.readLine();
			}

		} catch (IOException e) {
			// 例外発生時はこの処理を実施
			e.printStackTrace();
			System.out.println("予期せぬエラーが発生しました");
		}
	}
}
