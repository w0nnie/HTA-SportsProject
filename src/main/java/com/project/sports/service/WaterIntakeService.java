package com.project.sports.service;

import java.util.List;
import java.util.Map;

import com.project.sports.domain.WaterIntake;

public interface WaterIntakeService {

	public void Waterinsert(WaterIntake water); 

	public List<WaterIntake> getList(String yearMonth);

	public void wateradd(WaterIntake water);

	public float DoughnutList(String id);
	//당일 물 섭취량 데이터 개수 확인 (데이터 있는지 없는지)
	public int doughnutlistcount(String id);
	//도넛그래프 수정(당일 물 섭취량)
	public void waterUpdate(WaterIntake water);
	//그래프 삭제
	public int delWater(Map<String, Object> map);

}

