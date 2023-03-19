fetch("http://localhost:8080/api/person/persons")

    // Converting received data to JSON
    .then(response => response.json())
    .then(json => {

        // Create a variable to store HTML
        let li = `<tr> <th> firstname </th> <th> lastname </th></tr>`;

        // Loop through each data and add a table row
        json.forEach(person => {

            li += `<tr>
                        <td>${person.firstName} </td>
                        <td>${person.lastName}</td>
                        <td>${person.email}</td>
                        <td>${person.phoneNumber}</td>
                        <td>${person.idAddress}</td>
                    </tr>`;
        });

        // Display result
        document.getElementById("persons").innerHTML = li;
    });


function addPerson() {
    const person = {
        firstName: document.getElementById("firstName").value,
        lastName: document.getElementById("lastName").value,
        email: document.getElementById("email").value,
        phoneNumber: document.getElementById("phoneNumber").value,
        address: document.getElementById("address").value,
    }

    const url = "http://localhost:8080/api/person";
    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(person)
    }

    fetch(url, options)
        .then(res => res.json())
        .then(data => console.log(data))
        .catch(err => console.log(err))
}


