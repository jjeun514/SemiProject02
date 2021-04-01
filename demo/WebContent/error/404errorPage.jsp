<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%  response.setStatus(HttpServletResponse.SC_OK); %>
<html>
<head>
<title>404에러 페이지</title>
</head>
<body>
  <img alt="" src="${pageContext.request.contextPath }/imgs/404img.png"/>
</body>
</html>