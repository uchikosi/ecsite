package com.diworksdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {
//	 Map<String, Object> 型の変数です。この変数は、キーが文字列（String）で値がオブジェクト（Object）のマップ（連想配列）を表します
	public Map<String, Object> session;
	private int count;
	private String pay;

	public String execute() {

		String result = SUCCESS;
		// 購入個数をセッションに保存 値を文字列に書き換え
		session.put("count", count);
		 // 購入個数を取得
		int intCount = Integer.parseInt(session.get("count").toString());
		// 値段を取得
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
		// 購入総額を計算してセッションに保存
		session.put("tostal_price", intCount * intPrice);
		 // 支払い方法をセッションに保存
		String payment;
		if(pay.equals("1")) {
			payment ="現金払い";
			session.put("pay", payment);
		} else {
			payment ="クレジットカード";
			session.put("pay", payment);
		}
		return result;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}