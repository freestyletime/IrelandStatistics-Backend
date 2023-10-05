package ie.chrischen.irelandstatistics.repository;

import ie.chrischen.irelandstatistics.model.PermitsCompany;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermitsCompanyRepository extends MongoRepository<PermitsCompany, ObjectId> {
    Optional<List<PermitsCompany>> findByYearEqualsAndEmployerContainingIgnoreCase(String year, String employer);

    Optional<List<PermitsCompany>> findByYear(String year);
}
