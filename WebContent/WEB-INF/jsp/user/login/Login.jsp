<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class=''>
<head>
<!-- Source : https://bootsnipp.com/snippets/exaD3 -->
<!-- Author : https://bootsnipp.com/naimansari -->
<meta charset='UTF-8'>
<meta name="robots" content="noindex">


    
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
    rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<script src='//production-assets.codepen.io/assets/editor/live/console_runner-079c09a0e3b9ff743e39ee2d5637b9216b3545af0de366d4b9aad9dc87e26bfd.js'></script>
<script src='//production-assets.codepen.io/assets/editor/live/events_runner-73716630c22bbc8cff4bd0f07b135f00a0bdc5d14629260c3ec49e5606f98fdd.js'></script>
<script src='//production-assets.codepen.io/assets/editor/live/css_live_reload_init-2c0dc5167d60a5af3ee189d570b1835129687ea2a61bee3513dee3a50c115a77.js'></script>


<link rel="shortcut icon" type="image/x-icon"
    href="//production-assets.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" />
<link rel="mask-icon" type=""
    href="//production-assets.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg"
    color="#111" />
<link rel="canonical"
    href="https://codepen.io/Lewitje/pen/BNNJjo?limit=all&page=21&q=animation" />
<link href="css/bootstrap.login.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet" id="Style">
<link href="css/Style.css" rel="stylesheet" id="Style">
</head>

<body>
    <div class="wrapper">
        <div class="container">
            <img class="youSyncLogo" alt="youSyncLogo" src="img/logo/Logo.png">

            <form method="post" class="login">
                <input id='txtLogin' name='txtLogin' type='text' value='${login }' autofocus> 
                <input name='txtPassword' type='password' value='${password }'>
                <button name='btnConnect' type='submit' id="btnConnect">Login</button>
            </form>
            <div class="errorMessage">${errorMessage}</div>
            
            <h1>You don't already have an account ?</h1>
            
            <a href="register"><form method="register" class="register">
                <button name='btnRegister' type='button' id="btnRegister" class="w-10 p-1">
                    Register
                </button>
            </form></a>
        </div>


        <ul class="bg-bubbles">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
    <script
        src='//production-assets.codepen.io/assets/common/stopExecutionOnTimeout-b2a7b3fe212eaa732349046d8416e00a9dec26eb7fd347590fbced3ab38af52e.js'>
    </script>

    <script
        src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'>
    </script>

</body>
</html>