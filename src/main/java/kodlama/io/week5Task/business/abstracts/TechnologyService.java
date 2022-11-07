package kodlama.io.week5Task.business.abstracts;

import kodlama.io.week5Task.business.requests.technologies.CreateTechnologyRequest;
import kodlama.io.week5Task.business.requests.technologies.DeleteTechnologyRequest;
import kodlama.io.week5Task.business.requests.technologies.UpdateTechnologyRequest;
import kodlama.io.week5Task.business.responses.technologies.GetAllTechnologiesResponse;

import java.util.List;

public interface TechnologyService {
    List<GetAllTechnologiesResponse> getAll();
    void add(CreateTechnologyRequest createTechnologyRequest);
    void delete(DeleteTechnologyRequest deleteTechnologyRequest);
    void update(UpdateTechnologyRequest updateTechnologyRequest);
}
