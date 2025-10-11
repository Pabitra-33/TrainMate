package fitnesswebapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fitnesswebapp.model.Customer;
import fitnesswebapp.model.Workout;

@Repository
public interface WorkoutDao extends JpaRepository<Workout, Integer> {

	List<Workout> findByCustomerEntity(Customer customer);
}