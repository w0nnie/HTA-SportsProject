package com.project.sports.service;

import java.util.HashMap;
import java.util.List;

import com.project.sports.domain.DealAuction;
import com.project.sports.domain.DealDirect;



public interface DealService {
	
	// 글의 갯수 구하기
	public int getListCount();
	
	public int getListCount2();
	
	// 글 목록 보기
	public List<DealAuction> getAuctionList(int page, int limit , int view2);

	public void insert(DealAuction auction);

	public void D_insert(DealDirect direct);

	public List<DealDirect> getDirectList(int page, int limit , int view2);

	public DealDirect D_getDetail(int num);

	public int D_Delete(int num);

	public int D_Modify(DealDirect direct);

	public List<DealDirect> getSearchDirecList(int page, int limit, String search, int view2);

	public int D_readcount(int num);

	public List<DealAuction> getSearchAuctionList(int page, int limit, String search,int view2);

	public DealAuction A_getDetail(int num);

	public int Auction_pricemodi(DealAuction auction);

	public int A_readcount(int num);

	public void Auction_biding(String sessionid, int num);

	public int Auction_bidchange(int num);

	public Object bidcheck(String sessionid, int num);

	public void Auction_pick(String sessionid, int num);

	public Object pickcheck(String sessionid, int num);

	public void Myinsert(DealAuction auction);

	public List<DealDirect> getDirectList(HashMap<String, Object> map2);

	public List<DealDirect> getSearchDirecList(HashMap<String, Object> map2);

	public void Auction_timeout(int num);

	public void Auction_timeout2(int num);

	public void Auction_timeout3(int num);

	public List<DealDirect> getDirectListsort(HashMap<String, Object> map2);

	public Object pickcheck2(String sessionid, int num);

	public void Direct_pick(String sessionid, int num);

	public void Auction_buynow1(int num, String sessionid);

	public void Auction_buynow2(int num);

	public void Auction_imgchan(int num);

	public void questioninput(String sessionid, int num, String sub, String sellid, String content);

	public void questioninput2(String sessionid, int num, String sub, String sellid, String content);

	public void Auction_soldoutimg(int num);

	public int Dealunit(int num);

	public String beforebidid(int num);

	public int Deallprice(int num);


	



	

}
