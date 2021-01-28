<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>SignUp</title>
        <style>
            .inpStyle{
                text-align: center;
                margin: 2vw;
                background-color:#E8E8E8;
                padding:1vw;
                width: max-content;
            }
            .inpStyle input{
                margin: 1vw;
                padding: 1vw;
            }
        </style>
    </head>
    <body>
        <center>
        <div class="inpStyle">
            <h1>SignUp</h1>
        <form action="/validateSignUp" method="POST">
            <input type="text" name="username" id="username" placeholder="Username"><br>
            <input type="text" name="mobileno" id="mobileno" placeholder="Mobile No."><br>
            <input type="text" name="email" id="email" placeholder="Email"><br>
            <input type="password" name="password" id="password" placeholder="Password"><br>
            <input type="password" name="cpassword" id="cpassword" placeholder="Confirm Password"><br>
            <input type="submit" name="submit">
        </form>
        <p style="color: red;"><strong>${error}</strong></p>
    </div>
</center>
    </body>
</html>