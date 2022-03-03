package com.project.sports.domain;

public class MyDeal {
	private String USER_ID;		//아이디
	private int	AUC_NUMBER;		//글번호
	private int BUY_BIDDING;		//입찰중(구매)
	private int BUY_BIDCOM;			//입찰완료(구매)
	private int BUY_BIDFAIL;		//입찰실패(구매)
	private int BUY_DELIVERY;		//배송중(구매)
	private int SELL_BIDDING;		//입찰중(판매)
	private int SELL_BIDCOM;		//입찰완료(판매)
	private int SELL_DELIVERY;		//배송입력(판매)
	private int PICK;				//장바구니
	private int DEAL_CSFC;			//거래분류
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public int getAUC_NUMBER() {
		return AUC_NUMBER;
	}
	public void setAUC_NUMBER(int aUC_NUMBER) {
		AUC_NUMBER = aUC_NUMBER;
	}
	public int getBUY_BIDDING() {
		return BUY_BIDDING;
	}
	public void setBUY_BIDDING(int bUY_BIDDING) {
		BUY_BIDDING = bUY_BIDDING;
	}
	public int getBUY_BIDCOM() {
		return BUY_BIDCOM;
	}
	public void setBUY_BIDCOM(int bUY_BIDCOM) {
		BUY_BIDCOM = bUY_BIDCOM;
	}
	public int getBUY_BIDFAIL() {
		return BUY_BIDFAIL;
	}
	public void setBUY_BIDFAIL(int bUY_BIDFAIL) {
		BUY_BIDFAIL = bUY_BIDFAIL;
	}
	public int getBUY_DELIVERY() {
		return BUY_DELIVERY;
	}
	public void setBUY_DELIVERY(int bUY_DELIVERY) {
		BUY_DELIVERY = bUY_DELIVERY;
	}
	public int getSELL_BIDDING() {
		return SELL_BIDDING;
	}
	public void setSELL_BIDDING(int sELL_BIDDING) {
		SELL_BIDDING = sELL_BIDDING;
	}
	public int getSELL_BIDCOM() {
		return SELL_BIDCOM;
	}
	public void setSELL_BIDCOM(int sELL_BIDCOM) {
		SELL_BIDCOM = sELL_BIDCOM;
	}
	public int getSELL_DELIVERY() {
		return SELL_DELIVERY;
	}
	public void setSELL_DELIVERY(int sELL_DELIVERY) {
		SELL_DELIVERY = sELL_DELIVERY;
	}
	public int getPICK() {
		return PICK;
	}
	public void setPICK(int pICK) {
		PICK = pICK;
	}
	public int getDEAL_CSFC() {
		return DEAL_CSFC;
	}
	public void setDEAL_CSFC(int dEAL_CSFC) {
		DEAL_CSFC = dEAL_CSFC;
	}
	
	
} 
