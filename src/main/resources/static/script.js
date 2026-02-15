function checkBalance() {
    fetch("http://localhost:8080/api/account/balance")
        .then(response => response.json())
        .then(data => {
            document.getElementById("result").innerText =
                "Balance: ₹" + data.balance;
        })
        .catch(error => {
            document.getElementById("result").innerText =
                "Error fetching balance";
        });
}

function depositMoney() {
    let amount = prompt("Enter amount to deposit:");

    fetch("http://localhost:8080/api/account/deposit?amount=" + amount, {
        method: "POST"
    })
    .then(response => response.text())
    .then(data => {
        document.getElementById("result").innerText = data;
    });
}

function withdrawMoney() {
    let amount = prompt("Enter amount to withdraw:");

    fetch("http://localhost:8080/api/account/withdraw?amount=" + amount, {
        method: "POST"
    })
    .then(response => response.text())
    .then(data => {
        document.getElementById("result").innerText = data;
    });
}
