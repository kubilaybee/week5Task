package kodlama.io.week5Task.business.responses.programmingLanguageTechResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgrammingLanguageTechResponse {
    private String name;
    private String languageName;
}
