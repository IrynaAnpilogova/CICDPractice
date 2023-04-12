function validateForm() {

    const valid_username = "john doe";
    const valid_password = "demo";

    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var message = document.getElementById("message");
   

    if (username == "" || password == "") {
        message.innerHTML = "Please fill in all fields";
        message.style.color = "red";
        return false;
    }

    if(username == valid_username && password == valid_password) {
        message.innerHTML = "Welcome to the App!";
        message.style.color = "green";
        document.getElementsByTagName("form")[0].style.display = "none";
        document.getElementById("logout").style.display = "block";

        return false;
    } else {
        message.innerHTML = "Please enter correct username and/or password!";
        message.style.color = "red";
        return false;
    }


    
  }
  function logout() {
    document.getElementById("username").value = "";
    document.getElementById("password").value = "";
    document.getElementById("message").innerHTML = "";
    document.getElementsByTagName("form")[0].style.display = "inline-block";
    document.getElementById("logout").style.display = "none";
}