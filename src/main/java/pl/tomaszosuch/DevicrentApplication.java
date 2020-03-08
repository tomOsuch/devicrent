package pl.tomaszosuch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.tomaszosuch.dao.DeviceDao;
import pl.tomaszosuch.model.Category;
import pl.tomaszosuch.model.Customer;
import pl.tomaszosuch.model.Device;

@SpringBootApplication
public class DevicrentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DevicrentApplication.class, args);
        DeviceDao deviceDao = ctx.getBean(DeviceDao.class);

        Device device = new Device();
        device.setName("Wiertarka test");
        device.setDescription("Wiertarka udarowa o dużej mocy - wpis testowy");
        device.setPrice(80);
        device.setQuantity(5);

        Category category = new Category();
        category.setName("Elektronarzędzia - test");
        category.setDescription("Wiertarki, szlifierki, młoty udarowe i inne elektronarzędzia");

        Customer customer = new Customer();
        customer.setFirstName("JanTestowy");
        customer.setLastName("Kowalski");
        customer.setPesel("90908765123");
        customer.setIdNumber("ABC678121");

        device.setCategory(category);
        device.addCustomer(customer);

        deviceDao.save(device);
    }

}
