window.onload = function () {
    let userLoggedIn = /*[[${user != null}]]*/ false;

    if (userLoggedIn) {
        document.getElementById("Create").style.display = "inline";
        document.getElementById("Edit").style.display = "inline";
        document.getElementById("Delete").style.display = "inline";
    } else {
        document.getElementById("loginForm").style.display = "inline";
    }

    document.getElementById("Create").onclick = function () {
        window.location.href = "/CreatePost";
    }

    document.getElementById("Edit").onclick = function () {
        window.location.href = "/EditPost";
    }

    document.getElementById("Delete").onclick = function () {
        window.location.href = "/deletePost";
    }
}

// TODO onload가 아닌 event listener로 수정
