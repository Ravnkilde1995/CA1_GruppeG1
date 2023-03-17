let d = new Date();
document.body.innerHTML = "<h1>Today's date is " + d + "</h1>"

fetch('person/persons.json')
    .then((response) => {
        if (!response.ok) {
            throw new Error(`HTTP error: ${response.status}`);
        }
        return response.json();
    })
    .then((json) => initialize(json))
    .catch((err) => console.error(`Fetch problem: ${err.message}`));