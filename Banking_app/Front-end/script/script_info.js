"use strict";

// Rough

const url = "http://localhost:8080/api/customers";
//
const btnShow = document.querySelector(".btn--scroll-to");
const btnClose = document.querySelector(".close-btn");

const customerList = document.querySelector(".customer-list");
const header = document.querySelector("header");
const bankingPage = document.querySelector(".app");

// Banking page
const labelBalance = document.querySelector(".balance__value");
const labelDate = document.querySelector(".date");
const navHeading = document.querySelector(".welcome");
let currentAccount;

const renderPage = (customer) => {
  labelBalance.innerHTML = `$${customer.balance}`;
  navHeading.textContent = `welcome back ${customer.firstName} ${customer?.lastName} `;
  currentAccount = customer;
  const locale = navigator.language;
  // Create current date and time
  // console.log(locale);
  const now = new Date();
  const options = {
    hour: "numeric",
    minute: "numeric",
    day: "numeric",
    month: "numeric",
    year: "numeric",
    weekday: "long",
  };

  labelDate.textContent = new Intl.DateTimeFormat(locale, options).format(now);
};
//
btnShow.addEventListener("click", () => {
  header.classList.add("hidden");
  customerList.classList.remove("hidden");
});

btnClose.addEventListener("click", () => {
  header.classList.remove("hidden");
  customerList.classList.add("hidden");
});

const customerInfoList = document.querySelector(".customer-info-list");

const renderPeople = (data) => {
  customerInfoList.innerHTML = "";

  data.forEach((ele) => {
    const li = document.createElement("li");
    li.innerHTML = `

          <div class="customer-info" >
            <h3>${ele.firstName} ${ele?.lastName}</h3>
            <p>Email: ${ele.email}</p>
            </div>
            <button class="btn"data-id=${ele.id}>View</button>

  `;
    customerInfoList.appendChild(li);
  });
};

//
async function getCustomers() {
  try {
    const response = await fetch(url); // Replace with the actual URL of your Spring Boot backend
    if (!response.ok) {
      throw new Error("Request failed with status: " + response.status);
    }
    const data = await response.json();
    // Process the data
    // Example: Display the data in the browser console
    // return data;
    // console.log(data);
    renderPeople(data);

    return data;
  } catch (error) {
    console.error("Error: 🔥🔥", error);
  }
  // return null;
}

getCustomers();
let accounts;
// Adding New Data
async function postData(url, dataPOST) {
  try {
    const response = await fetch(`http://localhost:8080/api/customers`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(dataPOST),
    });

    if (!response.ok) {
      throw new Error("Request failed");
    }

    const responseData = await response.json();
    accounts = responseData;
    return responseData;
  } catch (error) {
    console.error("Error:", error);
    throw error;
  }
}

const findCustomer = async (id) => {
  console.log(id);
  const dataX = await getCustomers();
  console.log(dataX);

  const customer = dataX.find((ele) => ele.id === id);
  console.log(customer);
  // Render in Banking Page
  renderPage(customer);
};

customerInfoList.addEventListener("click", (e) => {
  if (e.target.classList != "btn") {
    return;
  }
  const btn = e.target;
  customerList.classList.add("hidden");
  bankingPage.classList.remove("hidden");

  findCustomer(+btn.dataset.id);
});

// Usage example
// Replace with your Spring Boot endpoint URL
// postData(url, dataPost)
//   .then((responseData) => {
//     console.log("Response:", responseData);
//     // Handle the response data
//   })
//   .catch((error) => {
//     // Handle errors

//   });

const transferMoney = async (name, amt) => {
  const accounts = await getCustomers();
  const reciverAcc = accounts.find(
    (ele) => ele.firstName.toLowerCase() === name.toLowerCase()
  );
  if (!reciverAcc || reciverAcc.balance < amt) {
    alert("something went worng!");
    return;
  }

  reciverAcc.balance += amt;
  currentAccount.balance -= amt;
  postData(url, reciverAcc);
  postData(url, currentAccount);
  renderPage(currentAccount);
  alert("Transfer Successfull.. ");
};

const btnTransfer = document.querySelector(".form__btn--transfer");
const inputTransferTo = document.querySelector(".form__input--to");
const inputTransferAmount = document.querySelector(".form__input--amount");

const btnLoan = document.querySelector(".form__btn--loan");
const inputLoanAmount = document.querySelector(".form__input--loan-amount");

const btnCloseAcc = document.querySelector(".form__btn--close");
const inputCloseUsername = document.querySelector(".form__input--user");
const inputClosePin = document.querySelector(".form__input--pin");

const creditLoan = async (amt) => {
  currentAccount.balance += amt;
  alert("Loan Creideted");
  postData(url, currentAccount);
  renderPage(currentAccount);
};

btnTransfer.addEventListener("click", function (e) {
  e.preventDefault();
  const amount = +inputTransferAmount.value;
  transferMoney(inputTransferTo.value, amount);

  inputTransferAmount.value = inputTransferTo.value = "";
});

btnLoan.addEventListener("click", function (e) {
  e.preventDefault();

  const amount = Math.floor(inputLoanAmount.value);
  creditLoan(amount);
  inputLoanAmount.value = "";
});

const deleteAcc = async (dataPOST) => {
  try {
    const response = await fetch(
      `http://localhost:8080/api/customers/${dataPOST.id}`,
      {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(dataPOST),
      }
    );
    if (!response.ok) {
      throw new Error("Request failed");
    }
    bankingPage.classList.add("hidden");
    header.classList.remove("hidden");
  } catch (error) {
    console.error("Error:", error);
    throw error;
  }
};

btnCloseAcc.addEventListener("click", function (e) {
  e.preventDefault();

  if (
    inputCloseUsername.value.toLowerCase() ===
      currentAccount.firstName.toLowerCase() &&
    +inputClosePin.value === currentAccount.pin
  ) {
    alert("Are you sure?");
    deleteAcc(currentAccount);
  } else {
    alert("Try Again!");
  }
});
