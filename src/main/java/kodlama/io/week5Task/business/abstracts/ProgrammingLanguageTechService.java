package kodlama.io.week5Task.business.abstracts;

import kodlama.io.week5Task.business.requests.programmingLanguageTechRequests.AddProgrammingLanguageTechRequest;
import kodlama.io.week5Task.business.requests.programmingLanguageTechRequests.DeleteProgrammingLanguageTechRequest;
import kodlama.io.week5Task.business.requests.programmingLanguageTechRequests.UpdateProgrammingLanguageTechRequest;
import kodlama.io.week5Task.business.responses.programmingLanguageTechResponses.GetAllProgrammingLanguageTechResponse;

import java.util.List;

public interface ProgrammingLanguageTechService {

    List<GetAllProgrammingLanguageTechResponse> getAll();
    void add(AddProgrammingLanguageTechRequest addProgrammingLanguageTechRequest);
    void delete(DeleteProgrammingLanguageTechRequest deleteProgrammingLanguageTechRequest);
    void update(UpdateProgrammingLanguageTechRequest updateProgrammingLanguageTechRequest);
}
