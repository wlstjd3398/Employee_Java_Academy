<%@page import="bean.Bean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="bean" class="bean.Bean"  />
<!-- 클라이언트가 멤버 변수의 이름과 일치하게 파라미터를 전달하면 자동으로 param이 붙어서 값이 저장됨 -->
<%-- <jsp:setProperty property="name" name="bean" param="name" /> --%>
<%-- <jsp:setProperty property="age" name="bean" /> --%>
<!-- 굳이 param이라는 속성을 쓰지않아도 name에서 가져올수있다 -->
<%-- value="<%= request.getParameter(\"name\")    param="name"과 같은 값 --%>

<!-- 클라이언트가 모든 멤버변수의 값을 저장할 수 있게 파라이터를 전달하면 아래와 같이 property에 *를 사용해도됨 -->
<!-- 종종 jsp에서 자바빈즈에서 쓰지만 spring에서는 잘안씀 -->
<jsp:setProperty property="*" name="bean" />




<!-- 자바코드를 위 jsp코드(표준액션태그, 자바빈즈)로 변환 -->
<%-- <% --%>
<!-- // 	String name = request.getParameter("name"); -->
<!-- // 	Bean bean  = new Bean(); -->
<!-- // 	bean.setName("홍길동"); -->
<%-- %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Welcome~! <jsp:getProperty property="name" name="bean" /></h1>
	<h1>나이는 <jsp:getProperty property="age" name="bean" /></h1>

</body>
</html>