function getAllpersons() {
    fetch("http://localhost:8080/api/person/persons")

        // Converting received data to JSON
        .then(response => response.json())
        .then(json => {

            // Create a variable to store HTML
            let li = `<tr><th>firstname</th> <th>last name</th> <th>email</th> <th>telefon nummer</th> <th>adresseid</th></tr>`;

            // Loop through each data and add a table row
            json.forEach(person => {
                li += `<tr>
                <td>${person.firstName} </td>
                <td>${person.lastName} </td>
                <td>${person.email}</td>
                <td>${person.phoneNumber}</td>
                <td>${person.idAddress}</td>
            </tr>`;
            });

            // Display result
            document.getElementById("tableid").innerHTML = li;
        });
}

function addPerson(){
    const person = {}
    person.firstName = document.getElementById("firstname").value;
    person.lastName = document.getElementById("lastname").value;
    person.email = document.getElementById("email").value;
    person.phoneNumber = Number(document.getElementById("phone").value);
    person.idAddress = 1;
    console.log(person);
    const url = "http://localhost:8080/api/person"
    const options = {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(person)
    }
    fetch(url, options).then(res => {
        console.log(res)
        return res.json();
    })
}

getAllpersons();
//addPerson();