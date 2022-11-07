package kodlama.io.week5Task.webApi.controllers;

import kodlama.io.week5Task.business.abstracts.ProgrammingLanguageService;
import kodlama.io.week5Task.business.requests.programmingLanguages.CreateProgrammingLanguageRequest;
import kodlama.io.week5Task.business.requests.programmingLanguages.DeleteProgrammingLanguageRequest;
import kodlama.io.week5Task.business.requests.programmingLanguages.UpdateProgrammingLanguageRequest;
import kodlama.io.week5Task.business.responses.programmingLanguages.GetAllProgrammingLanguagesResponse;
import kodlama.io.week5Task.business.responses.programmingLanguages.GetByIdProgrammingLanguageResponse;
import kodlama.io.week5Task.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
    private ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping("/getall")
    public List<GetAllProgrammingLanguagesResponse> getAll(){
        return programmingLanguageService.getAll();
    }

    @GetMapping("/getbyid")
    public GetByIdProgrammingLanguageResponse getById(int id) throws Exception{
        return programmingLanguageService.getById(id);
    }

    @PostMapping("/add")
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception{
        this.programmingLanguageService.add(createProgrammingLanguageRequest);
    }

    @PutMapping("/update")
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception{
        this.programmingLanguageService.update(updateProgrammingLanguageRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception{
        this.programmingLanguageService.delete(deleteProgrammingLanguageRequest);
    }
}
