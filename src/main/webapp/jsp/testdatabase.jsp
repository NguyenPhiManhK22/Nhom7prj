<%@ page import="java.sql.Connection" %>
<%@ page import="db.DBConnection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Kiểm tra kết nối Database</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 50px;
            background-color: #f4f4f4;
            text-align: center;
        }
        .result {
            padding: 20px;
            font-size: 20px;
            color: white;
            display: inline-block;
            margin-top: 30px;
        }
        .success {
            background-color: #4CAF50;
        }
        .fail {
            background-color: #f44336;
        }
    </style>
</head>
<body>
    <h1>🧪 Kiểm tra kết nối đến MySQL</h1>

    <%
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
    %>
                <div class="result success">✅ Kết nối thành công đến MySQL!</div>
    <%
            } else {
    %>
                <div class="result fail">❌ Không thể kết nối đến MySQL!</div>
    <%
            }
        } catch (Exception e) {
    %>
            <div class="result fail">
                ❌ Lỗi kết nối: <%= e.getMessage() %>
            </div>
    <%
        } finally {
            if (conn != null) conn.close();
        }
    %>

</body>
</html>
