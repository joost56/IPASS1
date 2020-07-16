//POST/toevoegen
$(document).ready(function() {
    var postUren = document.getElementById('postUren');

    document.querySelector("#post").addEventListener("click", function () {
        var formData = new FormData(document.querySelector("#POSTurenform"));
        var encData = new URLSearchParams(formData.entries());
        var fetchoptions = {
            method: "POST",
            headers: {
                Authorization: 'Bearer ' + window.sessionStorage.getItem("myJWT")
            },
            body: encData
        };
        fetch("rest/uren/toevoegen", fetchoptions)
            .then(function (response) {
                if (response.ok) {
                    postUren.style.color = "green";
                    postUren.innerText = "Toevoegen gelukt!";
                }
                if (response.status === 403) {
                    postUren.style.color = "red";
                    postUren.innerText = "Log in om deze functie te kunnen gebruiken";
                }
                return response.json();
            })
            .then(myJson => {
                var error = myJson["error"];

                if (error !== undefined) {
                    postUren.style.color = "red";
                    postUren.style.fontSize = "small";
                    postUren.innerText = error;
                }
            })
            .catch(error => console.log(error));
    });
});

//PUT/wijzigen
$(document).ready(function() {
    var putUur = document.getElementById('putUur');

    document.querySelector("#put").addEventListener("click", function () {
        var formData = new FormData(document.querySelector("#PUTurenform"));
        var encData = new URLSearchParams(formData.entries());
        var fetchoptions = {
            method: 'PUT',
            headers: {
                'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
            },
            body: encData
        };
        fetch("rest/uur/wijzigen", fetchoptions)
            .then(function (response) {
                if (response.ok) {
                    putUur.style.color = "green";
                    putUur.innerText = "Wijzigen gelukt!";
                }
                if (response.status === 403) {
                    putUur.style.color = "red";
                    putUur.innerText = "Log in om deze functie te kunnen gebruiken";
                }

                return response.json();
            })
            .then(myJson => {
                var error = myJson["error"];

                if (error !== undefined) {
                    putUur.style.color = "red";
                    putUur.style.fontSize = "small";
                    putUur.innerText = error;
                }
            })
            .catch(error => console.log(error));
    });
});

//DELETE/verwijderen
$(document).ready(function() {
    var deleteUur = document.getElementById('deleteUur');

    document.querySelector("#delete").addEventListener("click", function () {
        var formData = new FormData(document.querySelector("#DELETEurenform"));
        var encData = new URLSearchParams(formData.entries());
        var fetchoptions = {
            method: 'DELETE',
            headers: {
                'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
            },body:encData
        };

        fetch("rest/uur/verwijderen", fetchoptions)
            .then(function (response) {
                if (response.ok) {
                    deleteUur.style.color = "green";
                    console.log("Verwijderen gelukt!");
                    deleteUur.innerText = "Verwijderen gelukt!";
                }
                if (response.status === 403) {
                    deleteUur.style.color = "red";
                    deleteUur.innerText = "Log in om deze functie te kunnen gebruiken";
                }
                if (response.status === 404) {
                    deleteUur.style.color = "red";
                    deleteUur.innerText = "Log in om deze functie te kunnen gebruiken";
                    console.log("Uur niet gevonden")
                }
                return response.json();
            })
            .then(myJson => {
                var error = myJson["error"];

                if (error !== undefined) {
                    deleteUur.style.color = "red";
                    deleteUur.style.fontSize = "small";
                    deleteUur.innerText = error;
                }
            })
            .catch(error => console.log(error));
    });
});


// document.querySelector("#delete").addEventListener("click", function () {
//     var id = document.querySelector("#deleteid").value;
//
//     fetch("rest/uur/" + id, {method: 'DELETE'})
//         .then(function (response) {
//             if (response.ok) console.log("Uur verwijderd");
//             else if (response.status == 404) console.log("Uur niet gevonden")
//             else console.log("Er gebeurde iets raars")
//         });
// });



// function f() {
//     let omschrijvingJson = myJson.omschrijving;
//     let urenJson = myJson.uren;
//     console.log(omschrijvingJson);
//     console.log(urenJson);
// }
// document.getElementById("pakketje").innerHTML=f();

//voor de word file
//     function Export2Doc(element, filename = '') {
//         var preHtml = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:w='urn:schemas-microsoft-com:office:word' xmlns='http://www.w3.org/TR/REC-html40'><head><meta charset='utf-8'><title>Export HTML To Doc</title></head><body>";
//         var postHtml = "</body></html>";
//         var html = preHtml + document.getElementById(element).innerHTML + postHtml;
//         var blob = new Blob(['\ufeff', html], {
//             type: 'appliaction/msword'
//         });
//         var url = 'data:application/vnd.ms-word;charset=utf-8,' + encodeURIComponent(html);
//         filename = filename ? filename + '.doc' : 'document.doc';
//         var downloadLink = document.createElement("a");
//         document.body.appendChild(downloadLink);
//         if (navigator.msSaveOrOpenBlob) {
//             navigator.msSaveOrOpenBlob(blob, filename);
//         } else {
//             downloadLink.href = url;
//             downloadLink.download = filename;
//             downloadLink.click();
//         }
//         document.body.removeChild(downloadLink);
//     }
//
//     uitloggenButton = document.getElementById("uitloggen");
//
//     uitloggenButton.onclick = function () {
//         if (window.sessionStorage.getItem("myJWT") !== null) {
//             window.sessionStorage.removeItem("myJWT");
//         }
//   };

// }

