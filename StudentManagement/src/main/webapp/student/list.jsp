<%--
  Created by IntelliJ IDEA.
  User: jinye
  Date: 2024-01-30
  Time: PM 2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>student - list</title>
  <link rel="stylesheet" href="/style.css" />
</head>

<body>
<h1>학생 리스트</h1>
<p><a href="/student/register" >학생(등록)</a></p>
<table>
  <thead>
  <tr>
    <th>아이디</th>
    <th>이름</th>
    <th>성별</th>
    <th>나이</th>
    <th>cmd</th>
  </tr>
  </thead>
  <tbody>
  <!--todo list 구현하기 c:foreach -->
  <c:forEach var="students" items="${studentList}">
    <tr>
      <td>${students.id}</td>
      <td>${students.name}</td>
      <td>${students.gender}</td>
      <td>${students.age}</td>
      <td><a href="">조희</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
