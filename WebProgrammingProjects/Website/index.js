console.log(`Hello`); /*to output some text*/
console.log(`I like pizza`);

// window.alert(`This is an alert!`);
// window.alert(`i like pizza!`);

document.getElementById(`h1.1`).textContent = "Hello";
document.getElementById(`p.1`).textContent = "I like pizza"

// variable = a container that stores a value
//            behaves as if it were the value it contains. 

// declaration         let x;
// assignment           x = 100;


// x = 123;   // can be written like this --> let x = 123

// use `` in variables especially 

let age = 21;
console.log(`You are ${age} years old.`); //${} sign to insert variable
console.log(typeof age);

// use "" for strings

let firstNamee = "Nesli";
console.log(`My name in short is ${firstNamee}`);

let online = true;

console.log(typeof online);

document.getElementById("p.2").textContent = `You are online? : ${online}`;

// let student = 30;
// augmented assignment operator is a short cut for equation 
// student *= 2; 
// console.log(students); --->60
// students++; increment operater increases by 1 


//how to accept user input
// easy way = window prompt
// professional way 

//easy way;
// let username;
// username = window.prompt("What's your username?");
// console.log(username);

//professional way 
let username;

document.getElementById("mySubmit").onclick = function(){
    username = document.getElementById("myText").value;
    document.getElementById("myH1").textContent=`Hello ${username}`

}

//type conversition

 let x = "0";
 let y= "0";
 let z = "0";

 x = Number(x);
 y = String(y);
 z = Boolean(z);

 console.log(x,typeof x);
 console.log(y,typeof y);
 console.log(z,typeof z);

// to create an unchangable variable = constrant  type const PI = 3.14 for ex.

const PI = 3.14
let radius;
let circumference;

document.getElementById("mySubmit2").onclick = function(){
    radius = document.getElementById("myText1").value;
    radius = Number(radius);
    circumference = 2 * PI * radius;
    document.getElementById("myH3").textContent = circumference + "cm";

}

const decreaseBtn = document.getElementById("decreaseBtn");
const increaseBtn = document.getElementById("increaseBtn");
const resetBtn = document.getElementById("resetBtn");
const countLabel = document.getElementById("countLabel");

let count = 0;

increaseBtn.onclick = function(){
    count++;
    countLabel.textContent = count;
}

decreaseBtn.onclick = function(){
    count--;
    countLabel.textContent = count;
}

resetBtn.onclick = function(){
    count = 0;
    countLabel.textContent = count;
}

// Math 
// Math.E ,Math.PI ,Math.round() ,Math.floor() ,Math.ceil() ,Math.trunc( ) ,Math.pow(x,y) ,Math.sqrt() ,Math.max(x,y,z)
//Math.random() --> generates a number between 0-1 , 1 exclusive

//RANDOM # GENERATOR

// const min = 50;
// const max = 100;

// let randomNum = Math.floow(Math.random() * (max-min  +1)) + min;

// let randomNum = Math.floor(Math.random() * 6) +1 ; 

// console.log(randomNum);

const rollBtn = document.getElementById("rollBtn");

const myLabel = document.getElementById("myLabel");

const min = 1;
const max = 6;

let randomNumber;

rollBtn.onclick = function(){
    randomNumber = Math.floor(Math.random() * max) + min;
    myLabel.textContent = randomNumber;
}

// if statements 

let  = 24;

if(age >= 18){
    console.log("You are old enough to enter ig");

}
else{
    console.log("You are NOT old enough to enter go away");

}

let time = 9;

if(time <= 12){
    console.log("Good Morning")
}
else{
    console.log("Good Afternoon")
}
  
// else if 

// .checked = property that determines the checked 
// state of an HTML checkbox or radio button element

// ternary operator = shortcut to if{} and else{} statements
// condition ? codeIfTrue : codeIfFalse;

let agee = 21;

let message = age >= 18 ? "You are an adult" :  "You are minor";

// switch = can be an efficient replacement to many else if statements

let day = 1;

switch(day){
    case 1:
        console.log("It is Monday");
        break;
    case 2:
        console.log("It is Tuesday");
        break;
    default:
        console.log(`${day} is not a day`)
}

let testScore = 92;
let letterGrade;

switch(true){
    case testScore >= 90:
        letterGrade = `A`;
        break;
    case testScore >= 80:
        letterGrade = `B`;
        breake;
}

console.log(letterGrade);

// String Methods ----------- 

let userName =`MosquitoSlayer`;

userName.charAt(0);

console.log(userName.trim("o"));

// userName.indexOf("o")  
// userName.lastIndexOf("o")
// .length
// .trim() trims white space 
// .toUpperCase()
// .toLowerCase()
// .repeat()
// .startsWith()
// .endsWith()
// .includes() for example (" ") empty space
// .replaceAll() for example ("-","")
//.padStart() for example (15,"0")
//padding string w/ 0 till its 15 charachters long
// .padEnd()


// String Slicing 

const fullName = "Neslihan Sahin"

// let firstName = fullName.slice(0,8);

// let lastChar = fullName.slice(-1);

// console.log(firstName);

let firstName = fullName.slice(0, fullName.indexOf(" "));
// boslugun oldugu indexi alicak yani bu da fullname sonu oluyor otomatik

console.log(firstName);

const email = "Bro1@gmail.com"

let username_ = email.slice(0, email.indexOf("@"));
let extension = email.slice(email.indexOf("@") + 1);

console.log(username);
console.log(extension);

//Method Chaining

// without method chaining 

let user = window.prompt(`Enter your username: `);

// user = user.trim();
// let letter = user.charAt(0);
// letter = letter.toUpperCase(); 

// let extraChars = user.slice(1);
// extraChars = extraChars.toLowerCase();
// username = letter + extraChars;

// console.log(user);

// with method chaining

user = user.trim().charAt(0).toUpperCase() + user.trim().slice(1).toLowerCase(),

console.log(user);

// logical operators 
// && AND ; || OR , ! NOT

const temp = 20;

if(temp > 0 && temp <=30){
    console.log("The weather is Good!");
}

// = assignment operator
// == comparison operator
// === strict equality operator (values and their datatype is equal)
// != inequality operator
// !== strict inequality operator  


// repeat some code while some condition is true 

let usernamee;

do{
    usernamee = window.prompt(`Enter your name`);
}
while(usernamee === "" || usernamee === null)

console.log(`Hello ${usernamee}`);

// while loop = repeat some code while some condition is true

let isim = "";

while (isim === ""){
    console.log(`You didnt enter your name`);
}
