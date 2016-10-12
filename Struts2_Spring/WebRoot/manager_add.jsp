<%@ page contentType="text/html; charset=gb2312" language="java"  %>

<html>

<script language="javascript">
function check(form){
	form.submit();
}
</script>

<table width="292" height="175" border="0" align="center" cellpadding="0" cellspacing="0" background="Images/subBG.jpg">
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
            <td align="center" valign="top">	<form name="form1" method="post" action="manager_managerAdd">
	<table height="123"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="83" height="30" align="center">管理员名称：</td>
        <td width="192">
          <input name="manager.name" type="text">        </td>
      </tr>
      <tr>
        <td height="28" align="center">管理员密码：</td>
        <td><input name="manager.password" type="password" id="pwd"></td>
      </tr>
      <tr>
        <td height="37" align="center">&nbsp;</td>
        <td><input name="Button" type="button" class="btn_grey" value="保存" onClick="check(form1)">
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
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>

</html>
