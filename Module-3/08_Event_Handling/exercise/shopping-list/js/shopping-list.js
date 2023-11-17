let allItemsIncomplete = true;
const pageTitle = 'My Shopping List';
const groceries = [
  { id: 1, name: 'Oatmeal', completed: false },
  { id: 2, name: 'Milk', completed: false },
  { id: 3, name: 'Banana', completed: false },
  { id: 4, name: 'Strawberries', completed: false },
  { id: 5, name: 'Lunch Meat', completed: false },
  { id: 6, name: 'Bread', completed: false },
  { id: 7, name: 'Grapes', completed: false },
  { id: 8, name: 'Steak', completed: false },
  { id: 9, name: 'Salad', completed: false },
  { id: 10, name: 'Tea', completed: false }
];
const btn = document.getElementById("toggleAll")
document.addEventListener('DOMContentLoaded', () => {
  // Set the product reviews page title.
setPageTitle();
// Display all of the grocery items on our page.
displayGroceries()
btn.addEventListener("click", toggleAllIncludingText)
const toggleAnItem = document.getElementsByClassName("shopping-list")[0]
toggleAnItem.addEventListener("click", event => mark(event.target))
toggleAnItem.addEventListener("dblclick", event => unmark(event.target))
});
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById('title');
  title.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.querySelector("ul")
  ul.setAttribute("id", "items")
  let counter = 1;
  for (let item of groceries){
    const newElement = document.createElement("li");
    newElement.setAttribute("class", "item")
    newElement.setAttribute("id", `item-${counter}`)
    newElement.innerText = item.name;
    ul.appendChild(newElement);
  }
}


function toggleAllIncludingText(){
  const toggles = document.getElementById("items")
  let check = toggles.classList.contains("completed")
  let setParentClass = check? unmark(toggles):mark(toggles)
  check? "Mark All Complete":"Mark All Incomplete"
  let setItemClass = check? unmark:mark
  const items = document.getElementsByClassName("item")
  for (const aitem of items){
    setItemClass(aitem)
  }
  btn.innerText = check? "Mark All Complete":"Mark All Incomplete"
}

function mark(item){
  item.classList.add("completed")
}

function unmark(item){
  item.classList.remove("completed")
}
