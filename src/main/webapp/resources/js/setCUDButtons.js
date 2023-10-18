function setCUDButtons(tableName) {
    const controlBtnContainer = document.querySelector('.control-btn-container');

    const createBtn = document.createElement('a');
    const updateBtn = document.createElement('a');
    const deleteBtn = document.createElement('a');
    const exportToCsvBtn = document.createElement('a');
    const importToCsvBtn = document.createElement('a');

    createBtn.textContent = 'create';
    createBtn.classList.add('create-btn');
    createBtn.href = `/${tableName}/create`;

    updateBtn.textContent = 'update';
    updateBtn.classList.add('update-btn');
    updateBtn.href = `/${tableName}/update`;

    deleteBtn.textContent = 'delete';
    deleteBtn.classList.add('delete-btn');
    deleteBtn.href = `/${tableName}/delete`;

    exportToCsvBtn.textContent = 'export csv';
    exportToCsvBtn.classList.add('export-btn');

    importToCsvBtn.textContent = 'import csv';
    importToCsvBtn.classList.add('export-btn');

    controlBtnContainer.appendChild(createBtn);
    controlBtnContainer.appendChild(updateBtn);
    controlBtnContainer.appendChild(deleteBtn);
    controlBtnContainer.appendChild(importToCsvBtn);
    controlBtnContainer.appendChild(exportToCsvBtn);


    exportToCsvBtn.addEventListener('click', function (e) {
        let xhr = new XMLHttpRequest();
        xhr.open("POST", `http://localhost:8082/${tableName}/export`, true);
        xhr.setRequestHeader("Content-type", "application/json");
        xhr.send();
    });

    importToCsvBtn.addEventListener('click', function (e) {
        let xhr = new XMLHttpRequest();
        xhr.open("GET", `http://localhost:8082/${tableName}/import`, true);
        xhr.setRequestHeader("Content-type", "application/json");
        xhr.send();
    });
}
