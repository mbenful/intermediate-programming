
let noteInput = document.getElementById("noteInput");
let notesContainer = document.getElementById("notesContainer");


function saveNote() {

  let text = noteInput.value;


  if (text === "") return;


  let notes = localStorage.getItem("notes");
  if (notes === null) {
    notes = []; 
  } else {
    notes = JSON.parse(notes); 


  notes.push(text);


  localStorage.setItem("notes", JSON.stringify(notes));


  noteInput.value = "";


  showNotes();
}


function showNotes() {
  
  notesContainer.innerHTML = "";


  let notes = localStorage.getItem("notes");
  if (notes === null) {
    notes = [];
  } else {
    notes = JSON.parse(notes);
  }


  for (let i = 0; i < notes.length; i++) {
    let noteBox = document.createElement("div");
    noteBox.className = "note";
    noteBox.innerText = notes[i];
    notesContainer.appendChild(noteBox);
  }
}


showNotes();
}