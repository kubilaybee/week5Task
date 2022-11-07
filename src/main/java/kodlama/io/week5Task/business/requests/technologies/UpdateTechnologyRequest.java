package kodlama.io.week5Task.business.requests.technologies;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTechnologyRequest {
    private int id;
    private int programmingLanguageId;
    private String name;
}
