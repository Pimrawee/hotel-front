package th.ac.ku.hotelFrontend.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import th.ac.ku.hotelFrontend.config.ComponentConfig;
import th.ac.ku.hotelFrontend.service.Booking;
import th.ac.ku.hotelFrontend.service.BookingAPIService;

import java.io.IOException;
import java.util.List;

//@Component
//@FxmlView("/templates/AdminSystem.fxml")
public class AdminSystemController {
    @FXML
    Button logoutBtn;

    @FXML
    ListView showBookingOrder;

    private BookingAPIService service;

    public void initialize(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ApplicationContext context = new AnnotationConfigApplicationContext(ComponentConfig.class);
                service = context.getBean(BookingAPIService.class);

                showBookingOrder.getItems().clear();
                showBookingOrder.getItems().add("---------- ORDER ----------");
                for(Booking bookings : service.getAllForAdmin()){
                    showBookingOrder.getItems().add("ชื่อลูกค้า : "+bookings.getFirstName() + " " + bookings.getLastName()+
                            "\nเบอร์โทรลูกค้า : "+ bookings.getPhone()+
                            "\nemail ลูกค้า : "+ bookings.getEmail()+
                            "\nชื่อโรงแรมที่จอง : "+bookings.getHotelName()+
                            "\nประเภทห้องที่จอง : "+bookings.getRoomType()+ ", จำนวนห้องที่จอง "+ bookings.getNumRoom()+ " ห้อง"+
                            "\nCheck In : "+bookings.getCheckin()+ "\nCheck Out :"+bookings.getCheckout()+
                            "\nราคาที่ลูกค้าต้องจ่าย : "+bookings.getPrice() +" THB"+
                            "\nstatus : "+bookings.getStatus()+
                            "\nวันที่จ่ายเงิน : "+bookings.getDate()+
                            "\nเวลาจ่ายเงิน: "+bookings.getHour()+":"+bookings.getMinute()+" น."+
                            "\nrefCode : "+bookings.getRefCode());
                    showBookingOrder.getItems().add("---------- END ----------\n");
                }
            }
        });
    }

    public void ActionOnLogoutBtn(ActionEvent event) throws IOException {
        logoutBtn = (Button) event.getSource();
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/templates/Home.fxml"));
        stage.setScene(new Scene(loader.load()));
    }

}
