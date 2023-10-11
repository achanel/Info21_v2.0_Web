function getPeerNames(data) {
    let result = [];

    for (const dataKey in data) {
        result.push(data[dataKey].name);
    }

    return result;
}