package kodlama.io.week5Task.dataAccess.abstracts;

import kodlama.io.week5Task.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepo extends JpaRepository<Technology,Integer> {
}
