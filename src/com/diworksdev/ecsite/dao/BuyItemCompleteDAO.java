package com.diworksdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.ecsite.util.DBConnector;
import com.diworksdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {

	public void buyItemeInfo(String item_transaction_id, String total_price, String total_count, String user_master_id, String pay) throws SQLException {
//		DBConnector クラスの新しいインスタンスを作成
		DBConnector dbConnector = new DBConnector();
//		dbConnector.getConnection() メソッドを呼び出して、データベースへの接続を確立します。
//		Connection クラスは、JavaのSQLパッケージに含まれるデータベース接続を表すクラスです。
		Connection connection = dbConnector.getConnection();
//		DateUtil クラスの新しいインスタンスを作成しています
		DateUtil dateUtil = new DateUtil();

//		INSERT INTOでデータを登録 user_buy_item_transactionの部分がテーブル名を指定
//		(item_transaction_id,total_price, total_count, user_master_id, pay, insert_date): 挿入するカラムのリストです。指定された順序でプレースホルダ（?）に対応しています。
//		VALUES(?, ?, ?, ?, ?, ?): 挿入する値を指定するセクションで、それぞれの ? はプレースホルダとなります。実際の挿入時にこれらのプレースホルダは具体的な値に置き換えられます。
		String sql = "INSERT INTO user_buy_item_transaction (item_transaction_id, total_count,user_master_id,total_price, pay, insert_date) VALUES(?, ?, ?, ?, ?, ?)";
		try {
//			connection.prepareStatement(sql): Connection オブジェクト (connection) から SQL 文 (sql) を使用して PreparedStatement オブジェクトを生成します。
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

//			SQL 文の中の1番目のプレースホルダ (?) に、item_transaction_id の値をセットしています。　
			preparedStatement.setString(1,item_transaction_id);
			preparedStatement.setString(2,total_price);
			preparedStatement.setString(3,total_count);
			preparedStatement.setString(4,user_master_id);
			preparedStatement.setString(5,pay);
//			SQL 文の中の6番目のプレースホルダ (?) に、dateUtil.getDate() の戻り値をセットしています。
//			dateUtil.getDate() は、日付を文字列として返すメソッド
			preparedStatement.setString(6,dateUtil.getDate());
//			最後に、preparedStatement にセットされた値を含む SQL 文をデータベースに対して実行します。
//			execute() メソッドは、データベースへの挿入や更新などのSQL文を実行する際に使用されます。
			preparedStatement.execute();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			connection.close();
		}
	}
}
