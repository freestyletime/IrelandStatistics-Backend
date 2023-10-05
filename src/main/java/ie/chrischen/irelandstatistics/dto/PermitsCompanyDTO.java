package ie.chrischen.irelandstatistics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermitsCompanyDTO {
    private ObjectId id;
    private String employer;
    private String year;
    private int count;
    private List<Integer> monthCount;
}
