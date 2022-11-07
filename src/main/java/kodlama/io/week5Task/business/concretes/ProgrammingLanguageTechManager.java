package kodlama.io.week5Task.business.concretes;

import kodlama.io.week5Task.business.abstracts.ProgrammingLanguageTechService;
import kodlama.io.week5Task.business.requests.programmingLanguageTechRequests.AddProgrammingLanguageTechRequest;
import kodlama.io.week5Task.business.requests.programmingLanguageTechRequests.DeleteProgrammingLanguageTechRequest;
import kodlama.io.week5Task.business.requests.programmingLanguageTechRequests.UpdateProgrammingLanguageTechRequest;
import kodlama.io.week5Task.business.responses.programmingLanguageTechResponses.GetAllProgrammingLanguageTechResponse;
import kodlama.io.week5Task.dataAccess.abstracts.ProgrammingLanguageRepo;
import kodlama.io.week5Task.dataAccess.abstracts.ProgrammingLanguageTechRepo;
import kodlama.io.week5Task.entities.concretes.ProgrammingLanguage;
import kodlama.io.week5Task.entities.concretes.ProgrammingLanguageTech;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgrammingLanguageTechManager implements ProgrammingLanguageTechService {

    private ProgrammingLanguageTechRepo programmingLanguageTechRepo;
    private ProgrammingLanguageRepo programmingLanguageRepo;

    public ProgrammingLanguageTechManager(ProgrammingLanguageTechRepo programmingLanguageTechRepo, ProgrammingLanguageRepo programmingLanguageRepo){
        this.programmingLanguageRepo = programmingLanguageRepo;
        this.programmingLanguageTechRepo = programmingLanguageTechRepo;
    }

    @Override
    public List<GetAllProgrammingLanguageTechResponse> getAll() {
        List<ProgrammingLanguageTech> programmingLanguageTeches = programmingLanguageTechRepo.findAll();
        List<GetAllProgrammingLanguageTechResponse> responses = new ArrayList<>();
        for (ProgrammingLanguageTech programmingLanguageTech:programmingLanguageTeches){
            GetAllProgrammingLanguageTechResponse response = new GetAllProgrammingLanguageTechResponse();
            response.setName(programmingLanguageTech.getName());
            response.setLanguageName(programmingLanguageTech.getProgrammingLanguage().getName());
            responses.add(response);
        }
        return responses;
    }

    @Override
    public void add(AddProgrammingLanguageTechRequest addProgrammingLanguageTechRequest) {
        ProgrammingLanguageTech programmingLanguageTech = new ProgrammingLanguageTech();
        ProgrammingLanguage programmingLanguage = programmingLanguageRepo.findById(addProgrammingLanguageTechRequest.getProgrammingLanguageId()).get();
        programmingLanguageTech.setName(addProgrammingLanguageTechRequest.getName());
        programmingLanguageTech.setProgrammingLanguage(programmingLanguage);
        programmingLanguageTechRepo.save(programmingLanguageTech);
    }

    @Override
    public void delete(DeleteProgrammingLanguageTechRequest deleteProgrammingLanguageTechRequest) {
        programmingLanguageTechRepo.deleteById(deleteProgrammingLanguageTechRequest.getId());
    }

    @Override
    public void update(int id,UpdateProgrammingLanguageTechRequest updateProgrammingLanguageTechRequest) {
        ProgrammingLanguageTech programmingLanguageTech = programmingLanguageTechRepo.findById(updateProgrammingLanguageTechRequest.getProgrammingLanguageId()).get();
        ProgrammingLanguage programmingLanguage = programmingLanguageRepo.findById(updateProgrammingLanguageTechRequest.getProgrammingLanguageId()).get();
        programmingLanguageTech.setName(updateProgrammingLanguageTechRequest.getName());
        programmingLanguageTech.setProgrammingLanguage(programmingLanguage);
        programmingLanguageTechRepo.save(programmingLanguageTech);
    }
}
