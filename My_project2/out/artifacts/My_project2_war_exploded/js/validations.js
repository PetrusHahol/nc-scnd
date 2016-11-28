/**
 * Created by Asus on 25.11.2016.
 */


function validation_signIn() {
    var login = document.getElementsByName("login");
    var password1 = document.getElementsByName("password1");
    var r=/[^A-Z-a-z-0-9]/g;

    if(r.test(login[0].value)){
        alert(" Please enter numbers and characters and don't attach any symbols to login");
        return false;
    }
    return true;
}
function validation_addFlight() {
    var pattern = /^([0-9]{2}).([0-9]{2}).([0-9]{4})$/;
    var r=/[^A-Z-a-z-0-9]/g;
    var from = document.getElementsByName("from");
    var to = document.getElementsByName("to");
    var date = document.getElementsByName("flight_date");
    if(r.test(from[0].value)){
        alert("Please enter numbers and characters and don't attach any symbols for FROM");
        return false;
    }
    if(r.test(to[0].value)){
        alert("Please enter numbers and characters and don't attach any symbols for TO");
        return false;
    }
    if (!pattern.test(date[0].value)){
        alert("date don't match style");
        return false;
    }
    return true;
}
function validation_registration() {
    var login = document.getElementsByName("login");
    var firstName = document.getElementsByName("firstname");
    var secondName = document.getElementsByName("secondname");
    var password1 = document.getElementsByName("password1");
    var password2 = document.getElementsByName("password2");
    var r=/[^A-Z-a-z-0-9]/g;


    if (login[0].value.length < 6 || login[0].value.length > 10) {
        alert("login will be between 6 and 12 characters ");
        return false;
    }
    if(r.test(login[0].value)){
        alert(" Please enter numbers and characters and don't attach any symbols to login");
        return false;
    }
    if(r.test(firstName[0].value)){
        alert(" Please enter numbers and characters and don't attach any symbols to first name");
        return false;
    }
    if(r.test(secondName[0].value)){
        alert(" Please enter numbers and characters and don't attach any symbols second name");
        return false;
    }
    if(r.test(password1[0].value)){
        alert("Please enter numbers and characters and don't attach any symbols to passwords");
        return false;
    }
    if (password1[0].value != password2[0].value) {
        alert("passwords don't match");
        return false;
    }
    if (password1[0].value.length < 6 || password1[0].value.length > 12) {
        alert("password will be between 6 and 12 characters");
        return false;
    }
    return true;
}