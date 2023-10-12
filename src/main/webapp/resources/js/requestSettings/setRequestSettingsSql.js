function setRequestSettingsSql() {
    document.getElementById('form').addEventListener('submit', function (e) {
        e.preventDefault();

        let formData = new FormData(this);

        sendRequest(formData.get("query"))
            .then(result => {
                console.log(result);
            })
    });
}

function sendRequest(data) {
    return new Promise((resolve, reject) => {
        let xhr = new XMLHttpRequest();
        xhr.open("POST", "http://localhost:8082/v1/sql/", true);
        xhr.responseType = 'text';
        xhr.setRequestHeader("Content-type", "text/html");
        xhr.send(data);

        xhr.onload = function () {
            let responseObj = xhr.response;

            if (responseObj !== null) {
                resolve(responseObj);
            } else {
                reject(new Error(`Ошибка`));
            }
        };

        xhr.onerror = function () {
            reject(new Error("Произошла ошибка при выполнении запроса"));
        };
    })
}