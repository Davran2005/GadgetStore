package peaksoft.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@AllArgsConstructor
@Data
public class EntityResponse {
    private List<SortResponse> objectList;
}
