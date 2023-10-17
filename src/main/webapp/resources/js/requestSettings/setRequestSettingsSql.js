function setRequestSettingsSql() {
    document.getElementById('form').addEventListener('submit', function (e) {
        e.preventDefault();
        resetErrorMessage();

        let formData = new FormData(this);

        fetch('/v1/operations/manual', {
            method: 'POST',
            body: formData,
        })
            .then(response => {
                if (!response.ok) {
                    return response.text().then(errorText => {
                        throw new Error('Запрос завершился с ошибкой ' + response.status + ': ' + errorText);
                    });
                }

                return response.text();
            })
            .then(data => {
                if (data) {
                    setTable(data);
                } else {
                    setErrorMessage("No data found");
                }
            })
            .catch((error) => {
                setErrorMessage(extractErrorMessage(error.toString()));
            });
    });
}

function extractErrorMessage(message) {
    let targetWord = "ERROR:";

    let indexOfWord = message.indexOf(targetWord);

    if (indexOfWord !== -1) {
        return message.slice(indexOfWord + targetWord.length).trim();
    } else {
        return message;
    }
}
