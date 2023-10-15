package ie.chrischen.irelandstatistics.service.permit;

import ie.chrischen.irelandstatistics.dto.IDTO;
import ie.chrischen.irelandstatistics.dto.permit.PermitsMapper;
import ie.chrischen.irelandstatistics.model.permit.PermitsCompany;
import ie.chrischen.irelandstatistics.repository.permit.PermitsCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermitsCompanyService {
    private PermitsMapper<PermitsCompany> permitsMapper;
    private PermitsCompanyRepository permitsCompanyRepository;

    @Autowired
    public void setMapper(PermitsMapper<PermitsCompany> permitsMapper) {
        this.permitsMapper = permitsMapper;
    }

    @Autowired
    public void setPermitsCompanyRepository(PermitsCompanyRepository permitsCompanyRepository) {
        this.permitsCompanyRepository = permitsCompanyRepository;
    }

    public List<IDTO> findByName(String year, String employer, Pageable paging) {
        Optional<List<PermitsCompany>> data = this.permitsCompanyRepository
                .findByYearEqualsAndEmployerStartsWith(year, employer, paging);
        return data.map(pc -> pc.stream().map(permitsMapper::toDTO).toList()).orElse(null);
    }

    public List<IDTO> getAll(String year, Pageable paging) {
        Optional<List<PermitsCompany>> data = this.permitsCompanyRepository.findByYear(year, paging);
        return data.map(pc -> pc.stream().map(permitsMapper::toDTO).toList()).orElse(null);
    }
}
