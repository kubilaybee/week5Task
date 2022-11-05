package kodlama.io.week5Task.business.requests.programmingLanguageTechRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProgrammingLanguageTechRequest {
    private String name;
    private int programmingLanguageId;
}
