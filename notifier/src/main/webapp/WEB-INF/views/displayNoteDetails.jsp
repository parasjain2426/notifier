<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Notes</title>
        <style>
          .noteEdit{
            display: block;
            width: 100%;
            height: 100%;
            z-index: 1;
            position: fixed;
            top: 0vw;
            left: 0vw;
            background-color: rgb(0,0,0);
            background-color: rgba(0,0,0,0.4);
            overflow: auto;
        }

        .noteEdit-content{
            background-color: #fefefe;
            margin: 2vw;
            padding: 5vw;
            border: 1px solid #888;
            width: auto;
        }
        </style>
    </head>
    <body>
        <div id="noteEditSection" class="noteEdit">
            <div class="noteEdit-content">
            <h1 style="text-align: center;">Note</h1>
                <br>
                <center>
                    <table style="width:50vw;">
                        <tbody>
                        <tr>
                        <td style="float:left;font-weight:bold;">Notename</td>
                        <td style="float:right;">${note.noteName}</td>
                        </tr>
                        <tr>
                        <td style="float:left;font-weight:bold;">Started On</td>
                        <td style="float:right;">${note.startDate}</td>
                        </tr>
                        <tr>
                        <td style="float:left;font-weight:bold;">Ends On</td>
                        <td style="float:right;">${note.endDate}</td>
                        </tr>
                        <tr>
                        <td style="float:left;font-weight:bold;">Reminder Date</td>
                        <td style="float:right;">${note.reminderDate}</td>
                        </tr>
                        <tr>
                        <td style="float:left;font-weight:bold;">Tag</td>
                        <td style="float:right;">${note.tag}</td>
                        </tr>
                        <tr>
                        <td style="float:left;font-weight:bold;">Status</td>
                        <td style="float:right;">${note.status}</td>
                        </tr>
                        <tr>
                        <td style="float:left;font-weight:bold;">Description</td>
                        <td style="float:right;">${note.description}</td>
                        </tr>    
                        </tbody>
                    </table>
            </center>
            </div>
            </div>
    </body>
</html>