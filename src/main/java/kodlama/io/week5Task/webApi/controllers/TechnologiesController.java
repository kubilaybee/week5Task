package kodlama.io.week5Task.webApi.controllers;

import kodlama.io.week5Task.business.abstracts.TechnologyService;
import kodlama.io.week5Task.business.requests.technologies.CreateTechnologyRequest;
import kodlama.io.week5Task.business.requests.technologies.DeleteTechnologyRequest;
import kodlama.io.week5Task.business.requests.technologies.UpdateTechnologyRequest;
import kodlama.io.week5Task.business.responses.technologies.GetAllTechnologiesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
    TechnologyService technologyService;

    @Autowired
    public TechnologiesController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/getall")
    public List<GetAllTechnologiesResponse> getAll(){
        return this.technologyService.getAll();
    }

    @PostMapping("/add")
    public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception{
        this.technologyService.add(createTechnologyRequest);
    }

    @PutMapping("/update")
    public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception{
        this.technologyService.update(updateTechnologyRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception{
        this.technologyService.delete(deleteTechnologyRequest);
    }
}
