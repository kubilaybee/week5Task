package kodlama.io.week5Task.webApi.controllers;

import kodlama.io.week5Task.business.abstracts.ProgrammingLanguageTechService;
import kodlama.io.week5Task.business.requests.programmingLanguageTechRequests.AddProgrammingLanguageTechRequest;
import kodlama.io.week5Task.business.requests.programmingLanguageTechRequests.DeleteProgrammingLanguageTechRequest;
import kodlama.io.week5Task.business.requests.programmingLanguageTechRequests.UpdateProgrammingLanguageTechRequest;
import kodlama.io.week5Task.business.responses.programmingLanguageTechResponses.GetAllProgrammingLanguageTechResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languagetechs")
public class ProgrammingLanguageTechController {
    ProgrammingLanguageTechService programmingLanguageTechService;

    @Autowired
    public ProgrammingLanguageTechController(ProgrammingLanguageTechService programmingLanguageTechService) {
        this.programmingLanguageTechService = programmingLanguageTechService;
    }

    @GetMapping("/getall")
    public List<GetAllProgrammingLanguageTechResponse> getAll(){
        return this.programmingLanguageTechService.getAll();
    }

    @GetMapping("/add")
    public void add(AddProgrammingLanguageTechRequest addProgrammingLanguageTechRequest){
        this.programmingLanguageTechService.add(addProgrammingLanguageTechRequest);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteProgrammingLanguageTechRequest deleteProgrammingLanguageTechRequest){
        this.programmingLanguageTechService.delete(deleteProgrammingLanguageTechRequest);
    }

    @PutMapping("/update")
    public void update(int id, UpdateProgrammingLanguageTechRequest updateProgrammingLanguageTechRequest){
        this.programmingLanguageTechService.update(id,updateProgrammingLanguageTechRequest);
    }
}
