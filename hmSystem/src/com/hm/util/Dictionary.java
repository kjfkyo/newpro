package com.hm.util;

/**
 * 字典表，用于翻译下拉条状态值
 * @author limiao
 */
public class Dictionary {
	/**
	 * 学员基础表字典
	 */
	public String getEdus(String edu){
		if("0".equals(edu)){
			edu = "无学历";
        }else if("1".equals(edu)){
        	edu = "初中";
        }else if("2".equals(edu)){
        	edu = "高中";
        }else if("3".equals(edu)){
        	edu = "中专";
        }else if("4".equals(edu)){
        	edu = "大专";
        }else if("5".equals(edu)){
        	edu = "本科";
        }else if("6".equals(edu)){
        	edu = "硕士";
        }
		return edu;
	}
	
	public String getSource(String source){
		if("1".equals(source)){
			source = "下载";
        }else if("2".equals(source)){
        	source = "咨询";
        }else if("3".equals(source)){
        	source = "投递";
        }else if("4".equals(source)){
        	source = "拓展";
        }else if("5".equals(source)){
        	source = "转介绍";
        }
		return source;
	}
	
	public String getChannel(String channel){
		if("0".equals(channel)){
			channel = "网资";
        }else if("1".equals(channel)){
        	channel = "代理";
        }else if("2".equals(channel)){
        	channel = "高校";
        }else if("3".equals(channel)){
        	channel = "地面";
        }
		return channel;
	}
	
	public String getBasState(String basState){
		if("0".equals(basState)){
			basState = "上门";
		}else if("1".equals(basState)){
			basState = "其他";
		}
		return basState;
	}
	
	/**
	 * 学员咨询表字典
	 */
	public String getSex(String sex){
		if("0".equals(sex)){
			sex = "男";
		}else{
			sex = "女";
		}
		return sex;
	}
	
	public String getMarital(String marital){
		if("0".equals(marital)){
			marital = "已婚";
		}else{
			marital = "未婚";
		}
		return marital;
	}
	
	public String getEduType(String eduType){
		if("0".equals(eduType)){
			eduType = "应届";
		}else{
			eduType = "往届";
		}
		return eduType;
	}
	
	public String getPayType(String payType){
		if("1".equals(payType)){
			payType = "全款";
		}else if("2".equals(payType)){
			payType = "分期";
		}else if("3".equals(payType)){
			payType = "现金分期";
		}
		return payType;
	}
	
	public String getAdvState(String advState){
		if("1".equals(advState)){
			advState = "一面流失";
		}else if("2".equals(advState)){
			advState = "二面流失";
		}else if("3".equals(advState)){
			advState = "宣讲";
		}else if("4".equals(advState)){
			advState = "试岗";
		}else if("5".equals(advState)){
			advState = "已签约";
		}
		return advState;
	}
	/**
	 * 学员最终表字典
	 */
	public String getEndState(String endState){
		if("0".equals(endState)){
			endState = "待就业";
		}else if("1".equals(endState)){
			endState = "已就业";
		}else if("2".equals(endState)){
			endState = "学习";
		}else if("3".equals(endState)){
			endState = "退学";
		}else if("4".equals(endState)){
			endState = "休学";
		}
		return endState;
	}
}
