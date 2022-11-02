package no.hvl.dat108.webshop.util;

import no.hvl.dat108.webshop.model.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepo extends JpaRepository<Attendee, Integer> {

    Attendee findByPhone(int phone);

    Attendee setAttendee(Attendee attendee);



}
