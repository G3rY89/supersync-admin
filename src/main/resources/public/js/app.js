$('#user-added').hide();
$('#user-not-added').hide();
$('#error').hide();
$('#user-removed').hide();

var checkTable = function(){
    if(document.getElementById("userstable").rows.length == 1){
        document.getElementById("user-table").innerText = "No enrolled users"
    }
}

$(document).ready(function () {
    $('#storeuser').on("click", function(e) {
        if(isInputFilled()){
                $.ajax({
                    url: 'http://localhost:8888/adduser',
                    method: "post",
                    data: {webIdentifier: document.getElementById("webIdentidfier").value,
                    webPassword: document.getElementById("webPassword").value},
                    success: function () {
                        addSuccess('Sikeresen hozzáadva!', 'user-added');
                        $('.alert-success').show();
                        $('.alert-success').delay(1500).fadeOut('slow');
                        setTimeout(function () {
                            $('#user-added').remove();
                        }, 2000);
                        $(':input').val('');
                    },
                    error: function (text) {
                        console.log(text);
                        if(text.status == 500){
                            addError('Ez már egy hozzáadott felhasználó!', 'user-not-added');
                            $('.alert').show();
                            $('.alert').delay(1500).fadeOut('slow');
                            setTimeout(function () {
                                $('#user-not-added').remove();
                            }, 2000);
                        } else {
                            addError('Something went wrong!', 'error');
                            $('.alert').show();
                            $('.alert').delay(1500).fadeOut('slow');
                            setTimeout(function () {
                                $('#error').remove();
                            }, 2000);
                        }

                    }
                });
        } else {
            addError('WebAzonosító és WebJelszó megadása is kötelező!', 'error');
            $('.alert').show();
            $('.alert').delay(1500).fadeOut('slow');
            setTimeout(function () {
                $('#error').remove();
            }, 2000);
        }
    });
});

$(document).ready(function () {
    $('.removeuser').on("click", function(e) {
        let userid = e.target.name;
        $.ajax({
            url: 'http://localhost:8888/delete',
            method: "POST",
            data: {userid: userid},
            success: function () {
                addSuccess('Felhasználó eltávolítva!', 'user-removed');
                $('.alert-success').show();
                $('.alert-success').delay(1500).fadeOut('slow');
                setTimeout(function () {
                    $('#user-removed').remove();
                }, 2000);
                $('#table' + userid).remove();
                checkTable();
            },
            error: function () {
                addError('Hiba!', 'error');
                $('.alert').show();
                $('.alert').delay(1500).fadeOut('slow');
                setTimeout(function () {
                    $('#error').remove();
                }, 2000);
            }
        });
    });
});

checkTable();

function addSuccess(message, divId) {
    var div = document.createElement('div');

    div.className = 'alert alert-success';
    div.id = divId;

    div.innerHTML =
        '<strong>' + message +'</strong>';

    document.getElementById('popup-container').appendChild(div);
}

function addError(message, divId) {
    var div = document.createElement('div');

    div.className = 'alert alert-danger';
    div.id = divId;

    div.innerHTML =
        '<strong>' + message + '</strong>';

    document.getElementById('popup-container').appendChild(div);
}

function isInputFilled(){
    if(document.getElementById("webIdentidfier").value === "" || document.getElementById("webPassword").value === ""){
        return false;
    }
    return true;
}

function validateEmail(email){
    var re = /\S+@\S+\.\S+/;
    return re.test(email);
}