<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    This is my JSP page. <br>
    <br>

    
    <form action="<%=basePath%>helloworld/hello15" method="post">
        id:<input type="text" name="id" /> <br>
        name:<input type="text" name="name"/><br>
        date:<input type="text" name="date"/><br>
        POJO test<input type="submit" value="submit">
	</form>
    
    
    <form action="<%=basePath%>helloworld/hello14" method="post">
    	<!-- <input type="hidden" name="_method" value="delete" /> -->
 <!--        id:<input type="text" name="id" /> <br>
        name:<input type="password" name="name"/><br> -->
        employee:<input type="text" name="employee"/><br>
        POJO test<input type="submit" value="submit">
	</form>
      ${requestScope.student.id }<br>
        ${requestScope.student.name }<br>
          ${requestScope.name }<br>
    modelattribute×¢½âtest<br>
    <fmt:message key="i18n.username"></fmt:message> <br>
    <fmt:message key="i18n.password"></fmt:message>
    
    <br>
    ${requestScope.user }<br>
    
     <form action="<%=basePath%>helloworld/hello11" method="post">
    	<input type="hidden" name="_method" value="delete" />
        username:<input type="text" name="username" /> <br>
        POJO test<input type="submit" value="submit">
	</form>
    
    
    
    <form action="<%=basePath%>helloworld/hello10" method="post">
    	<input type="hidden" name="_method" value="delete" />
        username:<input type="text" name="username" /> <br>
        password:<input type="password" name="password"/><br>
        POJO test<input type="submit" value="submit">
	</form>
    
    
    map test:<a href="<%=basePath%>helloworld/hello9">helloworld_9</a><br>
    ${requestScope.names}<br>
    modelandview test:<a href="<%=basePath%>helloworld/hello8">helloworld_8</a><br>
    time:${requestScope.time}<br>
    request test:<a href="<%=basePath%>helloworld/hello7">helloworld_7</a>
    
    <form action="<%=basePath%>helloworld/hello6" method="post">
    	<input type="hidden" name="_method" value="delete" />
        username:<input type="text" name="username" /> <br>
        password:<input type="password" name="password"/><br>
        POJO test<input type="submit" value="submit">
	</form>
    
    <br>
    <form action="<%=basePath%>helloworld/hello2" method="post">
    	post test<input type="submit" value="submit">
    </form>
    
    <form action="<%=basePath%>helloworld/hello3" method="get">
    	username<input type="text" name="username"> <br>
    	params test<input type="submit" value="submit">
    </form>
    <a href="<%=basePath%>helloworld/3">helloworld_3</a>
    
    ant test<a href="<%=basePath%>helloworld/hello4/abc">helloworld_4</a>
    
    <form action="<%=basePath%>helloworld/hello5/5" method="post">
        <input type="hidden" name="_method" value="delete" />
        REST test<input type="submit" value="submit">
	</form>
  </body>
</html>
