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
    $('#saveprocesses').on("click", function(e) {

        var processes = {
            "getProduct" : $('#getProduct').is(':checked') ? 1 : 0,
            "setProduct" : $('#setProduct').is(':checked') ? 1 : 0,
            "getCustomer" : $('#getCustomer').is(':checked') ? 1 : 0,
            "setCustomer" : $('#setCustomer').is(':checked') ? 1 : 0,
            "getOrder" : $('#getOrder').is(':checked') ? 1 : 0,
            "setOrder" : $('#setOrder').is(':checked') ? 1 : 0,
            "setProductCategories" : $('#setProductCategories').is(':checked') ? 1 : 0,
            "setStock" : $('#setStock').is(':checked') ? 1 : 0,
            "apiKey" : $('#apiKey').val()
        }

        $.ajax({
            url: '/update',
            method: "post",
            contentType: "application/json",
            data: JSON.stringify(processes),
            success: function(){
                addSuccess('Sikeresen módosítva!', 'user-added');
                $('.alert-success').show();
                $('.alert-success').delay(1500).fadeOut('slow');
                setTimeout(function () {
                    window.location.href = "/users";
                }, 2000);
            }
        })
    })
})

$(document).ready(function () {
    $('#storeuser').on("click", function(e) {
        if(isInputFilled()){
                $.ajax({
                    url: '/adduser',
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
            url: '/delete',
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

$(document).ready(function () {
    $('.removewebshop').on("click", function(e) {
        let webshopid = e.target.name;
        let webIdentifier = e.target.id;
        let apiKey = e.tartget.attributes.getNamedItem("data-apiKey").value 
        console.log(apiKey);

        $.ajax({
            url: '/deletewebshop',
            method: "POST",
            data: {webshopId: webshopid,
                    apiKey : apiKey},
            success: function () {
                addSuccess('Webshop eltávolítva!', 'user-removed');
                $('.alert-success').show();
                $('.alert-success').delay(1500).fadeOut('slow');
                setTimeout(function () {
                    $('#user-removed').remove();
                }, 2000);
                setTimeout(function () {
                    window.location.replace("/user/" + webIdentifier);
                }, 2500);
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
    })
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