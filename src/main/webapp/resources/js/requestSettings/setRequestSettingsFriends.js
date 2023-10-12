const paths = {
    save: "http://localhost:8082/data/save_table",
    update: "http://localhost:8082/data/update_table",
    delete: "http://localhost:8082/data/delete_table",
}

function setRequestSettingsFriends(tableName, action, method) {
    document.getElementById('form').addEventListener('submit', function (e) {
        e.preventDefault();

        let formData = new FormData(this);

        let data = "";

        if (action === "delete") {
            data += `"friend_id":${formData.get("friend_id")}`;
        } else {
            data += `"peer1": {"name": "${formData.get("peer1")}"},`;
            data += `"peer2": {"name": "${formData.get("peer2")}"}`;
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

