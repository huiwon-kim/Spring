<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<!--  menu.jsp include >>> 인클루드는 포워딩이랑 똑같은데 대신 서버에서 하는거임 -->
 	<div>
      <c:import url="/WEB-INF/view/inc/menu.jsp"></c:import>
   </div>

	<div>
		<a href="${pageContext.request.contextPath}/addRegion"> add Region </a>
	</div>
	<!-- ${list}  -->
	<table border="1">
		<tr>
			<th> RegionId </th>
			<th> RegionName </th>
			<th> 수정 </th>
			<th> 삭제 </th>
		</tr>	
		<tr>
			<c:forEach var="r" items="${list}">
				<tr>
					<td> ${r.regionId} </td>
					<td> ${r.regionName} </td>
					<td><a href="${pageContext.request.contextPath}/modifyRegion?regionId=${r.regionId}&regionName=${r.regionName}"> 수정</a></td>
					<td><a href="${pageContext.request.contextPath}/removeRegion?regionId=${r.regionId}"> 삭제</a></td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	
	<!--  footer include -->
	<hr>
	
   <div>
   <c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
   </div>

</body>
</html>