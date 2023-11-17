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

document.addEventListener('DOMContentLoaded', () => {
  // Set the product reviews page title.
setPageTitle();
// Display all of the grocery items on our page.
displayGroceries()
const toggles = document.getElementById("toggleAll")
toggles.addEventListener("click", toggleAll)
const toggleAnItem = document.getElementsByClassName("shopping-list")[0]
toggleAnItem.addEventListener("click", event => toggleItem(event.target))
toggleAnItem.addEventListener("dblclick", event => unToggleItem(event.target))
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
  const ul = document.getElementsByClassName("shopping-list")[0]
  groceries.forEach((item) => {
    addEleAppendInnerText("li", item.name, ul)
  });
}

function addEleAppendInnerText(ele, text, parent){
  const newElement = document.createElement(ele);
  newElement.setAttribute("class", "items")
  newElement.innerText = text;
  parent.appendChild(newElement);
}


function toggleAll(){
  const items = document.getElementsByClassName("items")
  for (const item of items){
    toggleItem(item)
  }
}

function mark(item){
  item.classList.add("completed")
}

function unmark(item){
  item.classList.remove("completed")
}

function toggleItem(item){
  if(!item.classList.contains("completed")){mark(item)}
}

function unToggleItem(item){
  if(item.classList.contains("completed")){unmark(item)}
}

function toggles(item){
  item.classList.contains("completed")? unmark(item):mark(item)
}
