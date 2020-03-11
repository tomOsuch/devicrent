package pl.tomaszosuch.components.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tomaszosuch.components.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
