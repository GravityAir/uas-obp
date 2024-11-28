function changeTextButton() {
    var changeBtn = document.getElementById("changeButton");
    if(changeBtn.value == "Click me!") {
        changeBtn.value = "You click me";
        changeBtn.classList.add("green");
        changeBtn.classList.remove("red");
    } else {
        changeBtn.value = "Click me!";
        changeBtn.classList.add("red");
        changeBtn.classList.remove("green");
    }
}

function checkPass() {
    if (document.getElementById('password').value ==
    document.getElementById('cpassword').value) {
    document.getElementById('warning').style.color = 'green';
    document.getElementById('warning').innerHTML = '*matching';
    document.getElementById('warning').style.fontSize = '10pt';
  } else {
    document.getElementById('warning').style.color = 'red';
    document.getElementById('warning').innerHTML = '*not matching';
    document.getElementById('warning').style.fontSize = '10pt';
  }
}