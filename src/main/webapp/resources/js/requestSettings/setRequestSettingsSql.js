function setRequestSettingsSql() {
    document.getElementById('form').addEventListener('submit', function (e) {
        e.preventDefault();
        resetErrorMessage();

        let formData = new FormData(this);

        fetch('/v1/sql/', {
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

function setTable(data) {
    const table = document.createElement('table');
    table.classList.add('table', 'table-bordered', 'table-striped', 'table-href');
    const thead = document.createElement('thead');
    thead.classList.add('table-dark');
    const tbody = document.createElement('tbody');

    data = data.split("\n");

    for (let i = 0; i < data.length; i++) {
        let items = data[i].split(",");

        if (items.length > 1) {
            const row = document.createElement('tr');
            for (let j = 0; j < items.length; j++) {
                const cell = document.createElement('td');
                cell.textContent = items[j];

                cell.style.padding = "0.55rem"
                row.appendChild(cell);
            }
            tbody.appendChild(row);
        }
    }
    const tableContainer = document.querySelector("#table-container");
    tableContainer.textContent = "";

    table.appendChild(tbody);
    tableContainer.appendChild(table);
}