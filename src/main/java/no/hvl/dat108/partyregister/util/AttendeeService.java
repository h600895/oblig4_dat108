package no.hvl.dat108.partyregister.util;


import no.hvl.dat108.partyregister.model.Attendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeService {

    @Autowired
    private AttendeeRepo attendeeRepo;

    public List<Attendee> findAllAttendees() {
        return attendeeRepo.findAll();
    }

    public Attendee findAttendeeWithPhone(int phone) {
        return attendeeRepo.findByPhone(phone);
    }

    public Attendee createAttendee(Attendee attendee) {
        return attendeeRepo.save(attendee);
    }

    public List<Attendee> findAllSortedFirstName() {
        return attendeeRepo.findAll(Sort.by(Sort.Direction.ASC, "firstName").and(Sort.by(Sort.Direction.ASC, "lastName")));
    }



}
