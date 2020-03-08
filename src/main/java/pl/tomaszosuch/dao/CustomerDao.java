package pl.tomaszosuch.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.tomaszosuch.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Customer save(Customer customer){
        entityManager.persist(customer);
        return customer;
    }

    public Customer read(Long id){
        return entityManager.find(Customer.class, id);
    }

    @Transactional
    public Customer update(Customer customer){
        return entityManager.merge(customer);
    }

    @Transactional
    public void delete(Customer customer){
        Customer attachedCustomer = read(customer.getId());
        entityManager.remove(attachedCustomer);
    }
}
