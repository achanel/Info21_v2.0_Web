function selectDropDown(data, containerName, inputName) {
    const dropdownContent = document.querySelector(containerName);

    for (const dataKey in data) {
        const a = document.createElement("a");
        a.textContent = data[dataKey];
        a.addEventListener('click', e => {
            document.querySelector(inputName).value = e.target.textContent;
        })

        dropdownContent.appendChild(a);
    }
}