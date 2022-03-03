package com.project.sports.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.sports.domain.DealAuction;
import com.project.sports.domain.DealDirect;
import com.project.sports.domain.DealPoint;
import com.project.sports.domain.DealQuestion;

@Repository
public class MyDealDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int BUY_BIDDINGcount(String sessionid) {
		return sqlSession.selectOne("MyDeal.buy_bidding",sessionid);
	}

	public int BUY_BIDCOMcount(String sessionid) {
		return sqlSession.selectOne("MyDeal.buy_bidcom",sessionid);
	}

	public int BUY_BIDFAILcount(String sessionid) {
		return sqlSession.selectOne("MyDeal.buy_bidfail",sessionid);
	}

	public int BUY_DELIVERYcount(String sessionid) {
		return sqlSession.selectOne("MyDeal.buy_delivery",sessionid);
	}

	public int SELL_BIDDINGcount(String sessionid) {
		return sqlSession.selectOne("MyDeal.sell_bidding",sessionid);
	}

	public int SELL_BIDCOMcount(String sessionid) {
		return sqlSession.selectOne("MyDeal.sell_bidcom",sessionid);
	}

	public int SELL_DELIVERYcount(String sessionid) {
		return sqlSession.selectOne("MyDeal.sell_delivery",sessionid);
	}

	public List<DealAuction> getAuctionCartList(HashMap<String, Object> map) {
		return sqlSession.selectList("MyDeal.auccart", map);
	}

	public int Cart_Delete(HashMap<String, Object> map) {
		return sqlSession.delete("MyDeal.cartdel" , map);
	}

	public List<DealDirect> getDirectCartList(HashMap<String, Object> map) {
		return sqlSession.selectList("MyDeal.dircart", map);
	}

	public int Cart_Delete2(HashMap<String, Object> map) {
		return sqlSession.delete("MyDeal.cartdel2" , map);
	}

	public int getListCount(HashMap<String, Object> map) {
		return sqlSession.selectOne("MyDeal.count", map);
	}

	public List<DealAuction> MybuyList(HashMap<String, Object> map) {
		return sqlSession.selectList("MyDeal.buylist", map);
	}

	public int getListCount2(HashMap<String, Object> map) {
		return sqlSession.selectOne("MyDeal.count2", map);
	}

	public List<DealAuction> MysellList(HashMap<String, Object> map) {
		return sqlSession.selectList("MyDeal.selllist", map);
	}

	public void postinput1(HashMap<String, Object> map) {
		sqlSession.update("MyDeal.postinput1", map);
	}

	public void postinput2(int num) {
		sqlSession.update("MyDeal.postinput2", num);
		
	}
	public void postinput3(int num) {
		sqlSession.update("MyDeal.postinput3", num);
		 
	}

	public void receipt1(int num) {
		sqlSession.delete("MyDeal.receipt1", num);
		
	}
	public void receipt2(int num) {
		sqlSession.delete("MyDeal.receipt2", num);
		
	}

	public int BUY_QUESTIONcount(String sessionid) {
		return sqlSession.selectOne("MyDeal.bquestion", sessionid);
	}

	public int SELL_QUESTIONcount(String sessionid) {
		return sqlSession.selectOne("MyDeal.squestion", sessionid);
	}

	public List<DealQuestion> DealbuyQuestion(HashMap<String, Object> map) {
		return sqlSession.selectList("MyDeal.dealbuyquestion",map);
	}

	public List<DealQuestion> DealsellQuestion(HashMap<String, Object> map) {
		return sqlSession.selectList("MyDeal.dealsellquestion",map);
	}

	public Object Aanswer(HashMap<String, Object> map) {
		return sqlSession.update("MyDeal.aanswer",map);
	}

	public void Aquestiondel(int num) {
		sqlSession.delete("MyDeal.aquestiondel", num);
		
	}

	public List<DealQuestion> DealbuyQuestion2(HashMap<String, Object> map) {
		return sqlSession.selectList("MyDeal.dealbuyquestion2",map);
	}

	public List<DealQuestion> DealsellQuestion2(HashMap<String, Object> map) {
		return sqlSession.selectList("MyDeal.dealsellquestion2",map);
	}

	public void Danswer(HashMap<String, Object> map) {
		sqlSession.update("MyDeal.danswer",map);
		
	}

	public void Dquestiondel(int num) {
		sqlSession.delete("MyDeal.dquestiondel", num);
		
	}

	public int BUY_QUESTIONcount2(String sessionid) {
		return sqlSession.selectOne("MyDeal.bquestion2", sessionid);
	}

	public int SELL_QUESTIONcount2(String sessionid) {
		return sqlSession.selectOne("MyDeal.squestion2", sessionid);
	}

	public void pointdb(HashMap<String, Object> map) {
		sqlSession.insert("MyDeal.pointdb" , map);
	}

	public int nowpoint(HashMap<String, Object> map) {
		return sqlSession.selectOne("MyDeal.nowpoint", map);
		
	}

	public int pointrequest(HashMap<String, Object> map) {
		return sqlSession.update("MyDeal.pointrequest", map);
		
	}

	public List<DealPoint> pointreqlist() {
		return sqlSession.selectList("MyDeal.pointreqlist");
	}

	public void pointsuc(HashMap<String, Object> map) {
		sqlSession.update("MyDeal.pointsuc", map);
	}

	public void minuspoint(HashMap<String, Object> map) {
		sqlSession.update("MyDeal.minuspoint", map);
		
	}

	public void moneyreturn(HashMap<String, Object> map) {
		sqlSession.update("MyDeal.moneyreturn", map);
		
	}



}
