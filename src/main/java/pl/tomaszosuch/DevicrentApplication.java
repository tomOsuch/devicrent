package pl.tomaszosuch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import pl.tomaszosuch.app.ApplicationController;
import pl.tomaszosuch.components.category.Category;
import pl.tomaszosuch.components.customer.Customer;
import pl.tomaszosuch.components.device.Device;
import pl.tomaszosuch.components.device.DeviceRepository;

import java.util.Scanner;

@SpringBootApplication
public class DevicrentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DevicrentApplication.class, args);
        ApplicationController controller = ctx.getBean(ApplicationController.class);
        controller.mainLoop();
    }

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }

}
