<%@ page import="com.example.zerobase_part1.service.WifiService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.zerobase_part1.web.dto.response.HistoryResponse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>제로베이스 Part1 과제</title>
  <style>
    table {
      width: 100%;
    }
    th,td {
      width: 5%;
      border:solid 0.1px #000;
      text-align: center;
    }
    th {
      border-color: white;
    }

  </style>
</head>
<body>
  <h1>위치 히스토리 목록</h1>
  </tr><a href="index.jsp">홈</a> |
  <a href="history.jsp">위치 히스토리 목록</a> |
  <a href="save.jsp">Open API 와이파이 정보 가져오기</a>
  <p></p>
  <table>
    <thead>
      <tr bgcolor="#3cb371">
        <th><font color="white">ID</font></th>
        <th><font color="white">X좌표</font></th>
        <th><font color="white">Y좌표</font></th>
        <th><font color="white">조회 일자</font></th>
        <th><font color="white">비고</font></th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <%
          WifiService wifiService = new WifiService();
          List<HistoryResponse> historyList = wifiService.getHistoryList();
          for (HistoryResponse historyResponseDto : historyList) {
            out.write("<tr>");
            out.write("<td>" + historyResponseDto.getId() + "</td>");
            out.write("<td>" + historyResponseDto.getX() + "</td>");
            out.write("<td>" + historyResponseDto.getY() + "</td>");
            out.write("<td>" + historyResponseDto.getCreatedTime() + "</td>");
            out.write("<td>" + "<button>삭제</button>" + "</td>");
            out.write("</tr>");
          }
        %>
      </tr>
    </tbody>
  </table>
</body>
</html>
