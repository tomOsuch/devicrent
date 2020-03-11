package pl.tomaszosuch.components.device;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tomaszosuch.components.device.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
