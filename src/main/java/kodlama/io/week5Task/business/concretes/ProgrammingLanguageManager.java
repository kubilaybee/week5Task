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

    }

    @Override
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {

    }

    @Override
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {

    }
}
