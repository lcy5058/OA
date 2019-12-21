package com.oa.desktop.news.newsLabel.handler;

import com.oa.commons.beans.NewsLabel;
import com.oa.commons.vo.Page;
import com.oa.desktop.news.newsLabel.service.INewsLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2019/12/6 0006
 */
/*被Controllor注解标注的类会被Spring容器扫描并注册到容器中*/
@Controller
@RequestMapping("/desktop/news")
public class NewsLabelHandler {

    /*处理添加数据请求，并返回一个字符串组成的页面*/
    @RequestMapping("/addNewsLabel.do")
    public String addNewsLabel(HttpServletRequest request) {

        newsLabelService.addNewsLabel(request.getParameter("textfield"),request.getParameter("select"),request.getParameter("textarea"));
        return "/html/news/addSucess.jsp";
    }
    /*处理删除数据请求，并返回一个字符串组成的页面*/
    @RequestMapping("deleteNewsLabelById.do")
    public String deleteNewsLabel(Integer deleteid, int pagenum){
        newsLabelService.deleteNewsLabel(deleteid);
        return "/desktop/news/queryNewsLabel.do";
    }
    /*处理根据条件查找数据请求，并返回一个字符串组成的页面*/
    @RequestMapping("/findNewsLabelById.do")
    public String findNewsLabelById(HttpSession session,Integer updateid){
        NewsLabel newsLabel= newsLabelService.findNewsLabelById(updateid);
        session.setAttribute("date",newsLabel);
        return "/html/news/updateNewsLabel.jsp";
    }
    /*处理更新数据请求，并返回一个字符串组成的页面*/
    @RequestMapping("updateNewsLabel.do")
    public String updateNewsLabel(Integer updatebyid,HttpServletRequest request ){
        newsLabelService.updateNewsLabel(updatebyid,request.getParameter("textfield"),request.getParameter("select2"),request.getParameter("textarea"));
        return "/html/news/addSucess.jsp";
    }

}
