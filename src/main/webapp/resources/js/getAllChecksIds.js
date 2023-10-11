function getAllChecksIds(data) {
    let result = [];

    for (const dataKey in data) {
        result.push(data[dataKey].checks_id);
    }

    return result;
}