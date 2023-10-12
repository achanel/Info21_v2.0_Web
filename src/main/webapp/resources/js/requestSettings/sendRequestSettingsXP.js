const paths = {
    save: "http://localhost:8082/data/save_table",
    update: "http://localhost:8082/data/update_table",
    delete: "http://localhost:8082/data/delete_table",
}


function sendRequestSettingsXP(tableName, action, method) {
    document.getElementById('form').addEventListener('submit', function (e) {
        e.preventDefault();

        let formData = new FormData(this);

        let data = "";

        getTable("checksList")
            .then(result => {
                data += `"check":${getCheckById(result, formData.get("checks_id"))},`;
                data += `"xpamount": ${formData.get("xpamount")}`;

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
            })
            .catch(error => {
                console.error(`Произошла ошибка: ${error.message}`);
            });
    });
}
