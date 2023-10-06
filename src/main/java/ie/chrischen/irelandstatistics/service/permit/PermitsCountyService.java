package ie.chrischen.irelandstatistics.service.permit;

import ie.chrischen.irelandstatistics.dto.IDTO;
import ie.chrischen.irelandstatistics.dto.permit.Mapper;
import ie.chrischen.irelandstatistics.model.permit.PermitsCounty;
import ie.chrischen.irelandstatistics.repository.permit.PermitsCountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermitsCountyService {
    private Mapper<PermitsCounty> mapper;
    private PermitsCountyRepository permitsCountyRepository;
    @Autowired
    public void setMapper(Mapper<PermitsCounty> mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setPermitsCountyRepository(PermitsCountyRepository permitsCountyRepository) {
        this.permitsCountyRepository = permitsCountyRepository;
    }

    public List<IDTO> findByName(String year, String county) {
        Optional<List<PermitsCounty>> data = this.permitsCountyRepository
                .findByYearAndCountyContainingIgnoreCase(year, county);
        return data.map(pc -> pc.stream().map(mapper::toDTO).toList()).orElse(null);
    }

    public List<IDTO> getAll(String year) {
        Optional<List<PermitsCounty>> data = this.permitsCountyRepository.findByYear(year);
        return data.map(pn -> pn.stream().map(mapper::toDTO).toList()).orElse(null);
    }
}