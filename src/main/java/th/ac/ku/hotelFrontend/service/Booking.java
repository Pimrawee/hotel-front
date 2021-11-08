package th.ac.ku.hotelFrontend.service;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;


public class Booking {

    private UUID id;
    private String firstName;   //ชื่อลูกค้า
    private String lastName;    //นามสกุลลูกค้า
    private String email;       //email ลูกค้า
    private String phone;       //เบอร์โทรลูกค้า
    private String hotelName;   //ชื่อโรงแรมที่จอง
    private String roomType;    //ประเภทห้องที่จอง
    private int numRoom;        //จำนวนห้องที่จอง
    private LocalDate checkin;  //วันที่เข้าพัก
    private LocalDate checkout; //วันที่กลับ
    private float price;        //ราคาที่ลูกค้าต้องจ่าย
    private String date;        //วันที่จ่ายเงิน
    private String hour;        //ชั่วโมงที่จ่ายเงิน
    private String minute;      //นาทีที่จ่ายเงิน
    private String refCode;     //รหัสการจ่ายเงิน


    private String status;      //สถานะการจ่ายเงิน

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumRoom() {
        return numRoom;
    }

    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getRefCode() {
        return refCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
