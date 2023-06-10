package peaksoft.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@Builder
public class ProductRequest {
    private String name;
    private List<String> images;
    private String characteristic;
    private String madeIn;
}
