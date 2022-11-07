package kodlama.io.week5Task.webApi.controllers;

import kodlama.io.week5Task.business.abstracts.ProgrammingLanguageService;
import kodlama.io.week5Task.business.requests.programmingLanguageRequests.AddProgrammingLanguageRequest;
import kodlama.io.week5Task.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import kodlama.io.week5Task.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import kodlama.io.week5Task.business.responses.programmingLanguageResponses.GetAllProgrammingLanguageResponse;
import kodlama.io.week5Task.business.responses.programmingLanguageResponses.GetByIdProgrammingLanguageResponse;
import kodlama.io.week5Task.entities.concretes.ProgrammingLanguage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguageController {
    private ProgrammingLanguageService programmingLanguageService;

    public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @PostMapping("/save")
    public void add(AddProgrammingLanguageRequest addProgrammingLanguageRequest){
        programmingLanguageService.add(addProgrammingLanguageRequest);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest){
        programmingLanguageService.delete(deleteProgrammingLanguageRequest);
    }

    @PutMapping("/update")
    public void update(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest){
        programmingLanguageService.update(id,updateProgrammingLanguageRequest);
    }

    @GetMapping("/getall")
    public List<GetAllProgrammingLanguageResponse> getAll(){
        return programmingLanguageService.getAll();
    }

    @GetMapping("/getbyid")
    public GetByIdProgrammingLanguageResponse getById(int id){
        return programmingLanguageService.getById(id);
    }
}
