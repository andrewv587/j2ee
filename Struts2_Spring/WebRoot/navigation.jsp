<%@ page contentType="text/html; charset=gb2312"%>
<%@ page import="com.hwh.model.Purview"%>
<%@ page import="com.hwh.model.Manager"%>
<%
Manager navigation_mng=(Manager)session.getAttribute("manager");
Purview navigation_pur=navigation_mng.getPurview();
int sysset1=0;
int readerset1=0;
int bookset1=0;
int borrowback1=0;
int sysquery1=0;

if(navigation_pur!=null){
	sysset1=navigation_pur.getSysset();
	readerset1=navigation_pur.getReaderset();
	bookset1=navigation_pur.getBookset();
	borrowback1=navigation_pur.getBorrowback();
	sysquery1=navigation_pur.getSysquery();
}

%>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script src="JS/onclock.JS"></script>
<script src="JS/menu.JS"></script>
<div class=menuskin id=popmenu
      onmouseover="clearhidemenu();highlightmenu(event,'on')"
      onmouseout="highlightmenu(event,'off');dynamichide(event)" style="Z-index:100;position:absolute;"></div>
<table width="778"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr bgcolor="#DFA40C">
        <td width="3%" height="27">&nbsp;</td>
        <td width="29%"><div id="bgclock" class="word_white"></div></td>
		<script language="javascript">
			function quit(){
				if(confirm("真的要退出系统吗?")){
					window.location.href="logout.jsp";
				}
			}
		</script>
        <td width="66%" align="right" bgcolor="#B0690B" class="word_white"><a href="manager_login" class="word_white">首页</a> |
        <%if(sysset1==1){%><a  onmouseover=showmenu(event,sysmenu) onmouseout=delayhidemenu() class="word_white" style="CURSOR:hand" >
        系统设置</a> | <%}%><%if(readerset1==1){%><a  onmouseover=showmenu(event,readermenu) onmouseout=delayhidemenu() style="CURSOR:hand"  
        class="word_white">读者管理</a> | <%}%><%if(bookset1==1){%><a  onmouseover=showmenu(event,bookmenu) onmouseout=delayhidemenu() 
        class="word_white" style="CURSOR:hand" >图书管理</a> | <%}%><%if(borrowback1==1)
        {%><a  onmouseover=showmenu(event,borrowmenu) onmouseout=delayhidemenu() class="word_white" style="CURSOR:hand">图书借还</a> 
        | <%}%><%if(sysquery1==1){%><a  onmouseover=showmenu(event,querymenu) onmouseout=delayhidemenu()  class="word_white" style="CURSOR:hand" >
        系统查询</a> | <%}%><a  href="manager_altergopwd" class="word_white">更改口令</a> | <a href="#" onClick="quit()"
         class="word_white">退出系统</a></td>
        <td width="2%" bgcolor="#B0690B">&nbsp;</td>
  </tr>
      <tr bgcolor="#DFA40C">
        <td height="9" colspan="4" background="Images/navigation_bg_bottom.gif"></td>
      </tr>
</table>
