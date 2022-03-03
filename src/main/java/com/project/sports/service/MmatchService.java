package com.project.sports.service;

import java.util.List;

import com.project.sports.domain.MatchAppReq;
import com.project.sports.domain.MatchInfo;
import com.project.sports.domain.Mentee;
import com.project.sports.domain.Mentor;
import com.project.sports.domain.Sports;

public interface MmatchService {
	public List<String> getSportlist(int selType);
	public List<String> getSilist();
	public List<String> getDonglist(String selType);
	public int insertMentorWriting(Mentor mentor);
	public List<Sports> getSportDeatilList(int selType);
    public int getMentorListCount();
    public List<Mentor> getMentorList(int page, int limit);
    public int getSearchMentorListCount(String search_field,String search_word);
    public List<Mentor> getSearchMentorList(int page, int limit,String search_field,String search_word); 
    public Mentor getMentorDetail(String code);
    public int ApplyMentor(String id,String code);
    public int checkApply(String id,String code);
    public int deleteMentor(String code);
    public int getSport(String subject);
    public int modifyMentorWriting(Mentor mentor);
    public int changeApplyState(MatchInfo matchinfo);
	public int insertMenteeWriting(Mentee mentee);
    public int getMenteeListCount();
    public List<Mentee> getMenteeList(int page, int limit);
    public int getSearchMenteeListCount(String search_field,String search_word);
    public List<Mentee> getSearchMenteeList(int page, int limit,String search_field,String search_word); 
    public Mentee getMenteeDetail(String code);
    public int ApplyMentee(String id,String code);
    public int deleteMentee(String code);
    public int modifyMenteeWriting(Mentee mentee);
    public int getMyMentorListCount(String id);
    public int getMyMenteeListCount(String id);
    public List<Mentee> getMyMenteeList(int page, int limit,String id);
    public List<Mentor> getMyMentorList(int page, int limit,String id);
    public int getMyMentorAppListCount(String id); 
    public int getMyMenteeAppListCount(String id);
    public List<MatchAppReq> getMyMentorAppList(int page, int limit,String id);
    public List<MatchAppReq> getMyMenteeAppList(int page, int limit,String id);
    public int cancelApply(String code,String id);
    public int getMyMentorReqListCount(String id); 
    public int getMyMenteeReqListCount(String id);
    public List<MatchAppReq> getMyMentorReqList(int page, int limit,String id);
    public List<MatchAppReq> getMyMenteeReqList(int page, int limit,String id);
}
