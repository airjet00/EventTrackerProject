window.addEventListener('load', function(e){
    console.log('script.js loaded');
    init();
});

function init(){
    loadFinances();

}

function loadFinances() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'api/income');
    xhr.onreadystatechange = function () {
        if(xhr.readyState === 4){
            if(xhr.status === 200){
                let income = JSON.parse(xhr.responseText);
                displayIncome(income);
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

function displayIncome(incomes) {
    let div = document.getElementById('incomeTable');
    for (const income of incomes) {
        let li = document.createElement('li');
        li.textContent = income.total;
        div.appendChild(li);
    }

}