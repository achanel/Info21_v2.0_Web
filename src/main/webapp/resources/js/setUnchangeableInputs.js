function setUnchangeableInputs(...selectors) {
    for (const selector of selectors) {
        document.querySelector(selector).addEventListener("keydown", function (e) {
            e.preventDefault();
        });
    }
}