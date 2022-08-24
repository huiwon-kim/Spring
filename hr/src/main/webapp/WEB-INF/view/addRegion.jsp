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


	<form method="post" action="${pageContext.request.contextPath}/addRegion">
		<div>
			regionId : 
			<input type="text" name="regionId" ><!-- 네임이 regionId인 커맨드객체 다 찾음 -->		
		</div>	
		
		<div>
			regionName : 
			<input type="text" name="regionName" ><!-- 네임이 regionName인 커맨드객체 다 찾음 -->		
		</div>	
		
		<div>
			<button type="submit"> addRegion </button>	
		</div>	
		
	</form>
	
	
		<!--  footer include -->
	<hr>
	
	<div>
		<c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
	</div>
		
</body>
</html>