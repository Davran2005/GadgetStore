package peaksoft.dto.simpl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
@AllArgsConstructor
@Builder
public class SimpleResponse {
    private HttpStatus status;
    private String massage;

}
