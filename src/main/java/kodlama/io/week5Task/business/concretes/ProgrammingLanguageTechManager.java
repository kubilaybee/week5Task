package kodlama.io.week5Task.business.concretes;

import kodlama.io.week5Task.business.abstracts.ProgrammingLanguageTechService;
import kodlama.io.week5Task.business.requests.programmingLanguageTechRequests.AddProgrammingLanguageTechRequest;
import kodlama.io.week5Task.business.requests.programmingLanguageTechRequests.DeleteProgrammingLanguageTechRequest;
import kodlama.io.week5Task.business.requests.programmingLanguageTechRequests.UpdateProgrammingLanguageTechRequest;
import kodlama.io.week5Task.business.responses.programmingLanguageTechResponses.GetAllProgrammingLanguageTechResponse;

import java.util.List;

public class ProgrammingLanguageTechManager implements ProgrammingLanguageTechService {
    @Override
    public List<GetAllProgrammingLanguageTechResponse> getAll() {
        return null;
    }

    @Override
    public void add(AddProgrammingLanguageTechRequest addProgrammingLanguageTechRequest) {

    }

    @Override
    public void delete(DeleteProgrammingLanguageTechRequest deleteProgrammingLanguageTechRequest) {

    }

    @Override
    public void update(UpdateProgrammingLanguageTechRequest updateProgrammingLanguageTechRequest) {

    }
}
