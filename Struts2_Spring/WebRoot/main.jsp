<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%
String mainPage=(String)session.getAttribute("mainPage");
if(mainPage==null)
	mainPage="default.jsp";
%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<head>
<title>图书馆管理系统</title>
<link href="CSS/style.css" rel="stylesheet">
</head>
<body onLoad="clockon(bgclock)">
<%@include file="banner.jsp"%>
<%@include file="navigation.jsp"%>
<jsp:include page="<%=mainPage%>"/>
<%@ include file="copyright.jsp"%>
</body>
</html>
