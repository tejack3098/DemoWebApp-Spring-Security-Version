<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
    <link rel="stylesheet" href="assets/css/login-page.css">
    <title>My Demo App</title>
</head>
<body>

    <div id="logreg-forms">
       		<font color="red" style="text-align: center">${errorMessage}</font>
            <form action="${pageContext.servletContext.contextPath}/verifyOTP" method="post">
            	<input type="hidden" name="email" value=${email}>
                <input type="number" id="user_otp" name="user_otp" class="form-control" placeholder="Enter OTP" required autofocus>
                <button class="btn btn-primary btn-block" type="submit">Verify OTP</button>
                <a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i> Back</a>
            </form>
            <br>
            
    </div>
    
    <script src="assets/vendor/jquery/jquery.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/loginScript.js"></script>
</body>
</html>