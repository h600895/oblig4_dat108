"use strict"

document.getElementsByName("pword")[0].addEventListener('input', sjekkPassordStyrke);

function sjekkPassordStyrke(oninput) {
    const validity = oninput.target.validity;

    if (validity.valid) {
       if( validity.length >=12) {
           return validity;
       }else{
           return mediumPassword;
       }
    }
}