package ie.chrischen.irelandstatistics.repository.permit;

import ie.chrischen.irelandstatistics.model.permit.PermitsNationality;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermitsNationalityRepository extends MongoRepository<PermitsNationality, Object> {

    Optional<List<PermitsNationality>> findByYearAndNationalityStartsWith(String year, String nationality);

    Optional<List<PermitsNationality>> findByYearOrderByIssuedDesc(String year);
}
