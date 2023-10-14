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

function extractErrorMessage(message) {
    // return trimFirstPart(trimSecondPart(message));
    return message;
}

function trimFirstPart(message) {
    let targetWord = "ERROR:";

    let indexOfWord = message.indexOf(targetWord);

    if (indexOfWord !== -1) {
        return message.slice(indexOfWord + targetWord.length).trim();
    } else {
        return message;
    }
}

function trimSecondPart(message) {
    let searchString = "Где:";
    const startIndex = message.indexOf(searchString);

    if (startIndex !== -1) {
        return message.substring(0, startIndex);
    } else {
        return message;
    }
}