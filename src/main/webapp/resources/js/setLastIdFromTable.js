function setLastIdFromTable(data) {
    let arr = [];

    for (const dataKey in data) {
        arr.push(Object.values(data[dataKey])[0]);
    }

    arr = arr.sort((a, b) => {
        return a - b
    })

    document.querySelector("#last_id").value = arr[arr.length - 1] + 1;
}