package com.example.zerobase_part1.service;

import com.example.zerobase_part1.web.dto.request.CalculateDistanceRequest;
import com.example.zerobase_part1.web.dto.request.HistoryRequest;
import com.example.zerobase_part1.web.dto.request.PublicWifiRequest;
import com.example.zerobase_part1.web.dto.response.CalculateDistanceResponse;
import com.example.zerobase_part1.web.dto.response.HistoryResponse;
import com.example.zerobase_part1.web.dto.response.PublicWifiResponse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WifiService {

    public void wifiSave(PublicWifiRequest publicWifiRequest) {
        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser3";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = "insert into public_wifi(manage_no, borough, wifi_name, street_address, detail_address, floor, type_of_install, company_of_install, which_service, type_of_net, year_of_install, in_or_out, wifi_condition, lat, lnt, work_time) " +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, publicWifiRequest.getManageNo());
            preparedStatement.setString(2, publicWifiRequest.getBorough());
            preparedStatement.setString(3, publicWifiRequest.getWifiName());
            preparedStatement.setString(4, publicWifiRequest.getStreetAddress());
            preparedStatement.setString(5, publicWifiRequest.getDetailAddress());
            preparedStatement.setString(6, publicWifiRequest.getFloor());
            preparedStatement.setString(7, publicWifiRequest.getTypeOfInstall());
            preparedStatement.setString(8, publicWifiRequest.getCompanyOfInstall());
            preparedStatement.setString(9, publicWifiRequest.getWhichService());
            preparedStatement.setString(10, publicWifiRequest.getTypeOfNet());
            preparedStatement.setString(11, publicWifiRequest.getYearOfInstall());
            preparedStatement.setString(12, publicWifiRequest.getInOrOut());
            preparedStatement.setString(13, publicWifiRequest.getWifiCondition());
            preparedStatement.setFloat(14, publicWifiRequest.getLAT());
            preparedStatement.setFloat(15, publicWifiRequest.getLNT());
            preparedStatement.setString(16, publicWifiRequest.getWorkTime());

            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println("저장 성공");
            } else {
                System.out.println("저장 실패");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally { // 아래는 무조건 실행되어야 하므로
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void saveXY(HistoryRequest historyRequest) {
        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser3";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = "insert into history(x, y, created_time) " +
                    "values (?, ?, ?); ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1, historyRequest.getX());
            preparedStatement.setFloat(2, historyRequest.getY());
            preparedStatement.setString(3, String.valueOf(historyRequest.getCreatedTime()));

            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println("저장 성공");
            } else {
                System.out.println("저장 실패");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally { // 아래는 무조건 실행되어야 하므로
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<HistoryResponse> getHistoryList() {
        List<HistoryResponse> historyResponseDtoList = new ArrayList<>();

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser3";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = "select * from history";

            preparedStatement = connection.prepareStatement(sql);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                HistoryResponse historyResponseDto = HistoryResponse.builder()
                        .id(rs.getInt("history_id"))
                        .x(rs.getFloat("x"))
                        .y(rs.getFloat("y"))
                        .createdTime(rs.getString("created_time"))
                        .build();

                historyResponseDtoList.add(historyResponseDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally { // 아래는 무조건 실행되어야 하므로
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return historyResponseDtoList;
    }

    // 입력된 x, y 값으로 모든 튜플과의 거리 계산해서 테이블에 저장하기
    public void calculateDistance(CalculateDistanceRequest calculateDistanceRequest) {
        Float targetLAT = calculateDistanceRequest.getLAT();
        Float targetLNT = calculateDistanceRequest.getLNT();

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser3";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = "select manage_no, lat, lnt from public_wifi ";

            preparedStatement = connection.prepareStatement(sql);

            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                float lat = rs.getFloat("lat");
                float lnt = rs.getFloat("lnt");
                double distance = getDistance(targetLAT, targetLNT, lat, lnt);

                CalculateDistanceResponse calculateDistanceResponse = CalculateDistanceResponse.builder()
                        .distance(distance)
                        .manageNo(rs.getString("manage_no"))
                        .build();

                saveDistance(calculateDistanceResponse);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally { // 아래는 무조건 실행되어야 하므로
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void saveDistance(CalculateDistanceResponse calculateDistanceResponse) {
        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser3";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = "insert into distance(distance, manage_no) " +
                    "values (?, ?); ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, calculateDistanceResponse.getDistance());
            preparedStatement.setString(2, calculateDistanceResponse.getManageNo());

            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println("저장 성공");
            } else {
                System.out.println("저장 실패");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally { // 아래는 무조건 실행되어야 하므로
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    // manage_no 같은 걸로 join 하면 될 듯
    public List<PublicWifiResponse> getClosest20() {
        List<PublicWifiResponse> publicWifiResponseDtoList = new ArrayList<>();

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser3";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = "select d.distance, pw.* from public_wifi pw join distance d on d.manage_no = pw.manage_no order by d.distance limit 0, 20";

            preparedStatement = connection.prepareStatement(sql);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                PublicWifiResponse publicWifiResponse = PublicWifiResponse.builder()
                        .distance(rs.getFloat("distance"))
                        .manageNo(rs.getString("manage_no"))
                        .borough(rs.getString("borough"))
                        .wifiName(rs.getString("wifi_name"))
                        .streetAddress(rs.getString("street_address"))
                        .detailAddress(rs.getString("detail_address"))
                        .floor(rs.getString("floor"))
                        .typeOfInstall(rs.getString("type_of_install"))
                        .companyOfInstall(rs.getString("company_of_install"))
                        .typeOfNet(rs.getString("type_of_net"))
                        .yearOfInstall(rs.getString("year_of_install"))
                        .inOrOut(rs.getString("in_or_out"))
                        .wifiCondition(rs.getString("wifi_condition"))
                        .LAT(rs.getFloat("lat"))
                        .LNT(rs.getFloat("lnt"))
                        .workTime(rs.getString("work_time"))
                        .build();

                publicWifiResponseDtoList.add(publicWifiResponse);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally { // 아래는 무조건 실행되어야 하므로
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return publicWifiResponseDtoList;
    }

    private static double getDistance(Float x1, Float y1, Float x2, Float y2) {
        double dy = Math.pow(Math.abs(y2 - y1), 2);
        double dx = Math.pow(Math.abs(x2 - x1), 2);

        return Math.sqrt(dx + dy);
    }
}
