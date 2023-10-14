function sendRequestSettingsOperations() {
    document.getElementById('form').addEventListener('submit', function (e) {
        e.preventDefault();
        resetErrorMessage();

        let formData = new FormData(this);
        let form = e.target;

        fetch(form.getAttribute('action'), {
            method: form.getAttribute('method'),
            body: formData,
        })
            .then(response => {
                if (!response.ok) {
                    return response.text().then(errorText => {
                        throw new Error('Запрос завершился с ошибкой ' + response.status + ': ' + errorText);
                    });
                }
            })
            .catch((error) => {
                setErrorMessage(extractErrorMessage(error.toString()));
            });
    });
}

