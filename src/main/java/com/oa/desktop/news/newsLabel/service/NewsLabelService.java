package com.oa.desktop.news.newsLabel.service;

import com.oa.commons.beans.NewsLabel;
import com.oa.commons.vo.Page;
import com.oa.desktop.news.newsLabel.dao.INewsLabelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2019/12/11 0011
 */
@Service
public class NewsLabelService implements INewsLabelService {
    @Autowired
    private INewsLabelDao newsLabelDao;
    @Override
    public Page<NewsLabel> findCurenPages(int pagenum,Integer serchid) {
        Page<NewsLabel> page=new Page();
        page.setPagenum(pagenum);
        int count=newsLabelDao.selectAllCount(serchid); 
        page.setTotalRow(count);
       // System.out.println(count);
        List<NewsLabel> dates=newsLabelDao.selectNewLabel(page,serchid);
        page.setDates(dates);
        return page;
    }


    @Override
    public void addNewsLabel(String textfield, String select, String textarea) {
        newsLabelDao.addNewsLabel(textfield,select,textarea);
    }

    @Override
    public void deleteNewsLabel(Integer deleteid) {
        newsLabelDao.deleteNewLabel(deleteid);
    }

    @Override
    public NewsLabel findNewsLabelById(Integer updateid) {
        NewsLabel newslabel=newsLabelDao.findNewsLabelById(updateid);
        System.out.println(newslabel);
        return newslabel;
    }

    @Override
    public void updateNewsLabel(Integer updatebyid, String textfield, String select2, String textarea) {
        newsLabelDao. updateNewsLabel(updatebyid, textfield,select2,  textarea);
    }


}
