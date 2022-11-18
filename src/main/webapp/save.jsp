<%@ page import="com.example.zerobase_part1.web.ApiExplorer" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Open API 와이파이 정보 가져오기</title>
</head>
<body>
    <%
        ApiExplorer apiExplorer = new ApiExplorer();
        Integer totalWifi = apiExplorer.wifiSave();
    %>
    <p></p>
    <div style="text-align: center"><h1><%=totalWifi%>개의 WIFI 정보를 정상적으로 저장하였습니다.</h1></div>
    <p></p>
    <div style="text-align: center"><a href="index.jsp">홈으로 가기</a></div>
</body>
</html>
