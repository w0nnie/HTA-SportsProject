package com.project.sports.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sports.dao.MyDealDAO;
import com.project.sports.domain.DealAuction;
import com.project.sports.domain.DealDirect;
import com.project.sports.domain.DealPoint;
import com.project.sports.domain.DealQuestion;

@Service
public class MyDealServiceImpl implements MyDealService{
	
	@Autowired
	private MyDealDAO dao;

	@Override
	public int BUY_BIDDINGcount(String sessionid) {
		return dao.BUY_BIDDINGcount(sessionid);
	}

	@Override
	public int BUY_BIDCOMcount(String sessionid) {
		return dao.BUY_BIDCOMcount(sessionid);
	}

	@Override
	public int BUY_BIDFAILcount(String sessionid) {
		return dao.BUY_BIDFAILcount(sessionid);
	}

	@Override
	public int BUY_DELIVERYcount(String sessionid) {
		return dao.BUY_DELIVERYcount(sessionid);
	}

	@Override
	public int SELL_BIDDINGcount(String sessionid) {
		return dao.SELL_BIDDINGcount(sessionid);
	}

	@Override
	public int SELL_BIDCOMcount(String sessionid) {
		return dao.SELL_BIDCOMcount(sessionid);
	}

	@Override
	public int SELL_DELIVERYcount(String sessionid) {
		return dao.SELL_DELIVERYcount(sessionid);
	}

	@Override
	public List<DealAuction> AuctionCartList(String sessionid) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("sessionid" , sessionid);
		return dao.getAuctionCartList(map);
	}

	@Override
	public int Cart_Delete(int num, String sessionid) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("sessionid" , sessionid);
		map.put("num" , num);
		return dao.Cart_Delete(map);
	}

	@Override
	public List<DealDirect> DirectCartList(String sessionid) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("sessionid" , sessionid);
		return dao.getDirectCartList(map);
	}

	@Override
	public int Cart_Delete2(int num, String sessionid) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("sessionid" , sessionid);
		map.put("num" , num);
		return dao.Cart_Delete2(map);
	}

	@Override
	public int getListCount(int view , String sessionid) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("sessionid" , sessionid);
		map.put("view" , view);
		return dao.getListCount(map);
	}

	@Override
	public List<DealAuction> MybuyList(int view, int page, int limit , String sessionid) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		int startrow=(page-1)*limit +1; 
		int endrow = startrow+limit-1;
		map.put("start", startrow);
		map.put("end",endrow);
		map.put("view",view);
		map.put("sessionid" , sessionid);

		return dao.MybuyList(map);
	}

	@Override
	public int getListCount2(int view, String sessionid) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("sessionid" , sessionid);
		map.put("view2" , view);
		return dao.getListCount2(map);
	}

	@Override
	public List<DealAuction> MysellList(int view, int page, int limit, String sessionid) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		int startrow=(page-1)*limit +1; 
		int endrow = startrow+limit-1;
		map.put("start", startrow);
		map.put("end",endrow);
		map.put("view2",view);
		map.put("sessionid" , sessionid);

		return dao.MysellList(map);
	}

	@Override
	public void postinput1(int num, String sel, String post1) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("num", num);
		map.put("sel",sel);
		map.put("post1",post1);
		
		dao.postinput1(map);
	}

	@Override
	public void postinput2(int num) {
		dao.postinput2(num);
		
	}

	@Override
	public void postinput3(int num) {
		dao.postinput3(num);
		
	}

	@Override
	public void receipt1(int num) {
		dao.receipt1(num);
		
	}

	@Override
	public void receipt2(int num) {
		dao.receipt2(num);
		
	}

	@Override
	public int BUY_QUESTIONcount(String sessionid) {
		return dao.BUY_QUESTIONcount(sessionid);
	}

	@Override
	public int SELL_QUESTIONcount(String sessionid) {
		return dao.SELL_QUESTIONcount(sessionid);
	}

	@Override
	public List<DealQuestion> DealbuyQuestion(String sessionid) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("sessionid" , sessionid);
		return dao.DealbuyQuestion(map);
	}

	@Override
	public List<DealQuestion> DealsellQuestion(String sessionid) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("sessionid" , sessionid);
		return dao.DealsellQuestion(map);
	}

	@Override
	public void Aanwser(int num, String tex) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("num" , num);
		map.put("tex" , tex);
		dao.Aanswer(map);
		
	}

	@Override
	public void Aquestiondel(int num) {
		dao.Aquestiondel(num);
		
	}

	@Override
	public List<DealQuestion> DealbuyQuestion2(String sessionid) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("sessionid" , sessionid);
		return dao.DealbuyQuestion2(map);
	}

	@Override
	public List<DealQuestion> DealsellQuestion2(String sessionid) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("sessionid" , sessionid);
		return dao.DealsellQuestion2(map);
	}

	@Override
	public void Danwser(int num, String tex) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("num" , num);
		map.put("tex" , tex);
		dao.Danswer(map);
		
	}

	@Override
	public void Dquestiondel(int num) {
		dao.Dquestiondel(num);
		
	}

	@Override
	public int BUY_QUESTIONcount2(String sessionid) {
		return dao.BUY_QUESTIONcount2(sessionid);
	}

	@Override
	public int SELL_QUESTIONcount2(String sessionid) {
		return dao.SELL_QUESTIONcount2(sessionid);
	}

	@Override
	public void pointdb(String user_id) {
		
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("user_id" , user_id);
		dao.pointdb(map);
		
	}

	@Override
	public int nowpoint(String sessionid) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("sessionid" , sessionid);
		return dao.nowpoint(map);
	}

	@Override
	public int pointrequest(String sessionid, String name, int point) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("sessionid" , sessionid);
		map.put("name" , name);
		map.put("point" , point);
		return dao.pointrequest(map);
		
	}

	@Override
	public List<DealPoint> pointreqlist() {
		// TODO Auto-generated method stub
		return dao.pointreqlist();
	}

	@Override
	public void pointsuc(String id, int point) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("id" , id);
		map.put("point" , point);
		dao.pointsuc(map);
		
	}

	@Override
	public void minuspoint(int minuspoint, String sessionid) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("sessionid" , sessionid);
		map.put("minuspoint" , minuspoint);
		dao.minuspoint(map);
		
	}

	@Override
	public void moneyreturn(String beforebidid, int dealunit2) {
		HashMap<String , Object>map = new HashMap<String,Object>();
		map.put("beforebidid" , beforebidid);
		map.put("dealunit2" , dealunit2);
		dao.moneyreturn(map);
		
	}

}
