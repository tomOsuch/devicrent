package pl.tomaszosuch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tomaszosuch.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
