<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="com.hwh.model.Bookinfo" %>

<%@ page import="java.util.*"%>
<html>
<%
List<Bookinfo> books=(List<Bookinfo>)session.getAttribute("bookQuery");
%>


<table width="778"  border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="510" valign="top" style="padding:5px;"><table width="98%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">��ǰλ�ã�ͼ����� &gt; ͼ�鵵������ &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top"><%
if(books==null || books.isEmpty()){
%>
          <table width="100%" height="30"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="36" align="center">����ͼ����Ϣ��</td>
            </tr>
          </table>
          <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
      <a href="book_add">���ͼ����Ϣ</a> </td>
  </tr>
</table>
 <%
}else{
  //ͨ��������ʽ��ʾ����
  Iterator<Bookinfo> it=books.iterator();
  int ID=0;
  String bookname="";
  String barcode="";
  String typename="";
  String publishing="";
  String bookcase="";
  int storage=0;
  %>
 <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="87%">&nbsp;      </td>
<td width="13%">
      <a href="book_add">���ͼ����Ϣ</a></td>	  
  </tr>
</table>  
  <table width="98%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#F6B83B" bordercolorlight="#FFFFFF">
  <tr align="center" bgcolor="#e3F4F7">
    <td width="13%" bgcolor="#F9D16B">������</td>  
    <td width="26%" bgcolor="#F9D16B">ͼ������</td>
    <td width="15%" bgcolor="#F9D16B">ͼ������</td>
    <td width="14%" bgcolor="#F9D16B">������</td>
    <td width="12%" bgcolor="#F9D16B">���</td>
    <td width="9%" bgcolor="#F9D16B">�޸�</td>
    <td width="5%" bgcolor="#F9D16B">ɾ��</td>
  </tr>
<%
  while(it.hasNext()){
	Bookinfo tmp_book=(Bookinfo)it.next();
	ID=tmp_book.getId();
	bookname=tmp_book.getBookname();
	barcode=tmp_book.getBarcode();
	typename=tmp_book.getBooktype().getTypeName();
	publishing=tmp_book.getPublishing().getPubname();
	bookcase=tmp_book.getBookcase().getName();
	%> 
  <tr>
    <td style="padding:5px;">&nbsp;<%=barcode%></td>  
    <td style="padding:5px;"><a href="book.do?action=bookDetail&ID=<%=ID%>"><%=bookname%></a></td>
    <td style="padding:5px;">&nbsp;<%=typename%></td>  
    <td style="padding:5px;">&nbsp;<%=publishing%></td>  
    <td style="padding:5px;">&nbsp;<%=bookcase%></td>  
	
    <td align="center"><a href="book.do?action=bookModifyQuery&ID=<%=ID%>">�޸�</a></td>
    <td align="center"><a href="book.do?action=bookDel&ID=<%=ID%>">ɾ��</a></td>
  </tr>
<%
  }
}
%>  
</table></td>
      </tr>
    </table>
</td>
  </tr>


</html>
