package com.diworksdev.ecsite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
//	BuyItemCompleteDAO クラスのインスタンス buyItemCompleteDAO を宣言しています。
	private BuyItemCompleteDAO buyItemCompleteDAO= new BuyItemCompleteDAO();

	public String execute() throws SQLException {
//		buyItemCompleteDAO インスタンスの buyItemeInfo メソッドを呼び出しています。
//		引数として、セッションから取得した購入商品に関する各種情報を渡しています。
//		toString() メソッドは、Javaの Object クラスに定義されているメソッドで、オブジェクトの文字列表現を返す役割を果たします。
		buyItemCompleteDAO.buyItemeInfo(
			session.get("id").toString(),
			session.get("count").toString(),
			session.get("login_user_id").toString(),
			session.get("buyItem_price").toString(),
			session.get("pay").toString());
//		処理が正常に終了した場合、result 変数に SUCCESS を代入しています。
//		Struts2 では、SUCCESS は処理が成功したことを示す標準的な結果文字列です。
		String result = SUCCESS;
//		アクションメソッドの最後に、処理結果を示す result を返しています。これにより、Struts2 フレームワークは適切な遷移先を決定します。
		return result;
	}

//	@Override アノテーション:このメソッドが親クラスまたはインタフェースのメソッドをオーバーライドしていることを示しています。
//	パラメータとして Map<String,Object> session があります。これは、セッション情報を保持するための Map オブジェクトです。
//		this.session = session;:セッション情報をアクションクラスのメンバ変数 session にセットしています。
//		this.session はアクションクラスのクラスメンバ変数であり、セッション情報が注入されると、アクションクラス内でセッション情報を利用できるようになります。
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
