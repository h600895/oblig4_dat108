package no.hvl.dat108.partyregister.util;

import no.hvl.dat108.partyregister.model.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepo extends JpaRepository<Attendee, Integer> {
    Attendee findByPhone(String phone);

    //Attendee setAttendee(Attendee attendee);



}
