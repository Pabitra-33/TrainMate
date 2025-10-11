package fitnesswebapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fitnesswebapp.model.Customer;
import fitnesswebapp.model.Goal;

@Repository
public interface GoalsDao extends JpaRepository<Goal, Integer> {

	List<Goal> findByCustomerEntity(Customer customer);
}