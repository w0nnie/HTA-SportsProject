package com.project.sports.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.sports.domain.DealDirect;

@Repository
public class DealDirectDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

		public void insertBoard(DealDirect direct) {
		 sqlSession.insert("Direct.insert" , direct);
	}

		public int getListCount() {
			return sqlSession.selectOne("Direct.count");
		}

		public List<DealDirect> getDirectList(HashMap<String, Object> map) {
			return sqlSession.selectList("Direct.list", map);
		}

		public DealDirect D_getDetail(int num) {
			return sqlSession.selectOne("Direct.detail",num);
		}

		public int D_Delete(int num) {
			return sqlSession.delete("Direct.delete",num);
		}

		public int D_Modify(DealDirect direct) {
			return sqlSession.delete("Direct.modify",direct);
		}

		public List<DealDirect> getSearchDirectList(HashMap<String, Object> map) {
			return sqlSession.selectList("Direct.searchlist",map);
		}

		public int D_readcount(int num) {
			return sqlSession.update("Direct.readcount",num);
		}

		public List<DealDirect> getDirectListsort(HashMap<String, Object> map2) {
			return sqlSession.selectList("Direct.sortlist", map2);
		}

		public Object pickcheck(HashMap<String, Object> map) {
			return sqlSession.selectOne("Direct.pickcheck" , map);
		}

		public Object Direct_pick(HashMap<String, Object> map) {
			return sqlSession.insert("Direct.pick" , map);
			
		}

		public void questioninput2(HashMap<String, Object> map) {
			sqlSession.insert("Direct.quesinput" , map);
			
		}
}
