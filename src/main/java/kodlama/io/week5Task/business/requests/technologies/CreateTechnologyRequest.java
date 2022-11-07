package kodlama.io.week5Task.business.requests.technologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTechnologyRequest {
    private int programmingLanguagesId;
    private String name;
}
