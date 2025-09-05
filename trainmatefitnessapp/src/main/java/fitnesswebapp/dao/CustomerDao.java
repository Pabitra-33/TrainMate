package fitnesswebapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fitnesswebapp.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

}