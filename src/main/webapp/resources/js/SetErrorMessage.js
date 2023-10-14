function setErrorMessage(message) {
    let container = document.querySelector(".message-container");
    container.textContent = "";

    const errorElement = document.createElement('p');
    errorElement.textContent = message;
    errorElement.classList.add("error_message");

    container.append(errorElement);
}

function resetErrorMessage() {
    document.querySelector(".message-container").textContent = "";
}