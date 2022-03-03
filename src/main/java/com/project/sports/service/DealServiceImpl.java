package com.project.sports.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sports.dao.DealAuctionDAO;
import com.project.sports.dao.DealDirectDAO;
import com.project.sports.domain.DealAuction;
import com.project.sports.domain.DealDirect;

@Service
public class DealServiceImpl implements DealService {

		@Autowired
		private DealAuctionDAO dao;
		
		@Autowired
		private DealDirectDAO dao2;

		@Override
		public int getListCount() {
			return dao.getListCount();
		}
		
		@Override
		public int getListCount2() {
			return dao2.getListCount();
		} 

		@Override
		public List<DealAuction> getAuctionList(int page, int limit , int view2) {
			HashMap<String , Integer>map = new HashMap<String,Integer>();
			int startrow=(page-1)*limit +1; 
			int endrow = startrow+limit-1;
			map.put("start", startrow);
			map.put("end",endrow);
			map.put("view2" , view2);
			return dao.getAuctionList(map);
		}

		@Override
		public void insert(DealAuction auction) {
			dao.insertBoard(auction);
			
		}

		@Override
		public void D_insert(DealDirect direct) {
			dao2.insertBoard(direct);
			
		}

		@Override
		public List<DealDirect> getDirectList(int page, int limit,int view2) {
			HashMap<String , Object>map = new HashMap<String,Object>();
			int startrow=(page-1)*limit +1; 
			int endrow = startrow+limit-1;
			
			

			map.put("start", startrow);
			map.put("end",endrow);
			map.put("view2" , view2);
			return dao2.getDirectList(map);
		}

		@Override
		public DealDirect D_getDetail(int num) {
			return dao2.D_getDetail(num);
		}

		@Override
		public int D_Delete(int num) {
			int result = 0;
			return result = dao2.D_Delete(num);
		}

		@Override
		public int D_Modify(DealDirect direct) {
			return dao2.D_Modify(direct);
		}

		@Override
		public List<DealDirect> getSearchDirecList(int page, int limit, String search , int view2) {
			HashMap<String , Object>map = new HashMap<String,Object>();
			int startrow=(page-1)*limit +1; 
			int endrow = startrow+limit-1;

			map.put("start", startrow);
			map.put("end",endrow);
			map.put("search_word", "%" + search + "%");
			map.put("view2", view2);
			return dao2.getSearchDirectList(map);
		}

		@Override
		public int D_readcount(int num) {
			return dao2.D_readcount(num);
		}

		@Override
		public List<DealAuction> getSearchAuctionList(int page, int limit, String search , int view2) {
			HashMap<String , Object>map = new HashMap<String,Object>();
			int startrow=(page-1)*limit +1; 
			int endrow = startrow+limit-1;
			map.put("start", startrow);
			map.put("end",endrow);
			map.put("search_word", "%" + search + "%");
			map.put("view2",view2);

			return dao.getSearchAuctionList(map);
		}

		@Override
		public DealAuction A_getDetail(int num) {
			return dao.A_getDetail(num);
		}

		@Override
		public int Auction_pricemodi(DealAuction auction) {
			return dao.Auction_pricemodi(auction);
		}

		@Override
		public int A_readcount(int num) {
			return dao.A_readcount(num);
		}

		@Override
		public void Auction_biding(String sessionid, int num) {
			HashMap<String , Object> map = new HashMap<String,Object>();
			map.put("sessionid", sessionid);
			map.put("num", num);
			dao.Auction_biding(map);
			
		}

		@Override
		public int Auction_bidchange(int num) {
			return dao.Auction_bidchange(num);
		}

		@Override
		public Object bidcheck(String sessionid, int num) {
			HashMap<String , Object> map = new HashMap<String,Object>();
			map.put("sessionid", sessionid);
			map.put("num", num);

			return dao.bidcheck(map);
		}

		@Override
		public void Auction_pick(String sessionid, int num) {
			HashMap<String , Object> map = new HashMap<String,Object>();
			map.put("sessionid", sessionid);
			map.put("num", num);
			
			dao.Auction_pick(map);
			
		}

		@Override
		public Object pickcheck(String sessionid, int num) {
			HashMap<String , Object> map = new HashMap<String,Object>();
			map.put("sessionid", sessionid);
			map.put("num", num);

			return dao.pickcheck(map);
		}

		@Override
		public void Myinsert(DealAuction auction) {
			dao.Myinsert(auction);
			
		}

		@Override
		public List<DealDirect> getDirectList(HashMap<String, Object> map) {
			return dao2.getDirectList(map);
		}

		@Override
		public List<DealDirect> getSearchDirecList(HashMap<String, Object> map) {
			return dao2.getSearchDirectList(map);
		}

		@Override
		public void Auction_timeout(int num) {
			dao.timeout(num);
			
		}

		@Override
		public void Auction_timeout2(int num) {
			dao.timeout2(num);
			
		}

		@Override
		public void Auction_timeout3(int num) {
			dao.timeout3(num);
			
		}

		@Override
		public List<DealDirect> getDirectListsort(HashMap<String, Object> map2) {
			return dao2.getDirectListsort(map2);
		}

		@Override
		public Object pickcheck2(String sessionid, int num) {
			HashMap<String , Object> map = new HashMap<String,Object>();
			map.put("sessionid", sessionid);
			map.put("num", num);

			return dao2.pickcheck(map);
		}

		@Override
		public void Direct_pick(String sessionid, int num) {
			HashMap<String , Object> map = new HashMap<String,Object>();
			map.put("sessionid", sessionid);
			map.put("num", num);
			
			dao2.Direct_pick(map);
			
		}

		@Override
		public void Auction_buynow1(int num, String sessionid) {
			HashMap<String , Object> map = new HashMap<String,Object>();
			map.put("sessionid", sessionid);
			map.put("num", num);
			dao.Auction_buynow1(map);
			
		}

		@Override
		public void Auction_buynow2(int num) {
			dao.Auction_buynow2(num);
			
		}

		@Override
		public void Auction_imgchan(int num) {
			dao.Auction_imgchan(num);
			
		}

		@Override
		public void questioninput(String sessionid, int num, String sub, String sellid, String content) {
			HashMap<String , Object> map = new HashMap<String,Object>();
			map.put("sessionid", sessionid);
			map.put("num", num);
			map.put("sub", sub);
			map.put("sellid", sellid);
			map.put("content", content);
			
			dao.questioninput(map);
			
		}

		@Override
		public void questioninput2(String sessionid, int num, String sub, String sellid, String content) {
			HashMap<String , Object> map = new HashMap<String,Object>();
			map.put("sessionid", sessionid);
			map.put("num", num);
			map.put("sub", sub);
			map.put("sellid", sellid);
			map.put("content", content);
			
			dao2.questioninput2(map);
			
		}

		@Override
		public void Auction_soldoutimg(int num) {
			dao.soldoutimg(num);
			
		}

		@Override
		public int Dealunit(int num) {
			return dao.Dealunit(num);
		}

		@Override
		public String beforebidid(int num) {
			return dao.beforebidid(num);
		}

		@Override
		public int Deallprice(int num) {
			return dao.Deallprice(num);
		}








}
