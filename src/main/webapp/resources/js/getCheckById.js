function getCheckById(data, id) {
    return JSON.stringify(data.find(item => item.checks_id == id));
}