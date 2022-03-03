package com.project.sports.service;

import java.util.List;

import com.project.sports.domain.DealAuction;
import com.project.sports.domain.DealDirect;
import com.project.sports.domain.DealPoint;
import com.project.sports.domain.DealQuestion;

public interface MyDealService {

	int BUY_BIDDINGcount(String sessionid);

	int BUY_BIDCOMcount(String sessionid);

	int BUY_BIDFAILcount(String sessionid);

	int BUY_DELIVERYcount(String sessionid);

	int SELL_BIDDINGcount(String sessionid);

	int SELL_BIDCOMcount(String sessionid);

	int SELL_DELIVERYcount(String sessionid);

	List<DealAuction> AuctionCartList(String sessionid);

	int Cart_Delete(int num, String sessionid);

	List<DealDirect> DirectCartList(String sessionid);

	int Cart_Delete2(int num, String sessionid);

	int getListCount(int view , String sessionid);

	List<DealAuction> MybuyList(int view, int page, int limit ,String sessionid);

	int getListCount2(int view, String sessionid);

	List<DealAuction> MysellList(int view, int page, int limit, String sessionid);

	void postinput1(int num, String sel, String post1);

	void postinput2(int num);

	void postinput3(int num);

	void receipt1(int num);

	void receipt2(int num);

	int BUY_QUESTIONcount(String sessionid);

	int SELL_QUESTIONcount(String sessionid);

	List<DealQuestion> DealbuyQuestion(String sessionid);

	List<DealQuestion> DealsellQuestion(String sessionid);

	void Aanwser(int num, String tex);

	void Aquestiondel(int num);

	List<DealQuestion> DealbuyQuestion2(String sessionid);

	List<DealQuestion> DealsellQuestion2(String sessionid);

	void Danwser(int num, String tex);

	void Dquestiondel(int num);

	int BUY_QUESTIONcount2(String sessionid);

	int SELL_QUESTIONcount2(String sessionid);

	void pointdb(String user_id);

	int nowpoint(String sessionid);

	int pointrequest(String sessionid, String name, int point);

	List<DealPoint> pointreqlist();

	void pointsuc(String id, int point);

	void minuspoint(int minuspoint, String sessionid);

	void moneyreturn(String beforebidid, int dealunit2);

}
