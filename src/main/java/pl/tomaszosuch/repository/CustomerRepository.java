package pl.tomaszosuch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tomaszosuch.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
