/* copyright 2025 Ahaan Chabba and Peter Benson */
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
  }

  notes.push(text);
  localStorage.setItem("notes", JSON.stringify(notes));

  noteInput.value = "";
  showNotes();
}

function deleteNote(index) {
  let notes = localStorage.getItem("notes");
  if (notes === null) return;

  notes = JSON.parse(notes);
  notes.splice(index, 1); 
  localStorage.setItem("notes", JSON.stringify(notes));

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

    let noteText = document.createElement("span");
    noteText.innerText = notes[i];

    let deleteBtn = document.createElement("button");
    deleteBtn.innerText = "Delete";
    deleteBtn.onclick = () => deleteNote(i);

    noteBox.appendChild(noteText);
    noteBox.appendChild(deleteBtn);

    notesContainer.appendChild(noteBox);
  }
}

showNotes();
