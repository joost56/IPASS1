$(document).ready(function() {
    var meldingInloggen = document.getElementById('meldingLogin');

    document.querySelector("#inloggen").addEventListener("click", function () {
        var formData = new FormData(document.querySelector("#loginform"));
        var encData = new URLSearchParams(formData.entries());


        fetch("rest/authentication", {method: 'POST', body: encData})
            .then(function (response) {
                if (response.ok) {
                    meldingInloggen.style.color = "green";
                    meldingInloggen.innerText = "Inloggen is gelukt!";

                    window.setTimeout(function () {
                        location.href = "hoofdscherm.html";
                    }, 0); //1500
                }

                return response.json();
            })
            .then(myJson => {
                var error = myJson["error"];

                if (error !== undefined) {
                    meldingInloggen.style.color = "red";
                    meldingInloggen.style.fontSize = "small";
                    meldingInloggen.innerText = error;
                } else {
                    window.sessionStorage.setItem("myJWT", myJson.JWT)
                }
            })
            .catch(error => console.log(error));

    });

        $("#loginform").keyup(function (event) {
            if (event.keyCode === 13) {
                $("#inloggen").click();
            }
    });
});