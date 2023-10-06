package ie.chrischen.irelandstatistics.model.permit;

import ie.chrischen.irelandstatistics.model.IModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("permits-by-county")
public class PermitsCounty implements IModel {
    @Id
    private ObjectId id;
    private String county;
    private String year;
    private int issued;
    private int refused;
    private int withdrawn;
}
