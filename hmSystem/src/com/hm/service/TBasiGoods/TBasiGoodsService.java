package com.hm.service.TBasiGoods;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.entity.TBasiCode;
import com.hm.entity.TBasiGoods;
import com.hm.mapper.TBasiGoodsMapper;
import com.hm.mybatis.Page;
import com.hm.util.Utils;
@Service
public class TBasiGoodsService {
	
	@Autowired
	private TBasiGoodsMapper tBasiGoodsMapper;
	
	//分页查询所有的资产类型（分页）
	public Page<TBasiCode> selectTBasiCodeAll(String keyword, Integer pageNo){
		Page<TBasiCode> page = new Page<>();
        page.setPageNo(pageNo);
        tBasiGoodsMapper.selectTBasiCodeAll(keyword, page);
        return page;
	}
	//查询某个物资类型下所有的物资
	public Page<TBasiGoods> selectTBasiGoodsByType(String keyword, Integer pageNo,String type){
		Page<TBasiGoods> page = new Page<>();
        page.setPageNo(pageNo);
        tBasiGoodsMapper.selectTBasiGoodsByType(keyword, type, page);
        return page;
	}
	
	//添加一个资产类型
	public boolean insertTBasiCode(TBasiCode code){
		int count=tBasiGoodsMapper.selectTBasiCodeByNameIsNull(code.getName());
		if(count==0){
			code.setDelflag("0");
			code.setKind("god");
			code.setCreateTime(new Date());
			code.setUpdateTime(new Date());
			code.setCreateUser(Utils.getLoginName());
			code.setUpdateUser(Utils.getLoginName());
			tBasiGoodsMapper.insertTBasiCode(code);
			return true;
		}
		return false;
	}
	//添加一个物资
	public boolean insertTBasiGoods(TBasiGoods goods){
		int count=tBasiGoodsMapper.selectTBasiGoodsByNameIsNull(goods.getName());
		if(count==0){
			goods.setState("空闲");
			goods.setCreateTime(new Date());
			goods.setUpdateTime(new Date());
			goods.setCreateUser(Utils.getLoginName());
			goods.setUpdateUser(Utils.getLoginName());
			tBasiGoodsMapper.insertTBasiGoods(goods);
			return true;
		}
		return false;
	}
	//删除一个物资
	public boolean deleteGoodss(String id){
		int count=tBasiGoodsMapper.deleteTBasiGoods(id);
		if(count>0){
			return true;
		}
		return false;
	}
	//删除一个资产类型
	public int deleteCodeById(String id){
		TBasiCode code=this.selectTBasiCodeById(id);
		tBasiGoodsMapper.deleteTBasiCodeAndGoods(code.getName());
		return tBasiGoodsMapper.deleteTBasiCode(id);
	}
	//修改物资名称
	public boolean updateGoodsCodeName(TBasiGoods goods){
		int count=tBasiGoodsMapper.selectTBasiGoodsByNameIsNull(goods.getName());
		if(count==0){
			goods.setUpdateTime(new Date());
			goods.setUpdateUser(Utils.getLoginName());
			tBasiGoodsMapper.updateTBasiGoods(goods);
			return true;
		}
		return false;
	}
	//修改物资状态
	public boolean updateGoodsCodeState(TBasiGoods goods){
		goods.setUpdateTime(new Date());
		goods.setUpdateUser(Utils.getLoginName());
		int count=tBasiGoodsMapper.updateGoodsCodeState(goods);
		if(count>0){
			return true;
		}
		return false;
	}
	//修改物资类型名称
	public int updateOneTBasiCode(TBasiCode code,String type){
		code.setUpdateTime(new Date());
		code.setUpdateUser(Utils.getLoginName());
		tBasiGoodsMapper.updateTBasiGoodsByTypeName(type, code.getName());
		return tBasiGoodsMapper.updateTBasiCode(code);
	}
	//查询一个物资类型对象
	public TBasiCode selectTBasiCodeById(String id){
		return tBasiGoodsMapper.selectTBasiCodeById(id);
	}
	//查询一个物资对象
	public TBasiGoods selectTBasiGoodsById(String id){
		return tBasiGoodsMapper.selectTBasiGoodsById(id);
	}
	//查询每个资产类型对应的资产数量，返回map集合
	public Map<String, Integer> selectCodeCount(){
		Map<String, Integer> map=new HashMap<String, Integer>();
		List<TBasiCode> list=tBasiGoodsMapper.selectTBasiCodeAlls();
		for(TBasiCode code:list){
			map.put(code.getName(), tBasiGoodsMapper.selectTBasiGoodsCount(code.getName()));
		}
		return map;
	}
	//查询每个资产类型对应的空闲的资产数量，返回map集合
	public Map<String, Integer> selectCodeNullCount(){
		Map<String, Integer> map=new HashMap<String, Integer>();
		List<TBasiCode> list=tBasiGoodsMapper.selectTBasiCodeAlls();
		for(TBasiCode code:list){
			map.put(code.getName(), tBasiGoodsMapper.selectTBasiGoodsIsNull(code.getName()));
		}
		return map;
	}
	//查询某物资类型下所有的物资总和
	public int selectCodeGoodsNum(String type){
		return tBasiGoodsMapper.selectTBasiGoodsCount(type);
	}
	
	public int selectCodeGoodsIsNull(String type){
		return tBasiGoodsMapper.selectTBasiGoodsIsNull(type);
	}
	
	public int selectCodeGoodsIsXXX(String type){
		return tBasiGoodsMapper.selectTBasiGoodsIsXXX(type);
	}
	public int selectTBasiGoodsIsDonk(String type){
		return tBasiGoodsMapper.selectTBasiGoodsIsDonk(type);
	}
	public int selectTBasiGoodsIsUse(String type){
		return tBasiGoodsMapper.selectTBasiGoodsIsUse(type);
	}
	
}
