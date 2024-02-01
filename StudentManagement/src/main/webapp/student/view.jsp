<%--
  Created by IntelliJ IDEA.
  User: jinye
  Date: 2024-01-30
  Time: PM 5:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="cfmt" uri="http://nhnacademy.com/cfmt" %>--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>학생-조회</title>
  <link rel="stylesheet" href="/style.css" />
</head>
<body>
<table>
  <tbody>
  <!-- todo view 구현 -->
    <tr>
      <th>아이디</th>
      <td>${student.id}</td>
    </tr>
    <tr>
      <th>이름</th>
      <td>${student.name}</td>
    </tr>
    <tr>
      <th>성별</th>
      <td>${student.gender}</td>
    <tr/>
    <tr>
      <th>나이</th>
      <td>${student.age}</td>
    </tr>
    <tr>
<%--      <th>등록일</th>--%>
<%--      <td><fmt:formatDate value="${student.createdAt}" pattern="yyyy-MM-dd HH:mm:ss" /></td>--%>
    </tr>
  </tbody>
</table>
<ul>
  <li><a href="/student/list.do">리스트</a></li>
  <li>
    <!-- todo ${update_link} 설정 c:url -->
    <c:url var="update_link" value="/student/update.do">
      <c:param name="id" value="${student.id}" />
    </c:url>
    <a href="${update_link}">수정</a>
  </li>
  <li>
    <!-- todo 삭제버튼 구현, method=post -->
    <form method="post" action="/student/delete.do">
      <input type="hidden" name="id" value="${student.id}" />
      <button type="submit">삭제</button>
    </form>
 </li>
</ul>
</body>
</html>