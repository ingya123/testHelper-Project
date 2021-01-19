<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/smarteditor2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript">


function init(){
	$.ajax({
		url : "insertWrittenName",
		type : "POST",
		data : null,
		success : function(list){
			let html = "<select id='testName'>"
			$.each(list,function(index,item){
				var name = item.test_name
				html += "<option value='"+name+"'>"+name+"</option>"
			})
			html += "</select>"
			$("#name_list").html(html)
		},
		error : function(){
			alert('insertWrittenName init()문제발생')
		}
	})
}


function insertQuiz(){
	var name = $("#testName").val()
	var quizType = $("[name=test_type]:checked").val()
	
	oEditors.getById["quiz"].exec("UPDATE_CONTENTS_FIELD", []);
	
	var quiz = $("#quiz").val();
	var answer = $("#answer").val()
	if(quiz==''){
		alert('문제를 입력해주세요')
	}else if(answer==''){
		alert('문제의 답을 입력해주세요')
	}else{
		var form = {name:name, quiz:quiz, answer:answer, test_type:quizType}
		$.ajax({
			url : "insertQuizContent",
			type : "POST",
			data : form,
			success : function(cnt){
				alert('문제가 등록되었습니다.')
			},
			eorrer : function(){
				alert(실패)
			}
		})
	}
	
	
}


</script>
</head>
<body onload="init()">
	<h3>과목을 지정해주세요</h3>
	<div id="name_list"></div>
	
	<h3>필기입니까 실기입니까?</h3>
	<input type="radio" value="필기" name="test_type" id="test_type" checked>필기
	<input type="radio" value="실기" name="test_type" id="test_type">실기
	
	<h3>문제를 입력해주세요</h3>
	<textarea class="form-control" rows="20" name="quiz" id="quiz">${smarteditorVO.bo_content }</textarea>
	<br>
	<h4>문제의 답을 입력해주세요</h4>
	<textarea rows="" cols="" id="answer"></textarea>
	<br><br>
	<button onclick="insertQuiz()">저장하기</button>
	
	
	
	
	
<script type="text/javascript">

	var oEditors = [];
	//var formBtn = $("#formBtn");

	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors,
		elPlaceHolder : "quiz",
		sSkinURI : "${pageContext.request.contextPath}/resources/smarteditor2/SmartEditor2Skin.html",
		fCreator : "createSEditor2"
	});


</script>
</body>
</html>