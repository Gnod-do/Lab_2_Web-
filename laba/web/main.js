let selectedCheckbox;
document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("button").addEventListener("click", submit);
});

let submit = function (e) {
    if (!checkY()) {
        e.preventDefault();
    }
}

function checkY() {
    let y = document.getElementById("y");
    let checkError = document.querySelector(".check-error");
    if (y.value.trim() === "") {
        checkError.style.display = "block";
        checkError.textContent = "You need fill this field";
        return false;
    } else if (!isFinite(y.value.replace(',', '.'))) {
        checkError.style.display = "block";
        checkError.textContent = "Y must be number";
        return false;
    } else if (y.value.replace(',', '.') >= 3 || y.value.replace(',', '.') <= -5) {
        checkError.style.display = "block";
        checkError.textContent = "Y must be in range (-5,3)";
        return false;
    } else {
        return true;
    }
}


function checkX() {
    return selectedCheckbox !== undefined;
}

function changeX(element) {
    if (element.checked) {
        if (selectedCheckbox !== undefined) {
            selectedCheckbox.checked = false;
        }
        selectedCheckbox = element;
    } else {
        selectedCheckbox = undefined;
    }
}

function setX(x, id) {
    document.querySelector("#x").value = x;
    document.querySelector(`#${id}`).style.backgroundColor = "red";
    console.log(document.querySelector("#x").value);
}