function getAllTasks(data) {
    let result = [];

    for (const dataKey in data) {
        result.push(data[dataKey].title);
    }

    return result;
}