package no.hvl.dat108.partyregister;

import no.hvl.dat108.partyregister.controller.RegistrationController;
import no.hvl.dat108.partyregister.model.Attendee;
import no.hvl.dat108.partyregister.util.AttendeeRepo;
import no.hvl.dat108.partyregister.util.AttendeeService;
import no.hvl.dat108.partyregister.util.LoginUtil;
import no.hvl.dat108.partyregister.util.RegistrationUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class LoggInnUtilTest {

    @InjectMocks
    AttendeeService attendeeService;

    @Mock
    AttendeeRepo attendeeRepo;
    HttpServletRequest mockedRequest = Mockito.mock(HttpServletRequest.class);
    HttpSession mockedSession = Mockito.mock(HttpSession.class);

    String password = "TestPass1";
    byte[] salt = RegistrationUtil.getSalt();
    String passwordHash = RegistrationUtil.hashPassword(password, salt);

    Attendee testAttendee = new Attendee("Test", "Testesen", "12345678", passwordHash, salt, "M");

    @Test
    void testLogin() {


        //Check if user is logged in, when not logged in
        assertFalse(LoginUtil.isUserLoggedIn(mockedRequest.getSession()));

        Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
        //Log in user
        LoginUtil.loginUser(mockedRequest, testAttendee);

        //Check if user is logged in, when logged in
        assertTrue(LoginUtil.isUserLoggedIn(mockedRequest.getSession()));
    }

}
