<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>
            SignIn
        </title>
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
        <h1>SignIn</h1>
        <form action="/validate" method="POST">
             <input type="text" name="username" id="username" placeholder="Username" style="margin: 1vw;padding: 1vw;"><br>
            <input type="password" name="password" id="password" placeholder="Password" style="margin: 1vw;padding: 1vw;"><br>
            <input type="submit" name="submit" id="submit" style="margin: 1vw;">
        </form>
        <div>Not a member? <a href="/signUp">SignUp</a></div>
        <p style="color: red;"><strong>${error}</strong></p>
        <p style="color: green;"><strong>${success}</strong></p>
    </div>
</center>
    </body>
</html>