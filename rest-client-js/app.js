let loadBtn = document.getElementById('loadBooks')

loadBtn.addEventListener('click', loadClicked)

function loadClicked() {

  removeAllChildren(document.getElementById('books-container'))

  fetch('http://localhost:8080/api/books') // Fetch the data (GET request)
  .then((response) => response.json()) // Extract the JSON from the Response
  .then((json) => json.forEach((book, idx) => {

    //<tr>
    let row = document.createElement('tr');

    //<td></td><td></td><td></td>
    let titleCol = document.createElement('td')
    let authorCol = document.createElement('td')
    let isbnCol = document.createElement('td')

    // text for columns
    titleCol.textContent = book.title
    authorCol.textContent = book.author.name
    isbnCol.textContent = book.isbn

    //add to row
    row.appendChild(titleCol);
    row.appendChild(authorCol);
    row.appendChild(isbnCol);

    // append the row to the container
    document.
        getElementById('books-container').
        appendChild(row)
  }));
}

function removeAllChildren(parent) {
  while (parent.firstChild) {
    parent.removeChild(parent.firstChild)
  }
}
