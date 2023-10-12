const paths = {
    save: "http://localhost:8082/data/save_table",
    update: "http://localhost:8082/data/update_table",
    delete: "http://localhost:8082/data/delete_table",
}

function setRequestSettingsTimeTracking(tableName, action, method) {
    document.getElementById('form').addEventListener('submit', function (e) {
        e.preventDefault();

        let formData = new FormData(this);

        let data = "";

        if (action === "delete") {
            data += `"id":${formData.get("id")}`;
        } else {
            data += `"peer": {"name": "${formData.get("peer")}"},`;
            data += `"\`date\`": "${formData.get("\`date\`")}",`;
            data += `"\`time\`": "${formData.get("\`time\`")}",`;
            data += `"state": ${formData.get("state")}`;
        }

        data += '}';

        let body = `{"${tableName}":[{${data}]}`;

        console.log(body);
        let jsonString = JSON.stringify(JSON.parse(body));

        console.log(jsonString);

        let xhr = new XMLHttpRequest();
        xhr.open(method, paths[action], true);
        xhr.setRequestHeader("Content-type", "application/json");
        xhr.send(jsonString);

        // location.reload()
    });
}
