package com.oa.desktop.news.newsLabel.dao;

import com.oa.commons.beans.NewsLabel;
import com.oa.commons.vo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface INewsLabelDao {
    /*查询总个数*/
    int selectAllCount( Integer serchid);
    /*通过对页数来查询当前页的数据*/
    List<NewsLabel> selectNewLabel(@Param("page") Page<NewsLabel> page,@Param("serchid") Integer serchid);
    /*增加新数据*/
    void addNewsLabel(@Param("textfield") String textfield,@Param("select") String select, @Param("textarea") String textarea);
    /*删除单条数据*/
    void deleteNewLabel(Integer deleteid);
    /*查询单个数据*/
    NewsLabel findNewsLabelById(Integer updateid);
    /*修改单个数据*/
    void updateNewsLabel(@Param("updatebyid")Integer updatebyid, @Param("textfield")String textfield, @Param("select2")String select2,@Param("textarea") String textarea);

}
