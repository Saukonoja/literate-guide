$(document).ready(function() {
    $.ajax({
        url: "http://34.206.161.235:8080/getOneRow"
    }).then(function(user) {
       $('.user-username').append(user.username);
       $('.user-firstname').append(user.firstname);
       $('.user-lastname').append(user.lastname);
       $('.user-age').append(user.age);
    });
});