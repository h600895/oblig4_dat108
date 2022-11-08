package no.hvl.dat108.partyregister;

import no.hvl.dat108.partyregister.model.Attendee;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;

public class LoggInnUtilTest {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();



    private boolean hasValid(String fieldname, Attendee attendee) {
        List<String> invalidField = validator.validate(attendee).stream()
                .map(v -> v.getPropertyPath().toString())
                .toList();

        return !invalidField.contains(fieldname);
    }

}
