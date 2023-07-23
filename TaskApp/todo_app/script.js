class Task {
  constructor() {
    this.user = {};
    this.tasks = {};
  }
  render() {
    containerTask.innerHTML = "";
    const HTML = this.tasks
      .map(
        (task) => `
        <li data-value="${task.taskId}" class="task-list">
              <input type="checkbox">
                <span>${task.description}</span>
              <button class="noselect btn-delete" ><span class="text" >Delete</span><span class="icon " name="icon" data-value="${task.taskId}"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M24 20.188l-8.315-8.209 8.2-8.282-3.697-3.697-8.212 8.318-8.31-8.203-3.666 3.666 8.321 8.24-8.206 8.313 3.666 3.666 8.237-8.318 8.285 8.203z"></path></svg></span></button>
        </li>
        `
      )
      .join("");
    containerTask.insertAdjacentHTML("beforeend", HTML);
  }
}
const task = new Task();

// Login Functionality

const signUpBtn = document.querySelector(".btn-signup");
const formc = document.querySelector(".formc");
const containerLogin = document.querySelector(".container-login");
const containerRegister = document.querySelector(".container-register");

const containerOverAll = document.querySelector(".overall-container");
const taskContainer = document.querySelector(".con");

signUpBtn.addEventListener("click", (e) => {
  e.preventDefault();
  containerLogin.classList.add("maxim");
  containerRegister.classList.remove("maxim");
});

const getTasks = async (userId) => {
  const respons = await fetch(
    `http://localhost:8080/api/tasks/users/${userId}`
  );

  const data = await respons.json();
  return data;
};

const logEmailURL = "http://localhost:8080/api/users/email/";

const loginAsyncFunc = async (email, password) => {
  const respons = await fetch(`http://localhost:8080/api/users/email/${email}`);

  const data = await respons.json();

  if (password !== data.password) return;
  task.user = data;

  const res = await getTasks(data.userId);

  task.tasks = res;
  console.log(task);
  containerOverAll.classList.add("maxim");
  taskContainer.classList.remove("hidden");
  task.render();
};

// Add new Task
const addTask = async (userId, newTask) => {
  const response = await fetch(
    `http://localhost:8080/api/users/${userId}/tasks`,
    {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
        // Add any other headers you need, such as authorization headers
      },
      body: JSON.stringify(newTask),
    }
  );
  const userTasksNew = await getTasks(userId);
  task.tasks = userTasksNew;
  task.render();
};

// Delete a task
const deleteTask = async (userId, taskId) => {
  console.log(userId, taskId);
  const response = await fetch(`http://localhost:8080/api/tasks/${taskId}`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json", // Adjust the content type based on your server requirements
      // Add any other headers if needed
    },
  });
  const userTasksNew = await getTasks(userId);
  task.tasks = userTasksNew;
  task.render();

  console.log("Deleted");
};

// Login
containerLogin.addEventListener("submit", (event) => {
  event.preventDefault(); // Prevent form submission

  const formData = new FormData(event.target); // Create a new FormData object with the form data

  // Access the values of the email and password inputs from FormData
  const email = formData.get("email");
  const password = formData.get("password");

  // Perform further processing with the email and password values

  loginAsyncFunc(email, password);
  event.target.reset();
});

// Register New User:
const register = async (data) => {
  const response = await fetch(`http://localhost:8080/api/users`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      // Add any other headers you need, such as authorization headers
    },
    body: JSON.stringify(data),
  });

  loginAsyncFunc(data.email, data.password);
};

const form = document.querySelector(".form");
const input = document.querySelector(".input");
const btnAdd = document.querySelector(".btn-add");
// const btnDelete = document.querySelector('.btn-delete');
const containerTask = document.querySelector(".tasks");
const formProductivePanner = document.querySelector(".form-add");
const taskList = document.querySelector(".tasks");

formProductivePanner.addEventListener("submit", (e) => {
  e.preventDefault();
  const formData = new FormData(e.target);
  const description = formData.get("description");
  if (description === "") return;

  console.log(description);
  const newTask = {
    description,
    status: false,
  };
  // console.log(task.user);
  addTask(task.user.userId, newTask);
  e.target.reset();
});

// Delete functionality
taskList.addEventListener("click", (e) => {
  const target = e.target;

  if (target.tagName !== "SPAN") return;

  deleteTask(task.user.userId, target.dataset.value);
});

const formRegister = document.querySelector(".forme");

formRegister.addEventListener("submit", (event) => {
  event.preventDefault(); // Prevent form submission

  const formData = new FormData(event.target); // Create a new FormData object with the form data

  // Access the values of the email and password inputs from FormData
  const username = formData.get("name");
  const email = formData.get("email");
  const password = formData.get("password");

  if (username === "" || email === "" || password === "") return;

  const data = {
    username,
    email,
    password,
  };
  console.log(data);

  // Perform further processing with the email and password values

  event.target.reset();
  register(data);
});
