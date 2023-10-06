package ie.chrischen.irelandstatistics.service.permit;

import ie.chrischen.irelandstatistics.dto.IDTO;
import ie.chrischen.irelandstatistics.dto.permit.Mapper;
import ie.chrischen.irelandstatistics.model.permit.PermitsNationality;
import ie.chrischen.irelandstatistics.repository.permit.PermitsNationalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermitsNationalityService {
    private Mapper<PermitsNationality> mapper;
    private PermitsNationalityRepository permitsNationalityRepository;
    @Autowired
    public void setMapper(Mapper<PermitsNationality> mapper) {
        this.mapper = mapper;
    }
    @Autowired
    public void setPermitsNationalityRepository(PermitsNationalityRepository permitsNationalityRepository) {
        this.permitsNationalityRepository = permitsNationalityRepository;
    }

    public List<IDTO> findByName(String year, String nationality) {
        Optional<List<PermitsNationality>> data = this.permitsNationalityRepository
                .findByYearAndNationalityStartsWith(year, nationality);
        return data.map(pn -> pn.stream().map(mapper::toDTO).toList()).orElse(null);
    }

    public List<IDTO> getAll(String year) {
        Optional<List<PermitsNationality>> data = this.permitsNationalityRepository.findByYear(year);
        return data.map(pn -> pn.stream().map(mapper::toDTO).toList()).orElse(null);
    }
}