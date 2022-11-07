package kodlama.io.week5Task.webApi.controllers;

import kodlama.io.week5Task.entities.concretes.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammingLanguageRepo extends JpaRepository<ProgrammingLanguage,Integer> {
}
