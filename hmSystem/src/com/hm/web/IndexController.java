package com.hm.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.service.account.UserLoginLogService;
import com.hm.util.Utils;

/**
 * Created by limiao on 2017-06-30.
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private UserLoginLogService userLoginLogService;

    @RequestMapping("")
    public String index() {
        String sessionId = SecurityUtils.getSubject().getSession().getId().toString();
        userLoginLogService.insertLog(sessionId);
        return "index";
    }

    @ResponseBody
    @RequestMapping("setMenuIdInSession")
    public String setMenuId(@RequestParam("menuId") String menuId, @RequestParam("menuPid") String menuPid) {
        SecurityUtils.getSubject().getSession().setAttribute("MENUID", menuId.replace("active", "").replace(" ", ""));
        SecurityUtils.getSubject().getSession().setAttribute("MENUPID", menuPid.replace("active", "").replace("sidebar-nav-sub-title", "").replace(" ", ""));
        return null;
    }

    @ResponseBody
    @RequestMapping("getTime")
    public String getTime() {
        Calendar calendar = Calendar.getInstance();
        List<String> lists = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
        for (int i = 14; i >= 0; i--) {
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            lists.add(format.format(calendar.getTime()));
        }
        return Utils.toJson(lists);
    }

    @ResponseBody
    @RequestMapping("getLogData")
    public String getLogData() {
        return Utils.toJson(userLoginLogService.getLogData());
    }
}
