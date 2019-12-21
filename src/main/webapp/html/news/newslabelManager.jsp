<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/6 0006
  Time: 上午 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>栏目管理</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css">
    <script language="javascript" src="../../js/util.js"></script>
    <script>
        function shanchu()
        {
            var  str = confirm("是否确定删除上级栏目？");
            if(str == true)
            {
                alert("确定删除！");
            }
            else<a href="栏目添加.htm">栏目管理</a>
            {
                alert("取消删除！");
            }
        }
    </script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<center>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td height="25" align="center" valign="bottom" class="td06"><table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="2%" valign="middle" background="../../images/bg_03.gif">&nbsp;</td>
                    <td width="2%" valign="middle" background="../../images/bg_03.gif"><img src="../../images/main_28.gif" width="9" height="9" align="absmiddle"></td>
                    <td height="30" valign="middle" background="../../images/bg_03.gif"><div align="left"><font color="#FFFFFF">栏目管理</font></div></td>
                </tr>
            </table></td>
        </tr>
    </table>
    <form name="form1" method="post" action="">
        <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
            <tr>
                <td colspan="2" class="td_02"><SPAN class=td_title>根据栏目名称查询</SPAN></td>
            </tr>
            <tr>
                <td width="14%" class="td_02">栏目名称</td>
                <td width="86%" class="td_02">
                    <%--利用onchange来使选择框内容一发生改变就触发网页处理跳转--%>
                    <select name="select" onchange="window.location=this.value;" class="input" style="width:99% ">
                        <%--通过传入的参数serchid来按条件查询单类数据--%>
                        <option value="/desktop/news/queryNewsLabel.do?serchid=-1">请选择</option>
                        <option value="/desktop/news/queryNewsLabel.do?serchid=1">体育新闻</option>
                        <option value="/desktop/news/queryNewsLabel.do?serchid=2">娱乐新闻</option>
                        <option value="/desktop/news/queryNewsLabel.do?serchid=3">时政新闻</option>
                        <option value="/desktop/news/queryNewsLabel.do?serchid=-1">全部</option>
                        <%-- <c:forEach items="${page.dates}" var="date">
                           <option value="/desktop/news/serchNewsLabel.do?serchid=${date.parent.id}">${date.name}</option>
                      </c:forEach>--%>
                    </select>
                </td>
            </tr>
            <!--  <tr>
               <td class="td_02">二级栏目名称</td>
               <td class="td_02">
                 <select name="select" class="input" style="width:99% ">
                   <option value="1" selected>--请选择--</option>
                   <option value="2">天下足球</option>
                   <option value="3">我猜</option>
                 </select>
               </td>
             </tr> -->
        </table>
        <br>
        <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td class="td_page" align="left">
                    <div align="right">
                        <input name="Submit" type="submit" class="buttonface02" value="添加栏目" onClick="javascript:windowOpen('${pageContext.request.contextPath}/html/news/addNewsLabel.jsp','','',700,300,'','','')">
                    </div></td>
            </tr>
        </table>
        <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">

            <tr>
                <td colspan="5" align="right" class="td07"><img src="../../images/1.gif" width="4" height="5" align="absmiddle"> <a href="/desktop/news/queryNewsLabel.do?pagenum=1">首页</a>　 <img src="../../images/2.gif" width="3" height="5" align="absmiddle">
                   <%--先对当前页面数进行判断，如果符合条件则显示为超链接，否则显示为正常文本，既不能点击--%>
                    <c:if test="${page.pagenum>1}"><a href="/desktop/news/queryNewsLabel.do?pagenum=${page.pagenum-1}&serch=${serch}">上一页</a></c:if>  <c:if test="${page.pagenum==1}">上一页</c:if>   <img src="../../images/2-2.gif" width="3" height="5" align="absmiddle">
                    <c:if test="${page.pagenum<page.totalPages}"><a href="/desktop/news/queryNewsLabel.do?pagenum=${page.pagenum+1}&serch=${serch}">下一页</a></c:if>   <c:if test="${page.pagenum==page.totalPages}">下一页</c:if><img src="../../images/3.gif" width="4" height="5" align="absmiddle"> <a href="/desktop/news/queryNewsLabel.do?pagenum=${page.totalPages}">末页</a>　　
                    <%--利用el表达式直接表示当前数据--%>
                    共${page.totalPages} 页 ${page.totalRow} 条记录</td>
            </tr>
            <tr>
                <td width="17%" class="td_top">栏目名称</td>
                <td width="15%" class="td_top">上级栏目名称</td>
                <td width="44%" class="td_top">栏目描述</td>
                <td width="12%" class="td_top">删除</td>
                <td width="12%" class="td_top">修改</td>
            </tr>
            <%--处理器handler查询的数据返回page集合，利用el表达式和jstl对返回的数据进行遍历--%>
            <c:forEach items="${page.dates}" var="date">
                <tr>
                    <td class="td07">${date.name}</td>
                    <td class="td07">${date.parent.name}</td>
                    <td class="td07">${date.content}</td>
                    <%--删除和修改加入超链接地址，使之带着参数传入到handler处理层--%>
                    <td class="td07"><a href="${pageContext.request.contextPath}/desktop/news/deleteNewsLabelById.do?deleteid=${date.id}&pagenum=${page.pagenum}" onClick="shanchu()">删除</a></td>
                    <td class="td07"><a href="#" onClick="javascript:windowOpen('/desktop/news/findNewsLabelById.do?updateid=${date.id}','','',670,260,'no','yes','100','100')">修改</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p>&nbsp;</p>
    </form>
</center>
</body>
</html>
