package ie.chrischen.irelandstatistics.service.permit;

import ie.chrischen.irelandstatistics.dto.IDTO;
import ie.chrischen.irelandstatistics.dto.permit.Mapper;
import ie.chrischen.irelandstatistics.model.permit.PermitsSector;
import ie.chrischen.irelandstatistics.repository.permit.PermitsSectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermitsSectorService {
    private Mapper<PermitsSector> mapper;
    private PermitsSectorRepository permitsSectorRepository;

    @Autowired
    public void setMapper(Mapper<PermitsSector> mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setPermitsSectorRepository(PermitsSectorRepository permitsSectorRepository) {
        this.permitsSectorRepository = permitsSectorRepository;
    }

    public List<IDTO> findByName(String year, String sector) {
        Optional<List<PermitsSector>> data = this.permitsSectorRepository
                .findByYearEqualsAndSectorStartsWith(year, sector);
        return data.map(pc -> pc.stream().map(mapper::toDTO).toList()).orElse(null);
    }

    public List<IDTO> getAll(String year) {
        Optional<List<PermitsSector>> data = this.permitsSectorRepository.findByYear(year);
        return data.map(pc -> pc.stream().map(mapper::toDTO).toList()).orElse(null);
    }
}
