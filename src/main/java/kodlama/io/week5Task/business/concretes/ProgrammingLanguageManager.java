package kodlama.io.week5Task.business.concretes;

import kodlama.io.week5Task.business.abstracts.ProgrammingLanguageService;
import kodlama.io.week5Task.business.requests.programmingLanguageRequests.AddProgrammingLanguageRequest;
import kodlama.io.week5Task.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import kodlama.io.week5Task.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import kodlama.io.week5Task.business.responses.programmingLanguageResponses.GetAllProgrammingLanguageResponse;
import kodlama.io.week5Task.business.responses.programmingLanguageResponses.GetByIdProgrammingLanguageResponse;
import kodlama.io.week5Task.dataAccess.abstracts.ProgrammingLanguageRepo;
import kodlama.io.week5Task.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepo programmingLanguageRepo;

    public ProgrammingLanguageManager(ProgrammingLanguageRepo programmingLanguageRepo) {
        this.programmingLanguageRepo = programmingLanguageRepo;
    }

    @Override
    public List<GetAllProgrammingLanguageResponse> getAll() {
        List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepo.findAll();
        List<GetAllProgrammingLanguageResponse> programmingLanguageResponses = new ArrayList<>();
        for (ProgrammingLanguage programmingLanguage:programmingLanguages){
            GetAllProgrammingLanguageResponse response = new GetAllProgrammingLanguageResponse();
            response.setName(programmingLanguage.getName());

            programmingLanguageResponses.add(response);
        }
        return programmingLanguageResponses;
    }

    @Override
    public GetByIdProgrammingLanguageResponse getById(int id) {
        ProgrammingLanguage programmingLanguage = programmingLanguageRepo.findById(id).get();
        GetByIdProgrammingLanguageResponse response = new GetByIdProgrammingLanguageResponse();
        response.setName(programmingLanguage.getName());
        return response;
    }

    @Override
    public void add(AddProgrammingLanguageRequest addProgrammingLanguageRequest) {
        // TODO fix that
        if (programmingLanguageExistValidator(addProgrammingLanguageRequest)&&programmingLanguageNameValidator(addProgrammingLanguageRequest)){
            ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
            programmingLanguage.setName(addProgrammingLanguageRequest.getName());
            programmingLanguageRepo.save(programmingLanguage);
        }
    }

    @Override
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
        programmingLanguageRepo.deleteById(deleteProgrammingLanguageRequest.getId());
    }

    @Override
    public void update(int id,UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
        if (!updateProgrammingLanguageRequest.getName().isEmpty()){
            ProgrammingLanguage programmingLanguage = programmingLanguageRepo.findById(id).get();
            programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
            programmingLanguageRepo.save(programmingLanguage);
        }
    }

    // check if it is empty
    public boolean programmingLanguageNameValidator(AddProgrammingLanguageRequest addProgrammingLanguageRequest){
        if (addProgrammingLanguageRequest.getName().isEmpty()){
            System.out.println("This language name is empty or blank.");
        }
        return !addProgrammingLanguageRequest.getName().isEmpty();
    }

    // check if it has been used before
    public boolean programmingLanguageExistValidator(AddProgrammingLanguageRequest addProgrammingLanguageRequest){
        for (ProgrammingLanguage programmingLanguage:programmingLanguageRepo.findAll()){
            if (programmingLanguage.getName().equalsIgnoreCase(addProgrammingLanguageRequest.getName())){
                System.out.println("This language has been already exist.");
                return false;
            }
        }
        return true;
    }
}
