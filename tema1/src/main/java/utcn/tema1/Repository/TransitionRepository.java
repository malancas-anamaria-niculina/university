package utcn.tema1.Repository;

import utcn.tema1.Entity.Transition;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransitionRepository extends JpaRepository<Transition, Integer> {
    List<Transition> findByTransitionName(String transitionName);
}
