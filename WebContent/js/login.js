
$(function(){
	
	$('#student_Section').click(function(e){
		
		$('#student_Section').css('color','#00b3b3').css('font-weight','bold');
		$('#admin_Section').css('color','#aaa').css('font-weight','normal');
		//$('#student_Section').addClass('touch');
		$('#login-success').delay(100).fadeIn(100);
		$('#admin_login').fadeOut(100);
		$('#admin_Section').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	
	$('#admin_Section').click(function(e){
		
		$('#student_Section').css('color','#aaa').css('font-weight','normal');
		$('#admin_Section').css('color','#00b3b3').css('font-weight','bold');
		$('#admin_login').delay(100).fadeIn(100);
		$('#login-success').fadeOut(100);
		$('#student_Section').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
		
	});
});

