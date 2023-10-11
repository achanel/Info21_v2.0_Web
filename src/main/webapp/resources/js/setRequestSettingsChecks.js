const paths = {
    save: "http://localhost:8082/data/save_table",
    update: "http://localhost:8082/data/update_table",
    delete: "http://localhost:8082/data/delete_table",
}

function setRequestSettingsChecks(tableName, action, method) {
    document.getElementById('form').addEventListener('submit', function (e) {
        e.preventDefault();

        let formData = new FormData(this);

        let data = "";

        if (action === "delete") {
            data += `"checks_id":${formData.get("checks_id")}`;
        } else {
            data += `"checks_id":${formData.get("checks_id")},`;
            data += `"peer": {"name": "${formData.get("name")}"},`;
            data += `"task": {"title": "${formData.get("title")}"},`;
            data += `"date": "${formData.get("date")}"`;
        }

        data += '}';

        let body = `{"${tableName}":[{${data}]}`;

        let jsonString = JSON.stringify(JSON.parse(body));

        console.log(jsonString);

        let xhr = new XMLHttpRequest();
        xhr.open(method, paths[action], true);
        xhr.setRequestHeader("Content-type", "application/json");
        xhr.send(jsonString);

        location.reload()
    });
}
