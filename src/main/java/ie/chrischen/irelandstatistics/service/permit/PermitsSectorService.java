package ie.chrischen.irelandstatistics.service.permit;

import ie.chrischen.irelandstatistics.common.Constants;
import ie.chrischen.irelandstatistics.dto.IDTO;
import ie.chrischen.irelandstatistics.dto.permit.PermitsMapper;
import ie.chrischen.irelandstatistics.model.permit.PermitsSector;
import ie.chrischen.irelandstatistics.repository.permit.PermitsSectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermitsSectorService {
    private PermitsMapper<PermitsSector> permitsMapper;
    private PermitsSectorRepository permitsSectorRepository;

    @Autowired
    public void setMapper(PermitsMapper<PermitsSector> permitsMapper) {
        this.permitsMapper = permitsMapper;
    }

    @Autowired
    public void setPermitsSectorRepository(PermitsSectorRepository permitsSectorRepository) {
        this.permitsSectorRepository = permitsSectorRepository;
    }

    public List<IDTO> findByName(String year, String sector) {
        Optional<List<PermitsSector>> data = this.permitsSectorRepository
                .findByYearEqualsAndSectorStartsWith(year, sector);
        return data.map(pc -> pc.stream().map(permitsMapper::toDTO).toList()).orElse(null);
    }

    public List<IDTO> getAll(String year) {
        Optional<List<PermitsSector>> data = this.permitsSectorRepository.findByYear(year);
        return data.map(pc -> pc.stream().filter(c -> !c.getSector().equals(Constants.Field_GrandTotal)).map(permitsMapper::toDTO).toList()).orElse(null);
    }
}
