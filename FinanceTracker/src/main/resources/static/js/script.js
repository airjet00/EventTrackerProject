window.addEventListener('load', function(e){
    console.log('script.js loaded');
    init();
});

function init(){
    
    loadFinance();
  
}

function loadFinance() {
    let xhr = new XMLHttpRequest(); 
    xhr.open('GET', 'api/manager');
    xhr.onreadystatechange = function () {
        if(xhr.readyState === 4){
            if(xhr.status === 200){

                let finance = JSON.parse(xhr.responseText);
                displayFinance(finance);
                //displayExpenses
                //displayManager
            }
            else{
                displayError('Error retrieving income' + xhr.status);
            }
            
        }
    }  
    xhr.send();
}


function displayError(msg) {
    let div = document.getElementById('errors');
    let h1 = document.createElement('h1');
    h1.textContent = msg;
    div.appendChild(h1);
}

function displayFinance(finance) {
    let div = document.getElementById('profile');

    // creates <table> and <tbody> elements
    var mytable = document.createElement("table");
    var mytablebody = document.createElement("tbody");

    // creating all cells
    for (const mng of finance) {
        
        // creates a <tr> element
        var currentRow = document.createElement("tr");

        
        // creates a <td> element
        var nameCell = document.createElement("td");
        var usernameCell = document.createElement("td");
        var userPic = document.createElement("td");
        var goal = document.createElement("td");
        var goalAchieved = document.createElement("td");
       
        // creates an image
        var userImg = document.createElement("img");
        userImg.src = mng.profileUrl;
        userImg.height = 125;
        userImg.width = 125;
        userPic.appendChild(userImg);
        
        // creates Text 
        nameCell.textContent =mng.firstName + " " + mng.lastName;
        usernameCell.textContent = mng.username;
        goal.textContent = mng.goal;
        // TODO: if statement to set text to in progress or completed 
        goalAchieved.textContent = mng.goalAchieved;

        // appends the into the cell td
        currentRow.appendChild(userPic);
        currentRow.appendChild(nameCell);
        currentRow.appendChild(usernameCell);
        currentRow.appendChild(goal);
        currentRow.appendChild(goalAchieved);

        // appends the row tr into tbody
        mytablebody.appendChild(currentRow);
    }

    // appends tbody into table
    mytable.appendChild(mytablebody);
    // appends table into body
    div.appendChild(mytable);
    // sets the border attribute of mytable to 2;
    mytable.setAttribute("border","2");
}

//func loadExpenses
// function loadExpenses() {
//     let xhr = new XMLHttpRequest();
//     xhr.open('GET', 'api/expense');
//     xhr.onreadystatechange = function(){
//         if(xhr.readyState === 4){
//             if (xhr.status === 200){
//                 let expense= JSON.parse(xhr.responseText);
//                 displayExpense(expense);
//             }
//             else{
//                 displayError('Error retrieving expense ' + xhr.status);
//             }
//         }
//     }
//     xhr.send();
// }

// //func display expenses
// function displayExpense(expense) {
//     let div = document.getElementById('expensesTable');
//     for (const exp of expense) {
//         let li = document.createElement('li');
//         li.textContent = expense.amount;
//         div.appendChild(li);
//     }
// }

//func displayManager

