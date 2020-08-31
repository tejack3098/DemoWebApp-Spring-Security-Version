<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css" >
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
    <link rel="stylesheet" href="assets/css/login-page.css">
    <title>My Demo App</title>
</head>
<body>


    <div id="logreg-forms">
    	<font color="red" style="text-align: center">${errorMessage}</font>
        <form  class="form-signin" method="post">
            <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign in</h1>
            <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required autofocus>
            <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
            
            <button class="btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i> Sign in</button>
            <a href="#" id="forgot_pswd">Forgot password?</a>
            <hr>
            <!-- <p>Don't have an account!</p>  -->
            <button class="btn btn-primary btn-block" type="button" id="btn-signup"><i class="fas fa-user-plus"></i> Sign up New Account</button>
            </form>

            <form action="#" class="form-reset">
                <input type="email" id="resetEmail" class="form-control" placeholder="Email address" required autofocus>
                <button class="btn btn-primary btn-block" type="submit">Reset Password</button>
                <a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i> Back</a>
            </form>
            
            <form action="${pageContext.servletContext.contextPath}/register" method="post" class="form-signup">

                <input type="text" id="user-name" name="uname" class="form-control" placeholder="User Name" required autofocus>
                <input type="email" id="user-email" name="email" class="form-control" placeholder="Email address" required autofocus>
                <input type="number" id="user-age" name="age" class="form-control" placeholder="Age" required autofocus>
                <input type="password" id="user-pass" name="password" class="form-control" placeholder="Password" required autofocus>
                <input type="password" id="user-repeatpass" name="c_pass" class="form-control" placeholder="Repeat Password" required autofocus>

                <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Sign Up</button>
                <a href="#" id="cancel_signup"><i class="fas fa-angle-left"></i> Back</a>
            </form>
            <br>
            
    </div>
    <script src="assets/vendor/jquery/jquery.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/loginScript.js"></script>
</body>
</html>