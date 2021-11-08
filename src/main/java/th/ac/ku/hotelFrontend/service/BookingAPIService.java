package th.ac.ku.hotelFrontend.service;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class BookingAPIService {

    private RestTemplate restTemplate;


    public BookingAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Booking> getCustomerBookingAll(){
        ResponseEntity<Booking[]> response =
                restTemplate.getForEntity("http://localhost:8090/booking", Booking[].class);
        Booking[] bookings = response.getBody();
        return Arrays.asList(bookings);
    }


    public void addBooking(Booking new_booking) {
        restTemplate.postForObject("http://localhost:8090/booking", new_booking, Booking.class);
    }

    public void updateBooking(Booking booking) {
        String urlUpdate = "http://localhost:8090/booking/"+booking.getId();
        restTemplate.put(urlUpdate, booking, Booking.class);
    }

    public List<Booking> getAllForAdmin(){
        ResponseEntity<Booking[]> response =
                restTemplate.getForEntity("http://localhost:8090/admin", Booking[].class);
        Booking[] bookings = response.getBody();
        return Arrays.asList(bookings);
    }


}
