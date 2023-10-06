package ie.chrischen.irelandstatistics.repository.permit;

import ie.chrischen.irelandstatistics.model.permit.PermitsCompany;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermitsCompanyRepository extends MongoRepository<PermitsCompany, ObjectId> {
    Optional<List<PermitsCompany>> findByYearEqualsAndEmployerStartsWith(String year, String employer, Pageable page);

    Optional<List<PermitsCompany>> findByYear(String year, Pageable page);
}
