package pl.tomaszosuch.components.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tomaszosuch.components.category.Category;
import pl.tomaszosuch.components.category.CategoryRepository;

import java.util.Optional;
import java.util.Scanner;

@Service
public class DeviceController {

    private Scanner scanner;
    private DeviceRepository deviceRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public DeviceController(Scanner scanner, DeviceRepository deviceRepository, CategoryRepository categoryRepository) {
        this.scanner = scanner;
        this.deviceRepository = deviceRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void createDevice(){
        try {
            Device device = readDevice();
            deviceRepository.save(device);
            System.out.println("Dodano urządzenie");
            System.out.println(device);
        } catch (CategoryNotFoundException e){
            System.err.println("Urządzenia nie dodano " + e.getMessage());
        }
    }

    public Device readDevice() {
        Device device = new Device();
        System.out.println("Nazwa urządzenia");
        device.setName(scanner.nextLine());
        System.out.println("Opis urządzenia");
        device.setDescription(scanner.nextLine());
        System.out.println("Cena urządzenia");
        device.setPrice(scanner.nextDouble());
        System.out.println("liczba urządzeń");
        device.setQuantity(scanner.nextInt());
        System.out.println("Kategoria id urządzenia");
        long categoryId = scanner.nextLong();

        Optional<Category> category = categoryRepository.findById(categoryId);
        category.ifPresentOrElse(device::setCategory,
                () -> {
                    throw new CategoryNotFoundException("Kategoria o podanym id nie istnieje");
                });
        return device;
    }

    public void removeDevice(){
        System.out.println("Podaj id urządzenia, które chcesz usunąć");
        long deviceId = scanner.nextLong();
        Optional<Device> device = deviceRepository.findById(deviceId);
        device.ifPresentOrElse(deviceRepository::delete, () -> System.out.println("Brak urządzenia o podanym nr id."));
    }

}
