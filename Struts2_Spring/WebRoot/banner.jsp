<%@ page contentType="text/html; charset=gb2312"%>
<%@ page import="com.hwh.model.Manager"%>
<%
//验证用户是否登录
if(session.getAttribute("manager")==null){
	response.sendRedirect("manager_login");
}
Manager banner_mng=(Manager)session.getAttribute("manager");
%>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="118" valign="top" background="Images/top_bg.gif" bgcolor="#EEEEEE"><table width="100%" height="33"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="81%" height="10"></td>
        <td colspan="2"></td>
      </tr>
      <tr>
        <td height="20">&nbsp;</td>
        <td width="10%"><a href="#" onClick="window.location.reload();" class="word_dark">刷新页面</a></td>
        <td width="9%"><a href="#" onClick="myclose()" class="word_dark">关闭系统</a></td>
		<script language="javascript">
			function myclose(){
				if(confirm("真的要关闭当前窗口吗?")){
					window.close();
				}
			}
		</script>
        </tr>
    </table>
      <table width="93%" height="79"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="69" align="right" valign="bottom">当前登录用户：<%=banner_mng.getName()%></td>
        </tr>
    </table></td>
  </tr>
</table>
