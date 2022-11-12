"use strict"

const elementP  = document.getElementById('pword');

class FORMController {

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




    const test = new FORMController(elementP);

    elementP.addEventListener('keyup', test.sjekkPassordStyrke);

    console.log("Running")

}
document.addEventListener('DOMContentLoaded',init);