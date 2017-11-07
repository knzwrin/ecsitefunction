package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemComplateDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;

	private BuyItemComplateDAO buyItemComplateDAO = new BuyItemComplateDAO();

	/**
	 * 商品購入情報登録メソッド
	 *
	 * @author internous
	 */
	public String execute() throws SQLException {

		buyItemComplateDAO.buyItemeInfo(
				session.get("id").toString(),//ここにはオブジェクト型（なんでもありの型）がくるからtoString()メソッドで型変換している
				session.get("login_user_id").toString(),//キャストすることDAO側でプログラムを動かすときに楽に作動する
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("pay").toString());

		String result = SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
//class sample {
//
//    public static void main(String args[]) {
//
//        Object obj = "キャスト";
//
//        String str = obj.toString(); Object型をString型にキャストしている
//
//        System.out.println( str );
//    }
//}