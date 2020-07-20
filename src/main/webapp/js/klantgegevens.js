//POST/toevoegen
$(document).ready(function() {
    var postGegevens = document.getElementById('postGegevens');

    document.querySelector("#postklant").addEventListener("click", function () {
        var formData = new FormData(document.querySelector("#klantgegevensform"));
        var encData = new URLSearchParams(formData.entries());
        var fetchoptions = {
            method: "POST",
            headers: {
                Authorization: 'Bearer ' + window.sessionStorage.getItem("myJWT")
            },
            body: encData
        };
        fetch("rest/klant/toevoegklantgegevens", fetchoptions)
            .then(function (response) {
                if (response.ok) {
                    postGegevens.style.color = "green";
                    postGegevens.innerText = "Toevoegen gelukt!";
                }
                if (response.status === 403) {
                    postGegevens.style.color = "red";
                    postGegevens.innerText = "Log in om deze functie te kunnen gebruiken";
                }
                return response.json();
            })
            .then(myJson => {
                var error = myJson["error"];

                if (error !== undefined) {
                    postGegevens.style.color = "red";
                    postGegevens.style.fontSize = "small";
                    postGegevens.innerText = error;
                }
            })
            .catch(error => console.log(error));
    });
});