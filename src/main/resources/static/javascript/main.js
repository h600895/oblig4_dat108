"use strict"

const elementP  = document.getElementById('pword');
const elementPR = document.getElementById("pwordRep");

class FORMController {

    sjekkRepPassord(event) {
        const word = elementPR.value;
        const currentPword = elementP.value;
        const validity = event.target.validity;
        if (word.length > 0 && currentPword === word) {
            elementPR.classList.remove("pwordRepInvalid")
            elementPR.classList.add("pwordMatch")
            event.target.setCustomValidity("")
        } else {
            elementPR.classList.remove("pwordMatch")
            event.target.setCustomValidity("Repetert passord er feil!")
        }
    }

    sjekkPassordStyrke(event) {
        const word = elementP.value;
        const validity = event.target.validity;
        if (validity.valid) {
            if (word.length >= 12) {
                elementP.classList.remove("mediumPassword", "weakPassword")
                elementP.classList.add("strongPassword")// = "strongPassword"
            }
            else if (word.length >= 8) {
                elementP.classList.remove("strongPassword", "weakPassword")
                elementP.classList.add("mediumPassword")// = "mediumPassword"
            }
            else {
                elementP.classList.remove("mediumPassword", "strongPassword");
                elementP.classList.add("weakPassword");


            }
        }
    }
}

function init () {



    const test = new FORMController(elementP, elementPR);

    elementP.addEventListener('keyup', test.sjekkPassordStyrke);
    elementPR.addEventListener('keyup', test.sjekkRepPassord);

    console.log("Running")

}
document.addEventListener('DOMContentLoaded',init);