package com.diworksdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.diworksdev.ecsite.dto.MyPageDTO;
import com.diworksdev.ecsite.util.DBConnector;

public class MyPageDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

//	データベースから購入履歴を取得するためのメソッド
	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id, String user_master_id) throws SQLException{
		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();

		String sql = "SELECT ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE ubit.item_transaction_id= ? AND ubit.user_master_id= ? ORDER BY insert_date DESC";
//		EFT JOIN は左側のテーブル (user_buy_item_transaction) に存在する行は全て表示され、右側のテーブル (item_info_transaction) に該当する行があれば結合されます。
//		WHERE 句で ubit.item_transaction_id と ubit.user_master_id が指定された値に一致する行を取得してORDER BY 句で insert_date を降順 (DESC) にソート
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, user_master_id);

			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				MyPageDTO dto = new MyPageDTO();
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setTotalPrice(resultSet.getString("total_price"));
				dto.setTotalCount(resultSet.getString("total_count"));
				dto.setPayment(resultSet.getString("pay"));
				dto.setInsert_date(resultSet.getString("insert_date"));
				myPageDTO.add(dto);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			connection.close();
		}
		return myPageDTO;
	}
//	データベースから購入履歴を削除するためのメソッド
	public int buyItemHistoryDelete(String item_transaction_id, String user_master_id) throws SQLException{
		String sql ="DELETE FROM user_buy_item_transaction WHERE item_transaction_id= ? AND user_master_id = ?";
				PreparedStatement preparedStatement;
				int result =0;
				try {
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, item_transaction_id);
					preparedStatement.setString(2, user_master_id);
					result = preparedStatement.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					connection.close();
				}
				return result;
	}
}