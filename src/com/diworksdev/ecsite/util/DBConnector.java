package com.diworksdev.ecsite.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBConnectorクラスは、データベースへの接続を管理するためのユーティリティクラスです。
 */
public class DBConnector {

    // JDBCドライバのクラス名
    private static String driverName = "com.mysql.jdbc.Driver";

    // データベースへの接続URL
    private static String url = "jdbc:mysql://localhost:8889/ecsite";
//    jdbc:mysql://ホスト名:ポート番号/データベース名

    // データベース接続に使用するユーザー名
    private static String user = "root";

    // データベース接続に使用するパスワード
    private static String password = "root";
    public Connection getConnection() {
        Connection con = null;
        try {
            // JDBCドライバをロード
            Class.forName(driverName);

            // データベースへの接続を確立
            con = (Connection) DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            // JDBCドライバが見つからない場合の例外処理
            e.printStackTrace();
        } catch (SQLException e) {
            // データベース接続に関する例外処理
            e.printStackTrace();
        }

        // 取得したデータベースへの接続を返す
        return con;
    }
}
