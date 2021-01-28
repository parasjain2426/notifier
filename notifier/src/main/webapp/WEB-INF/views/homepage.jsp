<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Notifier</title>
        <style>
            .inpStyle{
                text-align: center;
                margin: 1vw;
                padding:1vw;
                width: max-content;
            }
            .inpStyle input{
                margin: 1vw;
                padding: 1vw;
            }
        .userEdit{
            display: none;
            width: 100%;
            height: 100%;
            z-index: 1;
            padding: 2vw;
            top: 0vw;
            left: 0vw;
            position: fixed;
            background-color: rgb(0,0,0);
            background-color: rgba(0,0,0,0.4);
        }

        .userEdit-content{
            background-color: #fefefe;
            margin: auto;
            padding: 5vw;
            border: 1px solid #888;
            width: min-content;
        }
        .notebookCreate{
            display: none;
            width: 100%;
            height: 100%;
            z-index: 1;
            position: fixed;
            top: 0vw;
            left: 0vw;
            background-color: rgb(0,0,0);
            background-color: rgba(0,0,0,0.4);
        }

        .notebookCreate-content{
            background-color: #fefefe;
            margin: auto;
            padding: 5vw;
            border: 1px solid #888;
            width: min-content;
        }
        .noteAdd{
            display: none;
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

        .noteAdd-content{
            background-color: #fefefe;
            margin: auto;
            padding: 5vw;
            border: 1px solid #888;
            width: min-content;
        }
        .noteEdit{
            display: none;
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
            margin: auto;
            padding: 5vw;
            border: 1px solid #888;
            width: min-content;
        }
        .notebookEdit{
            display: none;
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

        .notebookEdit-content{
            background-color: #fefefe;
            margin: auto;
            padding: 5vw;
            border: 1px solid #888;
            width: min-content;
        }
        .sidenav {
            display: none;
            height: 100%;
            width: 20vw;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #111;
            overflow-x: hidden;
            padding-top: 6vw;
        }

        .sidenav button {
            padding: 1vw 1vw 1vw 2vw;
            text-decoration: none;
            font-size: 2vw;
            color: #818181;
            border: 0vw;
            background-color: #111;
            display: block;
            }

            .sidenav button:hover {
            color: #f1f1f1;
            }

            .sidenav .closebtn {
            position: absolute;
            top: 0;
            right: 1vw;
            font-size: 5vw;
            margin-left: 12vw;
            }
          
          @media screen and (max-height: 450px) {
            .sidenav {padding-top: 15px;}
            .sidenav a {font-size: 18px;}
          }

          .notebookDisplay{
              height: 30vh;
              background-color: #F0F0F0;
          }

          .newNoteBook{
            float: right;
            padding: 1vw;
            margin: 1vw;
            color: white;
            display: none;
            border: 0vw;
            background-color: #111;
            font-size: 1vw;
          }

          .notebooks{
              display: block;
              margin-right:3vw;
          }

          .notes{
              display: none;
              margin-right:3vw;
          }

          .reminder{
            float: right;
            padding: 1vw;
            margin: 1vw;
            color: white;
            position:relative;
          }
          .reminder-content{
            background-color:black;
            color:white;
            display:none;
            height: auto;
            width: auto;
            padding: 0.5vw;
            text-align: center;
            position:fixed;
            z-index: 1;
          }
          .reminder:hover .reminder-content{
              display: block;
          }
          </style>
    </head>
    <body>
        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <p style="color: white;font-size: 2vw;"><strong>Hi ${user.username}</strong></p>
            <button id="notebookShow" onclick="allNotebooks()">Notebooks</a>
            <button id="notesShow" onclick="allNotes()">Notes</a>
            <button id="editUser" onclick="onEditUser()">Edit User</button>
            <div style="margin: 1vw;color: white;">To do Tasks!
                <c:forEach var="reminder" items="${reminders}">
                    <h2 style="text-align: center;">${reminder.noteName}</h2>
                    <h3>Started on: ${reminder.startDate}</h3>
                    <h3>End on: ${reminder.endDate}</h3>
                    <br>
                </c:forEach>
            </div>
          </div>
        <div style="width: 100%; height:5vw;background-color:black;">
            <span style="font-size:30px;cursor:pointer;color: white;float: left;" onclick="openNav()">&#9776;</span>
            <a href="/logout/${userId}" style="float: right;padding: 1vw;margin: 1vw;color: white;">LogOut</a>
            <h4 class="reminder">Reminder
                <div class="reminder-content">
                    <c:forEach var="reminder" items="${reminders}">
                        <p>${reminder.noteName}</p>
                        <p style="margin:2vw;">Started on: ${reminder.startDate}</p>
                        <br>
                    </c:forEach>
                </div>
            </h4>
            <button class="newNoteBook" id="notebookButton" onclick="onCreateNotebook()">New Notebook</button>
        </div>
        <div class="notebooks">
            <p style="text-align: center;color: grey;"><strong>${msg}</strong></p><br>
            <ol style="list-style: none;">
                <c:forEach var="notebook" items="${notebooks}" varStatus="loop">
                    <li>
                    <div class="notebookDisplay">
                      <h2> <a href="/notesDisplay/${userId}/${notebook.notebookId}" style="margin:1vw;float:left;" id="${loop.index}">${notebook.notebookName}</a></h2> <br>
                        <button style="float:right;margin:1vw;" id="editNotebook-${loop.index}" onclick="editNotebook('${notebook.notebookId}')">Edit</button>
                        <a href="/delete/${userId}/${notebook.notebookId}" style="float: right;margin:1vw;" id="${loop.index}">Delete</a>
                        <br><br><br>
                        <div style="margin:2vw;">
                            <p id="${loop.index}">Notes: ${notebook.notesCount}</p>
                            <button style="float:left;" id="addNote-${loop.index}" onclick="addNote('${notebook.notebookId}')">Add</button>
                        </div>
                    </div>
                    <br><br>
                    </li>
                </c:forEach>
            </ol>
        </div>
        <div class="notes">
            <ol style="list-style: none;">
                <c:forEach var="note" items="${notes}" varStatus="loop">
                    <li>
                        <div class="notebookDisplay">
                        <h2 style="margin:1vw;font-size: 2vw;float:left;" id="${loop.index}"><a href="/noteDisplay/${note.noteId}">${note.noteName}</a></h2><br>
                        <button style="float:right;margin:1vw;" id="editNote-${loop.index}" onclick="editNote('${note.noteId}')">Edit</button>
                        <a href="/delete/note/${userId}/${note.noteId}" style="float: right;margin:1vw;" id="${loop.index}">Delete</a>
                        <br><br>
                        <h3 style="width: fit-content;height: auto;background-color:#0047ab;color: white;margin:2vw;padding: 1vw;">${note.status}</h3>
                        <h3 style="margin:2vw;">Started on: ${note.startDate}</h3>
                    </div>
                    <br><br>
                    </li>
                </c:forEach>
            </ol>
        </div>

        <div id="notebookEditSection" class="notebookEdit">
            <div class="notebookEdit-content">
                <button id="notebookEditClose" style="float: right;margin: 0vw;" onclick="closeNotebookEditSection()">Close</button><br>
                <br>
                <center>
                    <h1>Edit NoteBook</h1>
                <form id="editForm" method="POST" class="inpStyle">
                    <label for="notebookNameEdit"><strong>Notebook Name</strong></label><br>
                    <input type="text" placeholder="Notebook Name" name="notebookNameEdit" id="notebookNameEdit" value="${notebook.notebookName}"><br>
                    <input type="submit" name="submit"  id="submitEditNotebook" style="background-color: green;color: white;" onclick="onEditNotebook()">
                </form>
            </center>
            </div>
        </div>

        <div id="notebookCreateSection" class="notebookCreate">
            <div class="notebookCreate-content">
                <button id="notebookCreateClose" style="float: right;margin: 0vw;" onclick="closeNotebookCreateSection()">Close</button><br>
                <br>
                <center>
                    <h1>NoteBook</h1>
                <form action="/newNotebook/${user.id}" method="POST" class="inpStyle">
                    <label for="notebookName"><strong>Notebook Name</strong></label><br>
                    <input type="text" placeholder="Notebook Name" name="notebookName" id="notebookName"><br>
                    <input type="submit" name="submit" style="background-color: green;color: white;">
                </form>
            </center>
            </div>
        </div>

        <div id="editUserSection" class="userEdit">
            <div class="userEdit-content">
                <button id="closeUserEdit" style="float: right;margin: 0vw;" onclick="closeUserEditSection()">Close</button><br>
                <br>
                <center>
                    <h1>Edit User</h1>
                <form action="/editUser/${user.id}" method="POST" class="inpStyle">
                    <label for="username"><strong>Username</strong></label><br>
                    <input type="text" value="${user.username}" placeholder="Username" name="username" id="username"><br>
                    <label for="email"><strong>Email</strong></label><br>
                    <input type="text" value="${user.email}" placeholder="Email" name="email" id="email"><br>
                    <label for="mobileNo"><strong>Mobile No.</strong></label>
                    <input type="text" value="${user.mobileNo}" placeholder="Mobile No." name="mobileNo" id="mobileNo">
                    <label for="password"><strong>Password</strong></label>
                    <input type="password" value="${user.password}" placeholder="Password" name="password" id="password"><br>
                    <input type="submit" name="submit" style="background-color: green;color: white;" >
                </form>
            </center>
            </div>
        </div>

        <div id="noteAddSection" class="noteAdd">
            <div class="noteAdd-content">
                <button id="closeNoteAdd" style="float: right;margin: 0vw;" onclick="closeNoteAddSection()">Close</button><br>
                <br>
                <center>
                    <h1>Add Note</h1>
                <form method="POST" class="inpStyle" id="addNoteForm">
                    <label for="notename"><strong>Note Name</strong></label>
                    <input type="text" placeholder="NoteName" name="notename" id="notename"><br>
                    <label for="start"><strong>Start Date</strong></label>
                    <input type="date" name="start" id="start"><br>
                    <label for="end"><strong>End Date</strong></label>
                    <input type="date" name="end" id="end"><br>
                    <label for="reminder"><strong>Reminder Date</strong></label>
                    <input type="date" name="reminder" id="reminder"><br>
                    <label for="tag">Tag</label>
                    <select name="tag" id="tag">
                        <option value="private">Private</option>
                        <option value="public">Public</option>
                    </select><br>
                    <br>
                    <label for="status">Status</label>
                    <select name="status" id="status">
                        <option value="Started">Started</option>
                        <option value="Not Started">Not Started</option>
                    </select><br>
                    <label for="description">Description</label>
                    <textarea id="description" name="description" rows="4" cols="50" form="addNoteForm"></textarea><br>
                    <br>
                    <input type="submit" name="submit" style="background-color: green;color: white;" id="noteSubmit" onclick="onAddNote()">
                </form>
            </center>
            </div>
        </div>
        <div id="noteEditSection" class="noteEdit">
            <div class="noteEdit-content">
                <button id="closeNoteEdit" style="float: right;margin: 0vw;" onclick="closeNoteEditSection()">Close</button><br>
                <br>
                <center>
                    <h1>Edit Note</h1>
                <form method="POST" class="inpStyle" id="editNoteForm">
                    <label for="notenameEdit"><strong>Note Name</strong></label>
                    <input type="text" placeholder="NoteName" name="notename" id="notenameEdit"><br>
                    <label for="startEdit"><strong>Start Date</strong></label>
                    <input type="date" name="start" id="startEdit"><br>
                    <label for="endEdit"><strong>End Date</strong></label>
                    <input type="date" name="end" id="endEdit"><br>
                    <label for="reminderEdit"><strong>Reminder Date</strong></label>
                    <input type="date" name="reminder" id="reminderEdit"><br>
                    <label for="tagEdit">Tag</label>
                    <select name="tag" id="tagEdit">
                        <option value="private">Private</option>
                        <option value="public">Public</option>
                    </select><br>
                    <br>
                    <label for="statusEdit">Status</label>
                    <select name="status" id="statusEdit">
                        <option value="Started">Started</option>
                        <option value="Not Started">Not Started</option>
                    </select><br>
                    <label for="descriptionEdit">Description</label>
                    <textarea id="descriptionEdit" name="description" rows="4" cols="50" form="editNoteForm"></textarea><br>
                    <br>
                    <input type="submit" name="submit" style="background-color: green;color: white;" id="editNoteSubmit" onclick="onEditNote()">
                </form>
            </center>
            </div>
            </div>
        <script>
        var notebookId;
        var noteId;
        var noteEditSection = document.getElementsByClassName("noteEdit")[0];
        var editNoteForm = document.getElementById("editNoteForm");
        var addNoteForm = document.getElementById("addNoteForm");
        var notesDisplay = document.getElementsByClassName("notes")[0];
        var notebooksDisplay = document.getElementsByClassName("notebooks")[0];
        var editNotebookForm = document.getElementById("editForm");
        var addNoteSection = document.getElementsByClassName("noteAdd")[0];
        var notebookEditSection = document.getElementsByClassName("notebookEdit")[0];   
        var newNoteBook = document.getElementsByClassName("newNoteBook")[0];
        var notebookCreateSection = document.getElementsByClassName("notebookCreate")[0]; 
        var userEdit = document.getElementsByClassName("userEdit")[0];

        function allNotes(){
            notesDisplay.style.display = "block";
            notebooksDisplay.style.display = "none";
        }
        
        function editNote(Id){
            noteId = Id;
            noteEditSection.style.display = "block";
        }

        function closeNoteEditSection(){
            noteEditSection.style.display = "none";
        }

        function onEditNote(){
            editNoteForm.action = "/editNote/${userId}/"+noteId;
        }

        function addNote(Id){
            notebookId = Id;
            addNoteSection.style.display = "block";
        }

        function closeNoteAddSection(){
            addNoteSection.style.display = "none";
        }
        
        function onAddNote(){
            addNoteForm.action = "/addNote/${userId}/"+notebookId;
        }

        function onEditNotebook(){
            editNotebookForm.action = "/editNotebook/${userId}/"+notebookId;
        }

        function closeNotebookEditSection(){
            notebookEditSection.style.display = "none";
        }
   
        function editNotebook(Id){
            notebookId = Id;
            notebookEditSection.style.display = "block";
        }

        function onCreateNotebook(){
            notebookCreateSection.style.display = "block";
        }

        function closeNotebookCreateSection(){
            newNoteBook.style.display = "none";
            notebookCreateSection.style.display = "none"
        }

        function allNotebooks(){
            newNoteBook.style.display = "block";
            notesDisplay.style.display = "none";
            notebooksDisplay.style.display = "block";
        }

        function onEditUser(){
            userEdit.style.display = "block";
        }

        function closeUserEditSection(){
            userEdit.style.display = "none";
        }

        function openNav() {
            document.getElementById("mySidenav").style.display = "block";
            }

        function closeNav() {
            document.getElementById("mySidenav").style.display = "none";
            }

        window.onclick = function(event) {
            if (event.target == userEdit) {
                userEdit.style.display = "none";
                } 
            if (event.target == notebookCreateSection) {
                notebookCreateSection.style.display = "none";
                }
            if (event.target == notebookEditSection) {
                notebookEditSection.style.display = "none";
                }
            if (event.target == addNoteSection) {
                addNoteSection.style.display = "none";
                } 
            if (event.target == noteEditSection) {
                noteEditSection.style.display = "none";
                }     

            }    

        </script>
    </body>
</html>