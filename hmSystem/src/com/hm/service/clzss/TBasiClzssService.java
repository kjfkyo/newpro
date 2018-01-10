package com.hm.service.clzss;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.entity.clzss.TBasiClzss;
import com.hm.mapper.clzss.TBasiClzssMapper;
import com.hm.mybatis.Page;


@Service
public class TBasiClzssService {
    @Autowired
    private TBasiClzssMapper tBasiClzssMapper;
    /**
     * 插入，空属性不会插入
     * 参数:TBasiClzss对象
     * 返回:添加个数
     * @ibatorgenerated 2017-09-09 18:53:05
     */
    public int addClazz(TBasiClzss Clzss){   	
    	return tBasiClzssMapper.addClazz(Clzss);
    }
    /**
     * 查询全部
     * 参数:null
     * 返回:集合对象
     * @ibatorgenerated 2017-09-11 16:28:05
     */
    public List<TBasiClzss> selectByPrimaryKeyAll(){
		return tBasiClzssMapper.selectByPrimaryKeyAll();
    	
    }
    /**
     * 查询全部分页项目组
     * 参数:Page<TBasiClzss>
     * 返回:List<TBasiClzss>
     * @listClzss 2017-09-11 16:28:05
     */
    public  Page<TBasiClzss> listClzss(Integer page,String name) {
    	Page<TBasiClzss> p=new Page<TBasiClzss>();
    	p.setPageNo(page);
    	List<TBasiClzss> list=tBasiClzssMapper.listClzss(p, name);
    	p.setResults(list);
    	return p;
	}
    
   
    /**
     * 根据id查询
     * 参数:id
     * 返回:TBasiClzss
     * @addClazz 2017-09-11 16:28:05
     */
    public  TBasiClzss ClzssId(String id){
    	return tBasiClzssMapper.ClzssId(id);
    }
    /**
     * 根据id修改
     * 参数:TBasiClzss
     * 返回:int
     * @addClazz 2017-09-11 16:28:05
     */
    public int  updateClzss(TBasiClzss clzss){
    	return tBasiClzssMapper.updateClzss(clzss);
    }
    /**
	 * 查询所有项目组名称
	 * @return
	 */
	public List<Map<String, String>> selectFreeRoom() {
		return tBasiClzssMapper.selectFreeRoom();
	}

}
