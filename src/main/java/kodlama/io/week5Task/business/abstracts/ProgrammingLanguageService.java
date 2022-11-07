package kodlama.io.week5Task.business.abstracts;

import kodlama.io.week5Task.business.requests.programmingLanguageRequests.AddProgrammingLanguageRequest;
import kodlama.io.week5Task.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import kodlama.io.week5Task.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import kodlama.io.week5Task.business.responses.programmingLanguageResponses.GetAllProgrammingLanguageResponse;
import kodlama.io.week5Task.business.responses.programmingLanguageResponses.GetByIdProgrammingLanguageResponse;

import java.util.List;

public interface ProgrammingLanguageService {
    List<GetAllProgrammingLanguageResponse> getAll();
    GetByIdProgrammingLanguageResponse getById(int id);
    void add(AddProgrammingLanguageRequest addProgrammingLanguageRequest);
    void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest);
    void update(int id,UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);
}
