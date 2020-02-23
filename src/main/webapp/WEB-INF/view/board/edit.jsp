<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
<c:if test="${!empty authInfo }">
	<form:form commandName="boardVO" method="post">
		<table border="1">
			<tr>
				<th><form:label path="title">제목</form:label></th>
				<td><form:input path="title"/>
				<form:errors path="title"/></td>
			</tr>
			<tr>
				<th><form:label path="content">내용</form:label></th>
				<td><form:input path="content"/>
				<form:errors path="content"/></td>
			</tr>
			<tr>
				<th><form:label path="writer">작성자</form:label></th>
				<td><form:input path="writer"/>
				<form:errors path="writer"/></td>
			</tr>
			<tr>
				<th><form:label path="password">비밀번호</form:label></th>
				<td><input type="password" name="pwd" id="pwd" value="${authInfo.password }"/></td>
			</tr>
		</table>
		<div>
			<input type="submit" value="등록">
			<a href='<c:url value="/board/list"/>'>목록</a>
		</div>
	</form:form>
	</c:if>
	<c:if test="${empty authInfo }">
	<form:form commandName="boardVO" method="post">
		<table border="1">
			<tr>
				<th><form:label path="title">제목</form:label></th>
				<td><form:input path="title"/>
				<form:errors path="title"/></td>
			</tr>
			<tr>
				<th><form:label path="content">내용</form:label></th>
				<td><form:input path="content"/>
				<form:errors path="content"/></td>
			</tr>
			<tr>
				<th><form:label path="writer">작성자</form:label></th>
				<td><form:input path="writer"/>
				<form:errors path="writer"/></td>
			</tr>
			<tr>
				<th><form:label path="password">비밀번호</form:label></th>
				<td><input type="password" name="pwd" id="pwd"/></td>
			</tr>
		</table>
		<div>
			<input type="submit" value="등록">
			<a href='<c:url value="/board/list"/>'>목록</a>
		</div>
	</form:form>
	</c:if>
</body>
</html>