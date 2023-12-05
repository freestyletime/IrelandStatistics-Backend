package ie.chrischen.irelandstatistics.repository.permit;

import ie.chrischen.irelandstatistics.model.permit.PermitsCounty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermitsCountyRepository extends MongoRepository<PermitsCounty, Object> {

    Optional<List<PermitsCounty>> findByYearAndCountyContainingIgnoreCase(String year, String nationality);

    Optional<List<PermitsCounty>> findByYearOrderByIssued(String year);
}
