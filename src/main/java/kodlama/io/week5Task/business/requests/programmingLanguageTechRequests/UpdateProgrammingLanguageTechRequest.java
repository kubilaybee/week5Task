package kodlama.io.week5Task.business.requests.programmingLanguageTechRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProgrammingLanguageTechRequest {
    private int programmingLanguageId;
    private String name;
}
