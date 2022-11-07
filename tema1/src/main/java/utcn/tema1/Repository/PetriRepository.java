package utcn.tema1.Repository;

import utcn.tema1.Entity.Petri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PetriRepository extends JpaRepository<Petri, Integer> {
}
