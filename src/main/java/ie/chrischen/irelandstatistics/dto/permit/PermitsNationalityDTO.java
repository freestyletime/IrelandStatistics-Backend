package ie.chrischen.irelandstatistics.dto.permit;

import ie.chrischen.irelandstatistics.dto.IDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermitsNationalityDTO implements IDTO {
    private ObjectId id;
    private String nationality;
    private String year;
    private int issued;
    private int refused;
    private int withdrawn;
}
