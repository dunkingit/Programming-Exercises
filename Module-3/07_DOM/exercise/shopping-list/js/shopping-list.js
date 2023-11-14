// add pageTitle

// add groceries

let pageTitle = 'My Shopping List'

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  document.getElementById('title').innerText = pageTitle
}

let groceries = populateGroceryList()

function populateGroceryList(){
  let temp = []
for(let i = 1; i < 11; i++){
  temp.push(`item ${i}`)
}
return temp}


const currentTable = document.getElementById("groceries")
/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  groceries.forEach((cu)  => addToTable(cu, currentTable))
}

function addToTable(item, tableName){
  const changeItems = document.createElement("li");
  changeItems.innerText = `${item}`;
  tableName.insertAdjacentElement('beforeend', changeItems);
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  let array = document.querySelectorAll("li")
  array.forEach((cu) => cu.setAttribute("class", "completed") )
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
