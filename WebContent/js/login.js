
$(function(){
	
	$('#student_Section').click(function(e){
		$('#login-success').delay(100).fadeIn(100);
		$('#admin_login').fadeOut(100);
		$('#admin_Section').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	
	$('#admin_Section').click(function(e){
		
		$('#admin_login').delay(100).fadeIn(100);
		$('#login-success').fadeOut(100);
		$('#student_Section').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
		
	});
});
