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
@Document("permits-issued-to-companies-2023")
public class PermitsCompany2023 {
    @Id
    private ObjectId id;
    @Field("Employer Name")
    private String employer;
    @Field("Count")
    private int Count;
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
//    private int oct;
//    private int nov;
//    private int dec;
}
