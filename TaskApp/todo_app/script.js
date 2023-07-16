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
        <li>
              <input type="checkbox">
                <span>${task.description}</span>
              <button class="noselect btn-delete" data-value="${task.taskId}"><span class="text">Delete</span><span class="icon"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M24 20.188l-8.315-8.209 8.2-8.282-3.697-3.697-8.212 8.318-8.31-8.203-3.666 3.666 8.321 8.24-8.206 8.313 3.666 3.666 8.237-8.318 8.285 8.203z"></path></svg></span></button>
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

const getTasks = async (user) => {
  const respons = await fetch(
    `http://localhost:8080/api/tasks/users/${user.userId}`
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

  const res = await getTasks(data);

  task.tasks = res;
  console.log(task);
  containerOverAll.classList.add("maxim");
  taskContainer.classList.remove("hidden");
  task.render();
};

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

const form = document.querySelector(".form");
const input = document.querySelector(".input");
const btnAdd = document.querySelector(".btn-add");
// const btnDelete = document.querySelector('.btn-delete');
const containerTask = document.querySelector(".tasks");

form.addEventListener("submit", function (e) {
  e.preventDefault();

  form.reset();
});

btnAdd.addEventListener("click", function (e) {
  form.reset();
});

containerTask.addEventListener("click", function (e) {
  const btn = e.target.closest(".btn-delete");
  if (!btn) return;
});
