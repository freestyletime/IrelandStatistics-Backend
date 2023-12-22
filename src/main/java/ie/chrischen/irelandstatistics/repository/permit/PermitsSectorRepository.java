package ie.chrischen.irelandstatistics.repository.permit;

import ie.chrischen.irelandstatistics.model.permit.PermitsSector;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermitsSectorRepository extends MongoRepository<PermitsSector, ObjectId> {
    Optional<List<PermitsSector>> findByYearEqualsAndSectorStartsWith(String year, String sector);

    Optional<List<PermitsSector>> findByYearOrderByCountDesc(String year);

    Optional<List<PermitsSector>> findBySectorEqualsIgnoreCase(String sector);
}
