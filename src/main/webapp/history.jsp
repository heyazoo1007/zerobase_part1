<%@ page import="com.example.zerobase_part1.service.WifiService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.zerobase_part1.web.dto.response.HistoryResponse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>제로베이스 Part1 과제</title>
  <style>
    th,td {
      width: 5%;
    }
    th, td {
      border:solid 1px #000;
    }
    th, td {
      text-align: center;
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
      <tr>
        <th>ID</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>조회일자</th>
        <th>비고</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <%
          WifiService wifiService = new WifiService();
          List<HistoryResponse> historyList = wifiService.getHistoryList();
          for (HistoryResponse historyResponseDto : historyList) {
            out.write("<td>" + historyResponseDto.getId() + "</td>");
            out.write("<td>" + historyResponseDto.getX() + "</td>");
            out.write("<td>" + historyResponseDto.getY() + "</td>");
            out.write("<td>" + historyResponseDto.getCreatedTime() + "</td>");
            out.write("<td>" + "<button>삭제</button>" + "</td>");
          }
        %>
      </tr>
    </tbody>
  </table>
</body>
</html>
