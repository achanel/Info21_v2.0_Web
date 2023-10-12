function getAllIds(data, key) {
    let result = [];

    for (const dataItem of data) {
        result.push(dataItem[key]);
    }

    return result;
}