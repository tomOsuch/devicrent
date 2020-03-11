package pl.tomaszosuch.components.rent;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tomaszosuch.components.customer.Customer;
import pl.tomaszosuch.components.customer.CustomerRepository;
import pl.tomaszosuch.components.device.Device;
import pl.tomaszosuch.components.device.DeviceRepository;

import java.util.Optional;
import java.util.Scanner;

@Service
public class RentController {

    private Scanner scanner;
    private CustomerRepository customerRepository;
    private DeviceRepository deviceRepository;

    public RentController(Scanner scanner, CustomerRepository customerRepository, DeviceRepository deviceRepository) {
        this.scanner = scanner;
        this.customerRepository = customerRepository;
        this.deviceRepository = deviceRepository;
    }

    @Transactional
    public void rentDeviceToCustomer(){
        try {
            rent();
        } catch (RentException e){
            System.err.println(e.getMessage());
        }
    }

    private void rent() {
        System.out.println("Podaj nr id klienta");
        long customerId = scanner.nextLong();
        System.out.println("Podaj nr id urządzenia");
        long deviceId = scanner.nextLong();

        Optional<Customer> customer = customerRepository.findById(customerId);
        Optional<Device> device = deviceRepository.findById(deviceId);

        if(customer.isPresent())
            device.ifPresentOrElse(dev -> {
                if(dev.getQuantity() > dev.getCustomers().size())
                    dev.addCustomer(customer.get());
                else
                    throw new RentException("Brak wolnych urządzeń o wskazanym ID");
            }, () -> {
                throw new RentException("Brak urządzenia o wskazanym ID");
            });
        else
            throw new RentException("Brak klienta o wskazanym ID");
    }
}
