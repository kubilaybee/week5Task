package kodlama.io.week5Task.business.responses.technologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllTechnologiesResponse {
    private int id;
    private int programmingLanguageId;
    private String programmingLanguageName;
    private String name;
}
