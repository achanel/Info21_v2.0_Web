function getCheckById(data, id) {
    const desiredObject = data.find(item => item.checks_id === id);

    if (desiredObject) {
        console.log(JSON.stringify(desiredObject));
    } else {
        console.log(`Объект с check_id ${id} не найден.`);
    }

}