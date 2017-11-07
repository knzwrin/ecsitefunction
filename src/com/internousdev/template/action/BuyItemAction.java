
package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {

	/**
	 * アイテム購入個数
	 */
	private int count;
	private int itemPrice;
	private String itemName;
	private int id;
	/**
	 * 支払い方法
	 */
	private String pay;
	/**
	 * アイテム情報を格納
	 */
	public Map<String, Object>  session;
	public ArrayList<BuyItemDTO> buyItemList = new ArrayList<BuyItemDTO>();
	public BuyItemDTO buyItemDTO = new BuyItemDTO();
	/**
	 * 商品情報取得メソッド
	 *
	 * @author internous
	 */
	public String execute() {
		String result = SUCCESS;
		session.put("count", count);
		session.put("id", id);
		int intCount = Integer.parseInt(session.get("count").toString());
//		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
//		int intPrice = Integer.parseInt(buyItemDTO.getItemPrice().toString());
//		int intPrice = Integer.parseInt(buyItemDTO.getItemPrice().toString());
		System.out.println(session.size());

		session.put("total_price", intCount * itemPrice);
		String payment;

		if(pay.equals("1")) {

			payment = "現金払い";
			session.put("pay", payment);
		} else {

			payment = "クレジットカード";
			session.put("pay", payment);
		}
		return result;
	}

	/**
	 * アイテム購入個数を取得します。
	 * @return アイテム購入個数
	 */
	public int getCount() {
		return count;
	}

	/**
	 * アイテム購入個数を設定します。
	 * @param count アイテム購入個数
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * 支払い方法を取得します。
	 * @return 支払い方法
	 */
	public String getPay() {
		return pay;
	}

	/**
	 * 支払い方法を設定します。
	 * @param pay 支払い方法
	 */
	public void setPay(String pay) {
		this.pay = pay;
	}

	/**
	 * @return buyItemList
	 */
	public ArrayList<BuyItemDTO> getBuyItemList() {
		return buyItemList;
	}

	/**
	 * @param buyItemList セットする buyItemList
	 */
	public void setBuyItemList(ArrayList<BuyItemDTO> buyItemList) {
		this.buyItemList = buyItemList;
	}

	/**
	 * @return buyItemDTO
	 */
	public BuyItemDTO getBuyItemDTO() {
		return buyItemDTO;
	}

	/**
	 * @param buyItemDTO セットする buyItemDTO
	 */
	public void setBuyItemDTO(BuyItemDTO buyItemDTO) {
		this.buyItemDTO = buyItemDTO;
	}

	/**
	 * アイテム情報を格納を設定します。
	 * @param session アイテム情報を格納
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return itemPrice
	 */
	public int getItemPrice() {
		return itemPrice;
	}

	/**
	 * @param itemPrice セットする itemPrice
	 */
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * @return itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName セットする itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}
}
