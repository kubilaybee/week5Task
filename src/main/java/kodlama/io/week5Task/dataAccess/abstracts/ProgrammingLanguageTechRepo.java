package kodlama.io.week5Task.dataAccess.abstracts;

import kodlama.io.week5Task.entities.concretes.ProgrammingLanguageTech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammingLanguageTechRepo extends JpaRepository<ProgrammingLanguageTech,Integer> {
}
