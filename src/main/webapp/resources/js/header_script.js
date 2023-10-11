function createHeader(title) {
    const element = document.querySelector("header");
    element.innerHTML =
    `
    <div class="row1">
        <div class="logo">
            <a href="/">
                <img alt="" height="88px" src="/resources/img/welcome_page_logo.png" width="94px">
            </a>
        </div>
        <div class="header_text header_title">${title}</div>
    </div>
    
    <div class="row2">
        <div class="column_item">
            <div class="dropdown">
              <button class="dropbtn create-btn">Data</button>
              <div class="dropdown-content">
                <a class="header_text" href="/peers/read">Peers</a>
                <a class="header_text" href="/tasks/read">Tasks</a>
                <a class="header_text" href="/checks/read">Checks</a>
                <a class="header_text" href="/verter/read">Verter</a>
                <a class="header_text" href="/experiences/read">XP</a>
                <a class="header_text" href="/p2p/read">P2P</a>
                <a class="header_text" href="/transferredPoints/read">TransferredPoints</a>
                <a class="header_text" href="/friends/read">Friends</a>
                <a class="header_text" href="/recommendations/read">Recommendations</a>
                <a class="header_text" href="/timeTracking/read">TimeTracking</a>
              </div>
            </div>
        </div>
        <div class="column_item">
            <div class="dropdown">
              <button class="dropbtn create-btn">Operations</button>
              <div class="dropdown-content">
                <a class="header_text" href="/v1/operations/">Procedures</a>
                <a class="header_text" href="/v1/operations/query">Execute query</a>
              </div>
            </div>
        </div>
    </div>
    `;

    document.querySelectorAll(".dropbtn").forEach(button => {
        button.addEventListener('click', e => {
            button.parentNode.children[1].classList.toggle("show");
        })
    })

    window.onclick = function(event) {
        if (!event.target.matches('.dropbtn')) {
            const dropdowns = document.getElementsByClassName("dropdown-content");
            for (let i = 0; i < dropdowns.length; i++) {
                const openDropdown = dropdowns[i];
                if (openDropdown.classList.contains('show')) {
                    openDropdown.classList.remove('show');
                }
            }
        }
    }
}