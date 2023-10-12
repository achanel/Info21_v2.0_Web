function getAllVerterIds(data) {
    let result = [];

    for (const dataKey in data) {
        result.push(data[dataKey].verter_id);
    }

    return result;
}