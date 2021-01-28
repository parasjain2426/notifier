<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Notes</title>
        <style>
            .notebookDisplay{
              height: 30vh;
              background-color: #F0F0F0;
              color: black;
              margin-right:3vw;
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
        </style>
    </head>
    <body>
        <h1 style="text-align: center;">Notes</h1>
        <div>
            <p style="text-align: center;color: grey;"><strong>${msg}</strong></p><br>
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
                var noteId;
                var noteEditSection = document.getElementsByClassName("noteEdit")[0];
                var editNoteForm = document.getElementById("editNoteForm");
                function editNote(Id){
                    noteId = Id;
                    noteEditSection.style.display = "block";
                }
                function onEditNote(){
                    editNoteForm.action = "/editNote/${userId}/"+noteId;
                }
                function closeNoteEditSection(){
                    noteEditSection.style.display = "none";
                }
                window.onclick = function(event) {
                    if (event.target == noteEditSection) {
                        noteEditSection.style.display = "none";
                    }     
                }  
            </script>
    </body>
</html>