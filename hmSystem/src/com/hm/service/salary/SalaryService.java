package com.hm.service.salary;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.entity.clzss.TBasiClzss;
import com.hm.entity.salary.TStuSalary;
import com.hm.entity.student.TEndStudent;
import com.hm.mapper.salary.TStuSalaryMapper;
import com.hm.mybatis.Page;

@Service
@Transactional(readOnly = true)
public class SalaryService {
	@Autowired
	private TStuSalaryMapper tStuSalaryMapper;
	
	/**
	 * 查询项目组
	 * @return
	 */
	public List<TBasiClzss> selectClass() {
		return tStuSalaryMapper.selectClass();
	}
	/**
	 * 根据项目组ID查询学生
	 * @param clzId
	 * @param pageNo
	 * @return
	 */
	public Page<TEndStudent> selectStu(String clzId, Integer pageNo) {
		Page<TEndStudent> page = new Page<>();
		page.setPageNo(pageNo);
		tStuSalaryMapper.selectStu(clzId, page);
		return page;
	}
	/**
	 * 根据学生ID查询工资表信息
	 * @param id
	 * @param flag
	 * @return
	 */
	public TStuSalary findByStuId(String id, String flag) {
		return tStuSalaryMapper.findByStuId(id, flag);
	}
	/**
	 * 更新工资表信息
	 * @param sal
	 * @return
	 */
	public int updateSalary(TStuSalary sal) {
		return tStuSalaryMapper.updateSalary(sal);
	}
	/**
	 * 向工资表中插入数据
	 * @param sal
	 * @return
	 */
	public int insertSalary(TStuSalary sal) {
		return tStuSalaryMapper.insertSalary(sal);
	}
	/**
	 * 更新发放状态
	 * @param sal
	 * @return
	 */
	public int updateByPrimaryKeySelective(TStuSalary sal) {
		return tStuSalaryMapper.updateByPrimaryKeySelective(sal);
	}
	/**
	 * 根据年月或者发放状态从工资表查询信息
	 * @param month
	 * @param state
	 * @param pageNo
	 * @return
	 */
	public Page<TStuSalary> selectSal(String month, String state, Integer pageNo) {
		Page<TStuSalary> page = new Page<>();
		page.setPageNo(pageNo);
		tStuSalaryMapper.selectSal(month, state, page);
		return page;
	}
	public List<Map<String, String>> getBankNm() {
		return tStuSalaryMapper.getBankNm();
	}
}
