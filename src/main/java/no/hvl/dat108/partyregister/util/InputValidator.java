package no.hvl.dat108.partyregister.util;

public class InputValidator {

    // VALIDERINGSREGLER
    // =================
    // Fornavn: 2-20 tegn, kan inneholde ANY_LETTER, bindestrek og mellomrom. Første tegn STOR BOKSTAV.
    // Etternavn: 2-20 tegn, kan inneholde ANY_LETTER, bindestrek (ikke mellomrom). Første tegn STOR BOKSTAV.
    // Mobil: Eksakt 8 siffer, ingenting annet. Må være unikt (ikke tilhøre en allerede påmeldt deltaker).
    // Passord: Minst 8 tegn, minst et siffer, minst en stor bokstav.
    // Repetert passord: Må være likt passord.
    // Kjønn: Enten M eller K, ingenting annet.

    public static final String FIRST_NAME_VALIDATE = "^[A-ZÆØÅ]{1}[a-zA-ZæøåÆØÅ -]{2,20}";
    public static final String LAST_NAME_VALIDATE = "^[A-ZÆØÅ]{1}[a-zA-ZæøåÆØÅ ]{2,20}";
    public static final String PHONE_VALIDATE = "[0-9]{8}";
    public static final String PASSWORD_VALIDATE = "^(?=.*[a-zæøå!@#$%^&*_=+-])(?=.*[A-ZÆØÅ])(?=.*[0-9]).{8,}$";
    public static final String GENDER_VALIDATE = "[MK]";

    public static boolean isValidFirstName(String firstName){
        return firstName != null && firstName.matches(FIRST_NAME_VALIDATE);
    }

    public static boolean isValidLastName(String lastName){
        return lastName != null && lastName.matches(LAST_NAME_VALIDATE);
    }

    public static boolean isValidPhone(String phone){
        return phone != null && phone.matches(PHONE_VALIDATE);
    }

    public static boolean isEqualPassword(String password, String passwordRep){
        return password != null && password.equals(passwordRep);
    }

    public static boolean isValidPassword(String password){
        return password != null && password.matches(PASSWORD_VALIDATE);
    }

    public static boolean isValidGender(String gender){
        return gender != null && gender.matches(GENDER_VALIDATE);
    }
}






