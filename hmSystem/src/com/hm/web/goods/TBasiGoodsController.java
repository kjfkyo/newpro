package com.hm.web.goods;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.entity.TBasiCode;
import com.hm.entity.TBasiGoods;
import com.hm.mapper.TBasiCodeMapper;
import com.hm.mapper.account.UserMapper;
import com.hm.mybatis.Page;
import com.hm.service.TBasiGoods.TBasiGoodsService;
import com.hm.util.Utils;

@Controller
@RequestMapping("/goods")
public class TBasiGoodsController {
	@Autowired
	private TBasiGoodsService tBasiGoodsService;
	@Autowired
	private TBasiCodeMapper tBasiCodeMapper;
	@Autowired
	private UserMapper userMapper;
	//查询所有的资产；类型
	
	String s="";
	@RequestMapping("selectTBasiCode")
	public String selectTBasiCodeAll(ServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer pageNo, Model model){
		String keyword = Utils.objToStr(request.getParameter("keyword"));
        Page<TBasiCode> codes = tBasiGoodsService.selectTBasiCodeAll(keyword, pageNo);
        model.addAttribute("codes", codes);
        model.addAttribute("count", tBasiGoodsService.selectCodeCount());
        model.addAttribute("countNull", tBasiGoodsService.selectCodeNullCount());
        model.addAttribute("keyword", keyword);
        Map<String, Object> searchParams = Utils.getParametersStartingWith(request, "keyword");
        model.addAttribute("searchParams", Utils.encodeParameterStringWithPrefix(searchParams, "keyword"));
        return "goods/goodsList";
	}
	//查询某个资产类型下的所有的资产
	@RequestMapping("selectGogdsAllByCodeType")
	public String selectGogdsAllByCodeType(ServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer pageNo, Model model,
			@RequestParam("type")String t){
		String keyword = Utils.objToStr(request.getParameter("keyword"));
		Page<TBasiGoods> goods = tBasiGoodsService.selectTBasiGoodsByType(keyword, pageNo, t);
		model.addAttribute("type", t);
		model.addAttribute("flag", t);
		model.addAttribute("goods", goods);
		model.addAttribute("keyword", keyword);
		Map<String, Object> searchParams = Utils.getParametersStartingWith(request, "keyword");
		model.addAttribute("searchParams", Utils.encodeParameterStringWithPrefix(searchParams, "keyword"));
		return "goods/goodsAllsList";
	}
	
	@ResponseBody
	@RequestMapping("insertGoods")
	public String insertGoods(TBasiCode code){
		boolean flag=tBasiGoodsService.insertTBasiCode(code);
		if(flag){
		    return Utils.toJson("yes");
		}
		return Utils.toJson("nos");
	}
	//添加一个物资
	@ResponseBody
	@RequestMapping("insertCodeGoods")
	public String insertCodeGoods(TBasiGoods goods){
		System.out.println(goods);
		boolean flag=tBasiGoodsService.insertTBasiGoods(goods);
		if(flag){
		    return Utils.toJson("yes");
		}
		return Utils.toJson("nono");
	}
	@RequestMapping("editGoods")
    @ResponseBody
	public String editGoods(@RequestParam("id")String id){
		TBasiGoods goods=tBasiGoodsService.selectTBasiGoodsById(id);
    	return Utils.toJson(goods);
	}
	
	@RequestMapping("deleteGoodss")
    @ResponseBody
	public String deleteGoodss(@RequestParam("id")String id){
		boolean flag=tBasiGoodsService.deleteGoodss(id);
		if(flag){
			return Utils.toJson("ok");
		}
		return Utils.toJson("nonox");
	}
	@RequestMapping("selectGoodsCodeUser")
    @ResponseBody
	public String selectGoodsCodeUser(@RequestParam("id")String id){
		TBasiGoods goods=tBasiGoodsService.selectTBasiGoodsById(id);
		List<String> list=tBasiCodeMapper.selectCodeByDep();
		Object[] o={goods,list};
    	return Utils.toJson(o);
	}
	//根据下拉列表选择的部门，根据部门名称查询某个部门的所有人员名称
	@RequestMapping("selectUserByDep")
    @ResponseBody
	public String selectUserByDep(@RequestParam("depa")String depa){
		List<String> list=userMapper.selectUserByDep(depa);
    	return Utils.toJson(list);
	}
	//修改物资名称
	@RequestMapping("updateGoods")
    @ResponseBody
	public String updateGoods(TBasiGoods goods){
		boolean flag=tBasiGoodsService.updateGoodsCodeName(goods);
		if(flag){
			return Utils.toJson("ok");
		}
		return Utils.toJson("nonox");
	}
	//修改物资使用状态和使用人
	@RequestMapping("updateCodeGoods")
    @ResponseBody
	public String updateCodeGoods(TBasiGoods goods,@RequestParam("deppa")String deppa,@RequestParam("usersq")String usersq){
//		String gname="";
//		try {
//			gname=new String((goods.getName()).getBytes(),"utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		goods.setName(gname);
		if(goods.getState().equals("0")){
			if(!deppa.equals("0")&&!usersq.equals("0")){
				goods.setState("使用");
				goods.setMark("当前物资被"+deppa+","+usersq+"使用");
			}else{
				goods.setState("空闲");
				goods.setMark("当前物资未被使用");
			}
		}else{
			goods.setMark("当前物资未被使用");
		}
		boolean flag=tBasiGoodsService.updateGoodsCodeState(goods);
		if(flag){
			return Utils.toJson("ok");
		}
		return Utils.toJson("nonox");
	}
	@RequestMapping("editCode")
    @ResponseBody
    public String editUser(@RequestParam("id")String id){
		TBasiCode code=tBasiGoodsService.selectTBasiCodeById(id);
		int sum=tBasiGoodsService.selectCodeGoodsNum(code.getName());
		int nullsx=tBasiGoodsService.selectCodeGoodsIsNull(code.getName());
		int xxx=tBasiGoodsService.selectCodeGoodsIsXXX(code.getName());
		int use=tBasiGoodsService.selectTBasiGoodsIsUse(code.getName());
		int donk=tBasiGoodsService.selectTBasiGoodsIsDonk(code.getName());
		Object[] o={code,sum,nullsx,xxx,use,donk};
    	return Utils.toJson(o);
    }
	
	@RequestMapping("updateCodes")
    @ResponseBody
	public String updateCode(@RequestParam("id")String id,@RequestParam("name")String name){
		TBasiCode code=tBasiGoodsService.selectTBasiCodeById(id);
		String type=code.getName();
		code.setName(name);
		int count=tBasiGoodsService.updateOneTBasiCode(code,type);
		if(count>0){
		    return Utils.toJson("yes");
		}
		return Utils.toJson("no");
	}
	
	@RequestMapping("deleteCode")
	@ResponseBody
	public String deleteCodeById(@RequestParam("id")String id){
		int count=tBasiGoodsService.deleteCodeById(id);
		if(count>0){
		    return Utils.toJson("yes");
		}
		return Utils.toJson("no");
	}
	@RequestMapping("editObjectCode")
    @ResponseBody
	public String editObjectCode(@RequestParam("id")String id){
		TBasiCode code=tBasiGoodsService.selectTBasiCodeById(id);
		return Utils.toJson(code);
	}
	
	//查询该物资对象
	@RequestMapping("editObjectGoods")
    @ResponseBody
	public String editObjectGoods(@RequestParam("id")String id){
		TBasiGoods goods=tBasiGoodsService.selectTBasiGoodsById(id);
		return Utils.toJson(goods);
	}
}
