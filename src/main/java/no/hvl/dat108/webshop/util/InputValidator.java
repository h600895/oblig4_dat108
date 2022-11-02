package no.hvl.dat108.webshop.util;

public class InputValidator {

    // VALIDERINGSREGLER
    // =================
    // Fornavn: 2-20 tegn, kan inneholde ANY_LETTER, bindestrek og mellomrom. Første tegn STOR BOKSTAV.
    // Etternavn: 2-20 tegn, kan inneholde ANY_LETTER, bindestrek (ikke mellomrom). Første tegn STOR BOKSTAV.
    // Mobil: Eksakt 8 siffer, ingenting annet. Må være unikt (ikke tilhøre en allerede påmeldt deltaker).
    // Passord: Minst 8 tegn, minst et siffer, minst en stor bokstav.
    // Repetert passord: Må være likt passord.
    // Kjønn: Enten M eller K, ingenting annet.

    public static final String ANY_LETTER = "[a-zA-ZæøåÆØÅ]";
    public static final String ANY_LETTER_OR_DIGIT = "[a-zA-ZæøåÆØÅ0-9]";
    public static final String THREE_OR_MORE_TIMES = "{3,}";

    /**
     * 
     * @param username Brukernavnet som skal valideres
     * @return Om brukenavnet er gyldig eller ikke
     * 
     * Et gyldig brukernavn består av 4 eller flere tegn. Lovlige tegn
     * er bokstaver (små og store) inkl. de norske bokstavene og tall.
     * Brukernavnet kan ikke begynne med et tall.
     */
    public static boolean isValidUsername(String username) {
    	return username != null && username.matches("^" + ANY_LETTER
    			+ ANY_LETTER_OR_DIGIT + THREE_OR_MORE_TIMES + "$");
    }
}






