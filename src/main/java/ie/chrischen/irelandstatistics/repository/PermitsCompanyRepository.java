package ie.chrischen.irelandstatistics.repository;

import ie.chrischen.irelandstatistics.model.PermitsCompany2023;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermitsCompanyRepository extends MongoRepository<PermitsCompany2023, ObjectId> {
    Optional<PermitsCompany2023> findByEmployerContainsIgnoreCase(String employer);
}
