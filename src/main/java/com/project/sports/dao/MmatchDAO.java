package com.project.sports.dao;

import java.util.HashMap; 
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.sports.domain.MatchAppReq;
import com.project.sports.domain.MatchInfo;
import com.project.sports.domain.Mentee;
import com.project.sports.domain.Mentor;
import com.project.sports.domain.Sports;

@Repository
public class MmatchDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<String> getSportlist(int selType) {
		return sqlSession.selectList("Mmatches.sportList",selType);
	}
	public List<String> getSilist() {
		return sqlSession.selectList("Mmatches.siList");
	}
	public List<String> getDonglist(String selType) {
		return sqlSession.selectList("Mmatches.dongList",selType);
	}
	public int insertMentorWriting(Mentor mentor) {
		return sqlSession.insert("Mmatches.insertWMentor",mentor);
	}
	public List<Sports> getSportDeatilList(int selType){
		return sqlSession.selectList("Mmatches.sportDetailList",selType);
	}
	public int getMentorListCount() {
		return sqlSession.selectOne("Mmatches.MentorCount");
	}
	public List<Mentor> getMentorList(HashMap <String,Integer> map) {
		return sqlSession.selectList("Mmatches.Mentorlist",map);
	}
	public int getSearchMentorListCount(HashMap <String,Object> map) {
		return sqlSession.selectOne("Mmatches.MentorCount",map);
	}
	public List<Mentor> getSearchMentorList(HashMap <String,Object> map) {
		return sqlSession.selectList("Mmatches.Mentorlist",map);
	}
	public Mentor getMentorDetail(String code) {
		return sqlSession.selectOne("Mmatches.MentorDetail",code);
	}
	public int ApplyWMentor(HashMap<String,String> map) {
		return sqlSession.insert("Mmatches.insertApply",map);
	}	
	public int checkApply(HashMap<String,String> map) {
		return sqlSession.selectOne("Mmatches.checkApply",map);
	}	
	public int deleteWMentor(String code) {
		return sqlSession.delete("Mmatches.deleteWMetor",code);
	}
	public int getSport(String subject) {
		return sqlSession.selectOne("Mmatches.getSports",subject);
	}
	public int modifyMentorWriting(Mentor mentor) {
		return sqlSession.update("Mmatches.modifyWMentor",mentor);
	}
	public int changeApplyState(MatchInfo matchinfo) {
		return sqlSession.update("Mmatches.chgApplyState",matchinfo);
	}
	public int insertMenteeWriting(Mentee mentee) {
		return sqlSession.insert("Mmatches.insertWMentee",mentee);
	}
	public int getMenteeListCount() {
		return sqlSession.selectOne("Mmatches.MenteeCount");
	}
	public List<Mentee> getMenteeList(HashMap <String,Integer> map) {
		return sqlSession.selectList("Mmatches.Menteelist",map);
	}
	public int getSearchMenteeListCount(HashMap <String,Object> map) {
		return sqlSession.selectOne("Mmatches.MenteeCount",map);
	}
	public List<Mentee> getSearchMenteeList(HashMap <String,Object> map) {
		return sqlSession.selectList("Mmatches.Menteelist",map);
	}
	public Mentee getMenteeDetail(String code) {
		return sqlSession.selectOne("Mmatches.MenteeDetail",code);
	}
	public int ApplyWMentee(HashMap<String,String> map) {
		return sqlSession.insert("Mmatches.insertApply",map);
	}	
	public int deleteWMentee(String code) {
		return sqlSession.delete("Mmatches.deleteWMetee",code);
	}
	public int modifyMenteeWriting(Mentee mentee) {
		return sqlSession.update("Mmatches.modifyWMentee",mentee);
	}
	public List<Mentee> getMyMenteeList(HashMap <String,Object> map){
		return sqlSession.selectList("Mmatches.MyMenteelist",map);
	}
	public List<Mentor> getMyMentorList(HashMap <String,Object> map){
		return sqlSession.selectList("Mmatches.MyMentorlist",map);
	}
	public int getMyMentorListCount(String id) {
		return sqlSession.selectOne("Mmatches.MyMentorCount",id);
	}
	public int getMyMenteeListCount(String id) {
		return sqlSession.selectOne("Mmatches.MyMenteeCount",id);
	}
	public int getMyMentorAppListCount(String id) {
		return sqlSession.selectOne("Mmatches.MyMentorAppCount",id);
	}
	public int getMyMenteeAppListCount(String id) {
		return sqlSession.selectOne("Mmatches.MyMenteeAppCount",id);
	}
	public List<MatchAppReq> getMyMentorAppList(HashMap <String,Object> map){
		return sqlSession.selectList("Mmatches.MyMentorApplist",map);
	}
	public List<MatchAppReq> getMyMenteeAppList(HashMap <String,Object> map){
		return sqlSession.selectList("Mmatches.MyMenteeApplist",map);
	}
	public int cancelApply(HashMap <String,Object> map) {
		return sqlSession.delete("Mmatches.deleteMatchApp",map);
	}
	public int getMyMentorReqListCount(String id) {
		return sqlSession.selectOne("Mmatches.MyMentorReqCount",id);
	}
	public int getMyMenteeReqListCount(String id) {
		return sqlSession.selectOne("Mmatches.MyMenteeReqCount",id);
	}
	public List<MatchAppReq> getMyMentorReqList(HashMap <String,Object> map){
		return sqlSession.selectList("Mmatches.MyMentorReqlist",map);
	}
	public List<MatchAppReq> getMyMenteeReqList(HashMap <String,Object> map){
		return sqlSession.selectList("Mmatches.MyMenteeReqlist",map);
	}
}
