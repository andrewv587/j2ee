<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="com.hwh.model.Manager"%>
<%@ page import="com.hwh.model.Purview"%>

<%
Manager modify_mng=(Manager)session.getAttribute("manager_modify");
Purview modify_pur=modify_mng.getPurview();
int modify_id=modify_mng.getId();
String modify_name=modify_mng.getName();
String modift_password=modify_mng.getPassword();
int modify_sysset=0;
int modify_readerset=0;
int modify_bookset=0;
int modify_borrowback=0;
int modify_sysquery=0;

if( modify_pur!=null){
	modify_sysset= modify_pur.getSysset();
	modify_readerset= modify_pur.getReaderset();
	modify_bookset= modify_pur.getBookset();
	modify_borrowback= modify_pur.getBorrowback();
	modify_sysquery= modify_pur.getSysquery();
}
%>
<html>

<table width="292" height="175" align="center" border="0" cellpadding="0" cellspacing="0" background="Images/subBG.jpg">
  <tr>
    <td valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="3%" height="25">&nbsp;</td>
        <td width="94%">&nbsp;</td>
        <td width="3%">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><table width="100%" height="131"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td align="center" valign="top">	<form name="form1" method="post" action="manager_managerModify">
	<table height="126"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="85" height="29" align="center">管理员名称：		</td>
        <td width="190">
          <input name="manager.id" type="hidden" value="<%=modify_id%>"> <input name="manager.password" type="hidden" value="<%=modift_password%>">
          <input name="manager.name" type="text"  value="<%=modify_name%>">        </td>
      </tr>
      <tr>
        <td height="74" align="center">拥有的权限：</td>
        <td><table width="100%" height="67" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="47%"><input name="purview.sysset" type="checkbox" class="noborder" id="sysset" value="1" <%if(modify_sysset==1){out.println("checked");}%>>
系统设置</td>
            <td width="53%"><input name="purview.readerset" type="checkbox" class="noborder" id="readerset" value="1" <%if(modify_readerset==1){out.println("checked");}%>>
              读者管理</td>
          </tr>
          <tr>
            <td><input name="purview.bookset" type="checkbox" class="noborder" id="bookset" value="1" <%if(modify_bookset==1){out.println("checked");}%>>
              图书管理</td>
            <td><input name="purview.borrowback" type="checkbox" class="noborder" id="borrowback" value="1" <%if(modify_borrowback==1){out.println("checked");}%>>
              图书借还</td>
          </tr>
          <tr>
            <td height="23"><input name="purview.sysquery" type="checkbox" class="noborder" id="sysquery" value="1" <%if(modify_sysquery==1){out.println("checked");}%>>
              系统查询</td>
            <td>&nbsp;</td>
          </tr>
        </table>          </td>
      </tr>
      <tr>
        <td height="22" align="center">&nbsp;</td>
        <td><input type="submit" class="btn_grey" value="保存">
&nbsp;
<input name="Submit2" type="button" class="btn_grey" value="关闭" onClick="window.close();"></td>
      </tr>
    </table>
	</form></td>
          </tr>
        </table></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="17">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>


</html>
