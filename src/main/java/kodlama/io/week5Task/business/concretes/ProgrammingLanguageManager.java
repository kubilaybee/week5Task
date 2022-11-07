package kodlama.io.week5Task.business.concretes;

import kodlama.io.week5Task.business.abstracts.ProgrammingLanguageService;
import kodlama.io.week5Task.business.requests.programmingLanguages.CreateProgrammingLanguageRequest;
import kodlama.io.week5Task.business.requests.programmingLanguages.DeleteProgrammingLanguageRequest;
import kodlama.io.week5Task.business.requests.programmingLanguages.UpdateProgrammingLanguageRequest;
import kodlama.io.week5Task.business.responses.programmingLanguages.GetAllProgrammingLanguagesResponse;
import kodlama.io.week5Task.business.responses.programmingLanguages.GetByIdProgrammingLanguageResponse;
import kodlama.io.week5Task.dataAccess.abstracts.ProgrammingLanguageRepo;
import kodlama.io.week5Task.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepo programmingLanguageRepo;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepo programmingLanguageRepo) {
        this.programmingLanguageRepo = programmingLanguageRepo;
    }

    @Override
    public List<GetAllProgrammingLanguagesResponse> getAll() {
        List<ProgrammingLanguage> programmingLanguages = this.programmingLanguageRepo.findAll();
        List<GetAllProgrammingLanguagesResponse> getAllProgrammingLanguagesResponses = new ArrayList<GetAllProgrammingLanguagesResponse>();

        for (ProgrammingLanguage programmingLanguage:programmingLanguages){
            GetAllProgrammingLanguagesResponse response = new GetAllProgrammingLanguagesResponse();
            response.setId(programmingLanguage.getId());
            response.setName(programmingLanguage.getName());

            getAllProgrammingLanguagesResponses.add(response);
        }
        return getAllProgrammingLanguagesResponses;
    }

    @Override
    public GetByIdProgrammingLanguageResponse getById(int id) throws Exception {
        if (!isIdExist(id)) throw new Exception("Id not found!");
        ProgrammingLanguage programmingLanguage = this.programmingLanguageRepo.findById(id).get();
        GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse = new GetByIdProgrammingLanguageResponse();
        getByIdProgrammingLanguageResponse.setName(programmingLanguage.getName());
        return getByIdProgrammingLanguageResponse;
    }

    @Override
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.setName(createProgrammingLanguageRequest.getName());
        if (isNameEmptyForAdd(programmingLanguage)) throw new Exception("The name cannot empty!");
        if (isNameExistForAdd(programmingLanguage)) throw new Exception("This name has been already exist!");
        this.programmingLanguageRepo.save(programmingLanguage);
    }

    @Override
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception {
        if (!isIdExist(deleteProgrammingLanguageRequest.getId())) throw new Exception("Id not found!");
        this.programmingLanguageRepo.deleteById(deleteProgrammingLanguageRequest.getId());
    }

    @Override
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
        if (!isIdExist(updateProgrammingLanguageRequest.getId())) throw new Exception("Id not found!");
        ProgrammingLanguage programmingLanguage = this.programmingLanguageRepo.findById(updateProgrammingLanguageRequest.getId()).get();
        if (isNameEmptyForUpdate(updateProgrammingLanguageRequest)) throw new Exception("The name cannot empty!");
        if (isNameExistForUpdate(updateProgrammingLanguageRequest)) throw new Exception("This name has been already exist!");

        programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
        this.programmingLanguageRepo.save(programmingLanguage);
    }

    private boolean isNameExistForAdd(ProgrammingLanguage programmingLanguage){
        for (GetAllProgrammingLanguagesResponse languagesResponse:getAll()){
            if (programmingLanguage.getName().equals(languagesResponse.getName())){
                return true;
            }
        }
        return false;
    }

    private boolean isNameEmptyForAdd(ProgrammingLanguage programmingLanguage){
        if (programmingLanguage.getName().isEmpty()){
            return true;
        }
        return false;
    }

    private boolean isNameEmptyForUpdate(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest){
        if (updateProgrammingLanguageRequest.getName().isEmpty()){
            return true;
        }
        return false;
    }

    private boolean isNameExistForUpdate(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest){
        for (GetAllProgrammingLanguagesResponse languagesResponse:getAll()){
            if (updateProgrammingLanguageRequest.getName().equals(languagesResponse.getName())){
                return true;
            }
        }
        return false;
    }

    private boolean isIdExist(int id){
        for (GetAllProgrammingLanguagesResponse languagesResponse:getAll()){
            if (languagesResponse.getId()==id){
                return true;
            }
        }
        return false;
    }
}
