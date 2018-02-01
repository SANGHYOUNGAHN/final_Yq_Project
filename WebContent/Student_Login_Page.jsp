
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>YONG Q</title>

<!-- 부트스트랩 쓰기위한 형식 -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awsome.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<link href="css/basic.css" rel='stylesheet'>
<link href="css/login.css" rel='stylesheet'>

<link href="css/bootstrap.css" rel="stylesheet" />


<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="script/student.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>


	
<body>
	<div class='YqLogin_header'>
		<nav class='navbar navbar-fixed-top'>
	      <div class='container-fluid'>
	        <div class='navbar-header'>
	          <button type='button' class='navbar-toggle collapsed' data-toggle='collapsed' data-target='#bs-example-navbar-collapse-1'>
	            <span class='menu' id='small_login'>로그인</span>
	          </button>
	          <a class='navbar-brand' href="#">YONG Q</a>
	        </div>
	        <div class='collapse navbar-collapse' id='bs-example-navbar-collapse-1'>
	          <ul class='nav navbar-nav navbar-right'>
	            <li class="active">
	              <a class='menu' href="#">도움말</a>
	            </li>
	            <li>
	              <a class='menu' href="#">로그인</a>
	            </li>
	          </ul>
	        </div>
	      </div>
    	</nav>
  	</div>
  	  
	<div class='Login_Body'>
		<div class='login_page container'>
			<div class='row'>
				<div class='Yq_login col-lg-6 col-lg-offset-3 col-sm-6 col-sm-offset-3 col-xs-6 col-xs-offset-3'>
					<div class='login panel-login'>
						<div class='box_header panel-heading'>
							<div class='login_Section col-lg-6  col-sm-6 col-xs-6'>
								<a href='#' id="student_Section">학생</a>
							
							</div>
							<div class='login_Section col-lg-6 col-sm-6 col-xs-6'>
								<a href='#' id="admin_Section">관리자</a>
							</div>
						</div>
						<hr>
					</div> 		
					
					
					<div class='student_body panel-body'>
						<div class='row'>
							<form id='login-success' action='Login.do' method='post' role='form'>
								<div class='student_input form-group col-lg-8 col-lg-offset-2'>
									<input type='text' name='stu_id' id='stu_id' tabindex='1' class='form-control' placeholder='학번' />
								</div>
								<div class='form-group col-lg-8 col-lg-offset-2'>
									<input type='password' name='stu_pw' id='stu_pw' tabindex='2' class='form-control' placeholder='패스워드' />		
								</div>
								
								<div class='student_btn form-group col-lg-4 col-lg-offset-4'>
					
									<input type='submit' id='login_Button' value='로그인' class='form-control' onclick='return loginCheck()'/>
									
									<input type='reset' id='login_Cancel' value='취소'class='form-control' />
								</div>
							</form>
							
							<form id='admin_login' action='AdminLogin.do' method='post' role='form'>
								<div class='admin_input form-group col-lg-8 col-lg-offset-2'>
									<input type='text' name='ad_id' id='ad_id' tabinbox='1' class='form-control' placeholder='관리자번호' />
								</div>
								<div class='form-group col-lg-8 col-lg-offset-2'>
									<input type='password' name='ad_pw' tabinbox='2' class='form-control' placeholder='관리자 비밀번호' />
								</div>
																<div class='student_btn form-group col-lg-4 col-lg-offset-4'>
					
									<input type='submit' id='login_Button' value='로그인' class='form-control' onclick='return loginCheck()'/>
	
									<input type='reset' id='login_Cancel' value='취소'class='form-control' />
								</div>
							
							</form>
						</div>
					</div>
				
					
					
					
					
					
		
					
					
					
						

		
							
							
				</div>			
			</div>														
		</div>		
	</div>
</body>

<script src='js/login.js'></script>
</html>
