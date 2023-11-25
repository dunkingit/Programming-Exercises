/*
* Add Events and functions to move the Ship and Win the game
*/
const obstacles = ['pirate', 'iceberg'];
const directions = ['up','right','down', 'left'];
let clock;

// Creates the Grid -- this should only occur after the DOM loads



/*
  Move the Ship 
*/
function moveShipRight() {

}

function moveShipLeft() {

}

function moveShipDown() {

}

function moveShipUp() {

}



function getShipLocation() {
    // Get the return the current location of the ship
 
}





/*
  Win Conditions
*/





/*
    Loss Conditions
*/




/**
 * Reset the Game
 */
function resetGame() {

    
}


/*
    Setup the Game
*/
/**
 * Creates the game grid with 10 rows appended to the element with id = 'main'
 */
function createGrid(){}


/**
 * Builds a grid row made of 10 squares using buildSquare() and sets the class row to it,
 * then appends the created row to frame
 * @param {HTMLElement} frame 
 */
function buildRow(frame) {}



/**
 * Builds the grid squares by creating a div and setting its class to square
 * then appends to the end of the given row
 * @param {HTMLElement} row 
 * @param {int} count 
 */
function buildSquare(row, count) {}




/**
 * Adds random obstacles to a game cell
 * 
 * @param {HTMLElement} cell 
 */
function addObstacles(cell) {
    // remove any existing pirates or icebergs


    const rand = getRandomNumber(100, false);

    if (rand > 85) {
        // Add iceberg here
 
    } else if (rand > 80) {
        // Add pirates here

    } 
}


/*
  Move the Pirates
*/



function getRandomNumber(top, zeroBased) {
    let randNumber = (Math.floor(Math.random() * top) + 1);
    return zeroBased ? randNumber - 1: randNumber;
}
