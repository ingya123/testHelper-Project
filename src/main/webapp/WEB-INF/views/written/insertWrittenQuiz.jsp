<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript">

function insertWrittenName(){
	var written_name = $("#written").val();
	var form = {test_name:written_name}
	
	$.ajax({
		url : "insertWrittenName",
		type : "POST",
		data : form,
		success : function(list){
			let html = "<select>"
			$.each(list,function(index,item){
				html += "<option value=''>"+item.test_name+"</option>"
			})
			html += "</select>"
			$("#name_list").html(html)
		},
		error : function(){
			alert('insertWrittenName문제발생')
		}
	})
}

function init(){
	$.ajax({
		url : "insertWrittenName",
		type : "POST",
		data : null,
		success : function(list){
			let html = "<select>"
			$.each(list,function(index,item){
				html += "<option value=''>"+item.test_name+"</option>"
			})
			html += "</select>"
			$("#name_list").html(html)
		},
		error : function(){
			alert('insertWrittenName init()문제발생')
		}
	})
}

</script>
</head>
<body onload="init()">

<div id="container">
	<h4>과목을 등록해주세요</h4>
	<input type="text" id="written" placeholder="과목을 입력해주세요.">
	<button type="button" onclick="insertWrittenName()">등록하기</button>
	<hr>
	<div>
		<h3>등록된 과목</h3>
		<div id="name_list">
			<select>
				<option value="">-등록된 과목 목록입니다-</option>
			</select>
		</div>
		<hr>
		
		<button onclick="location.href='/test/insertQuiz'">문제 등록하러 가기</button>
	
	</div>
</div>
</body>
</html>