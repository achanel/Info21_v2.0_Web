function setCUDButtons(tableName) {
    const controlBtnContainer = document.querySelector('.control-btn-container');

    const createBtn = document.createElement('a');
    const updateBtn = document.createElement('a');
    const deleteBtn = document.createElement('a');

    createBtn.textContent = 'create';
    createBtn.classList.add('create-btn');
    createBtn.href = `/${tableName}/create`;

    updateBtn.textContent = 'update';
    updateBtn.classList.add('update-btn');
    updateBtn.href = `/${tableName}/update`;

    deleteBtn.textContent = 'delete';
    deleteBtn.classList.add('delete-btn');
    deleteBtn.href = `/${tableName}/delete`;

    controlBtnContainer.appendChild(createBtn);
    controlBtnContainer.appendChild(updateBtn);
    controlBtnContainer.appendChild(deleteBtn);
}
