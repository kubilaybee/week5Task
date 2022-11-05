package kodlama.io.week5Task.dataAccess.abstracts;

import kodlama.io.week5Task.entities.concretes.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammingLanguageRepo extends JpaRepository<ProgrammingLanguage,Integer> {
}
