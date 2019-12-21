package com.oa.desktop.news.newsLabel.service;

import com.oa.commons.beans.NewsLabel;
import com.oa.commons.vo.Page;

/**
 * company: www.abc.com
 * Author: Administrator
 * Create Data: 2019/12/11 0011
 */
public interface INewsLabelService {
    Page<NewsLabel> findCurenPages(int pagenum,Integer serchid);

    void addNewsLabel(String textfield,String select, String textarea);

    void deleteNewsLabel(Integer  deleteid);

    NewsLabel findNewsLabelById(Integer updateid);

    void updateNewsLabel(Integer updatebyid, String textfield, String select2, String textarea);


}
