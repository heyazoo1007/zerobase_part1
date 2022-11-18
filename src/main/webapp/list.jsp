<%@ page import="com.example.zerobase_part1.service.WifiService" %>
<%@ page import="com.example.zerobase_part1.web.dto.request.CalculateDistanceRequest" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.zerobase_part1.web.dto.response.PublicWifiResponse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        float lat = 0.0f;
        float lnt = 0.0f;
        WifiService wifiService = new WifiService();
        wifiService.calculateDistance(new CalculateDistanceRequest(lat, lnt)); // 거리 구해서 distance 테이블에 저장
    %>
    <p></p>
    <table>
        <thead>
        <tr>
            <th>거리(km)</th>
            <th>관리번호</th>
            <th>자치구</th>
            <th>와이파이명</th>
            <th>도로명주소</th>
            <th>상세주소</th>
            <th>설치유형</th>
            <th>설치기관</th>
            <th>서비스구분</th>
            <th>망종류</th>
            <th>설치년도</th>
            <th>실내외구분</th>
            <th>X좌표</th>
            <th>Y좌표</th>
            <th>작업일자</th>
        </tr>
        </thead>
    <tbody>
        <tr>
            <%
                List<PublicWifiResponse> publicWifiResponseDtoList = wifiService.getClosest20();
                for (PublicWifiResponse publicWifiResponse : publicWifiResponseDtoList) {
                    out.write("<td>" + publicWifiResponse.getDistance() + "</td>");
                    out.write("<td>" + publicWifiResponse.getManageNo() + "</td>");
                    out.write("<td>" + publicWifiResponse.getBorough() + "</td>");
                    out.write("<td>" + publicWifiResponse.getWifiName() + "</td>");
                    out.write("<td>" + publicWifiResponse.getStreetAddress() + "</td>");
                    out.write("<td>" + publicWifiResponse.getDetailAddress() + "</td>");
                    out.write("<td>" + publicWifiResponse.getFloor() + "</td>");
                    out.write("<td>" + publicWifiResponse.getTypeOfInstall() + "</td>");
                    out.write("<td>" + publicWifiResponse.getCompanyOfInstall() + "</td>");
                    out.write("<td>" + publicWifiResponse.getWhichService() + "</td>");
                    out.write("<td>" + publicWifiResponse.getTypeOfNet() + "</td>");
                    out.write("<td>" + publicWifiResponse.getYearOfInstall() + "</td>");
                    out.write("<td>" + publicWifiResponse.getInOrOut() + "</td>");
                    out.write("<td>" + publicWifiResponse.getWifiCondition() + "</td>");
                    out.write("<td>" + publicWifiResponse.getLAT() + "</td>");
                    out.write("<td>" + publicWifiResponse.getLNT() + "</td>");
                    out.write("<td>" + publicWifiResponse.getWorkTime() + "</td>");
                }
        %>
    </tr>
    </tbody>
</table>
</body>
</html>
