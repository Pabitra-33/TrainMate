package fitnesswebapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fitnesswebapp.model.Goal;

@Repository
public interface GoalsDao extends JpaRepository<Goal, Integer> {

}