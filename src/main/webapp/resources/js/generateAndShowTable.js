function getTable(tableName) {
    return new Promise((resolve, reject) => {
        let xhr = new XMLHttpRequest();

        xhr.open('GET', '/data/get_table');

        xhr.responseType = 'json';

        xhr.send();

        xhr.onload = function () {
            let responseObj = xhr.response;

            let result = null;

            for (let key in responseObj) {
                if (responseObj.hasOwnProperty(key)) {
                    if (key === tableName) {
                        result = responseObj[key];
                        break;
                    }
                }
            }

            if (result !== null) {
                resolve(result);
            } else {
                reject(new Error(`Строка с названием ${tableName} не найдена`));
            }
        };

        xhr.onerror = function () {
            reject(new Error("Произошла ошибка при выполнении запроса"));
        };
    });
}

function generateTableFromData(data, isRecursive) {
    const table = document.createElement('table');
    table.classList.add('table', 'table-bordered', 'table-striped', 'table-href');
    const thead = document.createElement('thead');
    thead.classList.add('table-dark');
    const tbody = document.createElement('tbody');
    const headerRow = document.createElement('tr');


    if (!isRecursive) {
        for (const key in data[0]) {
            if (data[0].hasOwnProperty(key)) {
                const th = document.createElement('th');
                th.textContent = key;
                th.setAttribute("data-type", typeof Object.values(data[0])[0]);
                th.classList.add('text-center');
                headerRow.appendChild(th);
            }
        }
    }



    thead.appendChild(headerRow);
    table.appendChild(thead);

    data.forEach(item => {
        const row = document.createElement('tr');
        for (const key in item) {
            if (item.hasOwnProperty(key)) {
                const cell = document.createElement('td');
                if (typeof item[key] === 'object' && item[key] != null) {
                    cell.appendChild(generateTableFromData(Object.entries(item[key]), true));
                } else {
                    cell.textContent = item[key];
                }

                cell.classList.add(key);
                row.appendChild(cell);
            }
        }

        tbody.appendChild(row);
    });

    table.appendChild(tbody);

    return table;
}

function sortTable() {
    let col = document.querySelector("#table-container").querySelector(".table").querySelector(".table-dark").getElementsByTagName("th")[0];

    let type = col.getAttribute("data-type");
    let tbody = document.querySelector("#table-container").querySelector(".table").tBodies[0];
    let rowsArray = Array.from(tbody.rows);
    let compare;

    switch (type) {
        case 'number':
            compare = function(rowA, rowB) {
                return rowA.cells[0].innerHTML - rowB.cells[0].innerHTML;
            };
            break;
        case 'string':
            compare = function(rowA, rowB) {
                return rowA.cells[0].innerHTML > rowB.cells[0].innerHTML ? 1 : -1;
            };
            break;
    }

    rowsArray.sort(compare);

    tbody.append(...rowsArray);
}