<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="com.hwh.model.Manager"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<% 
Manager pwd_mng=(Manager)session.getAttribute("manager");
String pwd_mng_name=pwd_mng.getName();
int pwd_mng_id=pwd_mng.getId();
%>

<table width="778"  border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="510" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：更改口令 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
 <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="84%">&nbsp;      </td>
</tr>
</table>  <form name="form1" method="post" action="manager_modifypwd">
  <table width="47%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#D2E3E6" bordercolorlight="#FFFFFF">
  <tr align="center">
    <td width="27%" align="left" style="padding:5px;">管理员名称：</td>
    <td width="73%" align="left">
      <input name="manager.name" type="text" id="name" value="<%=pwd_mng_name%>" readonly="yes" size="30">   <input name="manager.id" type="hidden" value="<%=pwd_mng_id%>"> </td>
    <tr>

    <tr>
      <td align="left" style="padding:5px;">新密码：</td>
      <td align="left"><input name="manager.password" type="password" id="pwd" size="30"></td>
    </tr>
    <tr>
      <td height="65" align="left" style="padding:5px;">&nbsp;</td>
      <td><input type="submit" class="btn_grey" value="保存" >
        &nbsp;
        <input type="reset" class="btn_grey" value="取消"></td>
    </tr>
</table>
</form></td>
      </tr>
    </table>
</td>
  </tr>
</table>

</html>
