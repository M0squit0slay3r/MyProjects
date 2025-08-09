// Retrieve todo from local storage or initialize an empty array

let todo = JSON.parse(localStorage.getItem("todo")) || []; //JavaScript Object Notation format

const todoInput = document.getElementById("todoInput");

console.log("todoInput");

const todoList = document.getElementById("todoList");
const todoCount = document.getElementById("todoCount");
const addButton = document.querySelector(".btn"); //to target a class
const deleteButton = document.getElementById("deleteButton");

// Initialize

document.addEventListener("DOMContentLoaded", function () {
  addButton.addEventListener("click", addTask);
  todoInput.addEventListener("keydown", function (event) {
    if (event.key === "Enter") {
      event.preventDefault();
      addTask();
    }
  });
  deleteButton.addEventListener("click", deleteAllTasks);
  displayTasks();
});

function addTask() {
  const newTask = todoInput.value.trim();
  if (newTask !== "") {
    todo.push({
      text: newTask,
      disabled: false,
    });
    saveToLocalStorage();
    todoInput.value = "";
    displayTasks();
  }
}
function deleteAllTasks() {
  //some logic
}

function displayTasks() {
    todoList.innerHTML = "";
    todo.forEach(item, index) => {
        const p = document.createElement("p");
        p.innerHTML = `
        <div class="todo-container">
            <input type="checkbox" class="todo-checkbox" id="input-${index}" ${item.disabled ? "checked" : ""}/>
        </div>
        `

    }
}

function saveToLocalStorage() {
  localStorage.setItem("todo", JSON.stringify(todo));
}
