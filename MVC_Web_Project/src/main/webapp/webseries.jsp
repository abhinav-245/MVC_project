<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Web Series Collection</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h2 {
            text-align: center;
            color: #333;
            padding: 20px;
            background-color: #007bff;
            color: #fff;
            margin: 0;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px;
            text-align: center;
            border: 1px solid #ddd;
        }
        th {
            background-color: #007bff;
            color: #fff;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #e0e0e0;
        }
    </style>
</head>
<body>
    <h2>My Web Series Collection</h2>
    <table>
        <thead>
            <tr>
                <th>Title</th>
                <th>Genre</th>
                <th>Platform</th>
                <th>Release Year</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="webSeries" items="${webSeriesList}">
                <tr>
                    <td>${webSeries.title}</td>
                    <td>${webSeries.genre}</td>
                    <td>${webSeries.platform}</td>
                    <td>${webSeries.releaseYear}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
