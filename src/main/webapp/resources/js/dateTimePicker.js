// function setDateTimePickers(selector) {
//     let dateTimeFields = document.querySelectorAll(selector);
//
//     dateTimeFields.forEach(field => {
//         const paragraph = field.querySelector(".paragraph");
//         // paragraph.textContent = field.textContent;
//         // paragraph.classList.add('paragraph', 'date-time');
//
//         const dateInput = document.createElement("input");
//         const timeInput = document.createElement("input");
//         dateInput.setAttribute('type', 'date');
//         timeInput.setAttribute('type', 'time');
//
//         const date = new Date(field.textContent);
//         let currentDate = date.toISOString().substring(0,10);
//         let currentTime = date.toISOString().substring(11,16);
//         dateInput.value = currentDate;
//         timeInput.value = currentTime;
//         dateInput.classList.add('invisible');
//         timeInput.classList.add('invisible');
//
//         // field.textContent = "";
//
//         // field.appendChild(paragraph);
//         field.appendChild(dateInput);
//         field.appendChild(timeInput);
//
//         field.addEventListener('dblclick', e => {
//             console.log(paragraph)
//             console.log(paragraph.classList)
//             paragraph.classList.toggle('invisible');
//             dateInput.classList.toggle('invisible');
//             timeInput.classList.toggle('invisible');
//
//             paragraph.textContent = dateInput.value + 'T' + timeInput.value;
//         })
//     })
// }
//
