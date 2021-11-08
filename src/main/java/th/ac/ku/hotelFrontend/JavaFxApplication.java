package th.ac.ku.hotelFrontend;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import th.ac.ku.hotelFrontend.controller.HomeController;

import java.io.IOException;

public class JavaFxApplication extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/templates/Home.fxml"));
        Scene scene = new Scene(root,900,700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hotel Booking Application");
        primaryStage.setResizable(false);

        primaryStage.show();

    }
}
