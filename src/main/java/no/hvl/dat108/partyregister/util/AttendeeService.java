package no.hvl.dat108.partyregister.util;


import no.hvl.dat108.partyregister.model.Attendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendeeService {

    @Autowired
    private AttendeeRepo attendeeRepo;

    public Attendee create(Attendee attendee) {
        return attendeeRepo.save(attendee);
    }



}
