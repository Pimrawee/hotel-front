package th.ac.ku.hotelFrontend.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import th.ac.ku.hotelFrontend.config.ComponentConfig;
import th.ac.ku.hotelFrontend.service.Booking;
import th.ac.ku.hotelFrontend.service.BookingAPIService;

import java.io.IOException;

//@Component
//@FxmlView("/templates/checkBooking.fxml")
public class checkBookingController {
    @FXML
    Button backBtn, checkBtn;

    @FXML
    TextField phoneField;

    @FXML
    ListView showBooking;

    private BookingAPIService service;

    public void initialize(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ApplicationContext context = new AnnotationConfigApplicationContext(ComponentConfig.class);
                service = context.getBean(BookingAPIService.class);
            }
        });
    }

    public void ActionOnBackBtn(ActionEvent event) throws IOException {
        backBtn = (Button) event.getSource();
        Stage stage = (Stage) backBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/templates/Home.fxml"));
        stage.setScene(new Scene(loader.load()));
    }

    public void ActionOnCheckBtn(ActionEvent event) {
        showBooking.getItems().clear();
        if(phoneField.getText().isEmpty()){
            showBooking.getItems().add("!!! กรอกเบอร์โทรของผู้ที่ทำการจอง ก่อนนะ !!!");
        }else{
            showBooking.getItems().add("---------- CHECK BOOKING ----------");
            for(Booking bookings : service.getCustomerBookingAll()){
                if(bookings.getPhone().equals(phoneField.getText())) {
                    showBooking.getItems().add("ชื่อลูกค้า : " + bookings.getFirstName() + " " + bookings.getLastName() +
                            "\nเบอร์โทรลูกค้า : " + bookings.getPhone() +
                            "\nemail ลูกค้า : " + bookings.getEmail() +
                            "\nชื่อโรงแรมที่จอง : " + bookings.getHotelName() +
                            "\nประเภทห้องที่จอง : " + bookings.getRoomType() + ", จำนวนห้องที่จอง " + bookings.getNumRoom() + " ห้อง" +
                            "\nCheck In : " + bookings.getCheckin() + "\nCheck Out :" + bookings.getCheckout() +
                            "\nราคาที่ลูกค้าต้องจ่าย : " + bookings.getPrice() + " THB" +
                            "\nstatus : " + bookings.getStatus() +
                            "\nวันที่จ่ายเงิน : " + bookings.getDate() +
                            "\nเวลาจ่ายเงิน: " + bookings.getHour() + ":" + bookings.getMinute() + " น." +
                            "\nrefCode : " + bookings.getRefCode());
                    showBooking.getItems().add("---------- END ----------\n");
                }
            }
        }
    }


}
