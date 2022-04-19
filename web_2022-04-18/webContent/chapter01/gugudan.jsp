<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 페이지</title>
</head>
<body>
	<h1>스크립트릿 태그로 구구단2단 출력</h1>
	
	<%
		for(int back=1; back<=9; back++){
			out.print("<div>2 X " + back + " = " + (2*back) + "</div>");
		}
	%>	
	
<!-- <script type="text/javascript"> -->
<!-- // 	for(let i=1; i<=9; i++){ -->
<!-- // 		document.write("<div> 2 X "+ i + " = " +  (2*i)+ "</div>"); -->
<!-- // 	} -->
<!-- </script> -->


</body>
</html>