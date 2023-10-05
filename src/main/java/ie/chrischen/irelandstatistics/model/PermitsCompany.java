package ie.chrischen.irelandstatistics.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("permits-issued-to-companies")
public class PermitsCompany {
    @Id
    private ObjectId id;
    private String employer;
    private String year;
    private int count;
    @Field("Jan")
    private int jan;
    @Field("Feb")
    private int feb;
    @Field("Mar")
    private int mar;
    @Field("Apr")
    private int apr;
    @Field("May")
    private int may;
    @Field("Jun")
    private int jun;
    @Field("Jul")
    private int jul;
    @Field("Aug")
    private int aug;
    @Field("Sep")
    private int sep;
    @Field("Oct")
    private int oct;
    @Field("Nov")
    private int nov;
    @Field("Dec")
    private int dec;
}
