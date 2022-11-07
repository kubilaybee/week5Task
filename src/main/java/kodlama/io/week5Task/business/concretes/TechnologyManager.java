package kodlama.io.week5Task.business.concretes;

import kodlama.io.week5Task.business.abstracts.TechnologyService;
import kodlama.io.week5Task.business.requests.technologies.CreateTechnologyRequest;
import kodlama.io.week5Task.business.requests.technologies.DeleteTechnologyRequest;
import kodlama.io.week5Task.business.requests.technologies.UpdateTechnologyRequest;
import kodlama.io.week5Task.business.responses.technologies.GetAllTechnologiesResponse;
import kodlama.io.week5Task.dataAccess.abstracts.ProgrammingLanguageRepo;
import kodlama.io.week5Task.dataAccess.abstracts.TechnologyRepo;
import kodlama.io.week5Task.entities.concretes.ProgrammingLanguage;
import kodlama.io.week5Task.entities.concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {

    private TechnologyRepo technologyRepo;
    private ProgrammingLanguageRepo programmingLanguageRepo;

    @Autowired
    public TechnologyManager(TechnologyRepo technologyRepo, ProgrammingLanguageRepo programmingLanguageRepo) {
        this.technologyRepo = technologyRepo;
        this.programmingLanguageRepo = programmingLanguageRepo;
    }

    @Override
    public List<GetAllTechnologiesResponse> getAll() {
        List<Technology> technologies = this.technologyRepo.findAll();
        List<GetAllTechnologiesResponse> getAllTechnologiesResponses = new ArrayList<GetAllTechnologiesResponse>();

        for (Technology technology:technologies){

            GetAllTechnologiesResponse response = new GetAllTechnologiesResponse();

            response.setId(technology.getId());
            response.setProgrammingLanguageId(technology.getProgrammingLanguage().getId());
            response.setName(technology.getName());
            response.setProgrammingLanguageName(technology.getProgrammingLanguage().getName());

            getAllTechnologiesResponses.add(response);
        }
        return getAllTechnologiesResponses;
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception{
        Technology technology = new Technology();
        ProgrammingLanguage programmingLanguage = this.programmingLanguageRepo.findById(createTechnologyRequest.getProgrammingLanguagesId()).get();

        technology.setName(createTechnologyRequest.getName());
        technology.setProgrammingLanguage(programmingLanguage);

        if (isNameExistForAdd(technology)) throw new Exception("This name has been already exist!");
        if (isNameEmptyForAdd(technology)) throw new Exception("The name cannot empty!");

        this.technologyRepo.save(technology);
    }

    @Override
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
        if (!isIdExist(deleteTechnologyRequest.getId())) throw new Exception("Id not found!");
        this.technologyRepo.deleteById(deleteTechnologyRequest.getId());
    }

    @Override
    public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
        if (!isIdExist(updateTechnologyRequest.getId())) throw new Exception("Id not found!");
        if (isNameEmptyForUpdate(updateTechnologyRequest)) throw new Exception("The name cannot empty!");
        if (isNameExistForUpdate(updateTechnologyRequest)) throw new Exception("This name has been already exist!");

        Technology technology = this.technologyRepo.findById(updateTechnologyRequest.getId()).get();
        ProgrammingLanguage programmingLanguage = this.programmingLanguageRepo.findById(updateTechnologyRequest.getProgrammingLanguageId()).get();

        technology.setName(updateTechnologyRequest.getName());
        technology.setProgrammingLanguage(programmingLanguage);

        this.technologyRepo.save(technology);
    }

    private boolean isNameExistForAdd(Technology technology){
        for (GetAllTechnologiesResponse technologiesResponse:getAll()){
            if (technology.getName().equals(technologiesResponse.getName())){
                return true;
            }
        }
        return false;
    }

    private boolean isNameEmptyForAdd(Technology technology){
        if (technology.getName().isEmpty()){
            return true;
        }
        return false;
    }

    private boolean isNameEmptyForUpdate(UpdateTechnologyRequest updateTechnologyRequest){
        if (updateTechnologyRequest.getName().isEmpty()){
            return true;
        }
        return false;
    }

    private boolean isNameExistForUpdate(UpdateTechnologyRequest updateTechnologyRequest){
        for (GetAllTechnologiesResponse technologiesResponse:getAll()){
            if (updateTechnologyRequest.getName().equals(technologiesResponse.getName())) {
                return true;
            }
        }
        return false;
    }

    private boolean isIdExist(int id){
        for (GetAllTechnologiesResponse getAllTechnologiesResponse: getAll()){
            if (getAllTechnologiesResponse.getId()==id){
                return true;
            }
        }
        return false;
    }
}
