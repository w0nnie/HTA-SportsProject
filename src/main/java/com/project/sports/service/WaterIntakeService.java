package com.project.sports.service;

import java.util.List;
import java.util.Map;

import com.project.sports.domain.WaterIntake;

public interface WaterIntakeService {

	public void Waterinsert(WaterIntake water); 

	public List<WaterIntake> getList(String yearMonth);

	public void wateradd(WaterIntake water);

	public float DoughnutList(String id);
	//���� �� ���뷮 ������ ���� Ȯ�� (������ �ִ��� ������)
	public int doughnutlistcount(String id);
	//���ӱ׷��� ����(���� �� ���뷮)
	public void waterUpdate(WaterIntake water);
	//�׷��� ����
	public int delWater(Map<String, Object> map);

}

