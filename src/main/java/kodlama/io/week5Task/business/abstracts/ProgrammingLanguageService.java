package kodlama.io.week5Task.business.abstracts;

import kodlama.io.week5Task.business.requests.programmingLanguages.CreateProgrammingLanguageRequest;
import kodlama.io.week5Task.business.requests.programmingLanguages.DeleteProgrammingLanguageRequest;
import kodlama.io.week5Task.business.requests.programmingLanguages.UpdateProgrammingLanguageRequest;
import kodlama.io.week5Task.business.responses.programmingLanguages.GetAllProgrammingLanguagesResponse;
import kodlama.io.week5Task.business.responses.programmingLanguages.GetByIdProgrammingLanguageResponse;

import java.util.List;

public interface ProgrammingLanguageService {
    List<GetAllProgrammingLanguagesResponse> getAll();
    GetByIdProgrammingLanguageResponse getById(int id) throws Exception;
    void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
    void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception;
    void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;
}
