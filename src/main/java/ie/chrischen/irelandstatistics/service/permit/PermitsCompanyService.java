package ie.chrischen.irelandstatistics.service.permit;

import ie.chrischen.irelandstatistics.dto.permit.Mapper;
import ie.chrischen.irelandstatistics.dto.permit.PermitsCompanyDTO;
import ie.chrischen.irelandstatistics.model.permit.PermitsCompany;
import ie.chrischen.irelandstatistics.repository.permit.PermitsCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermitsCompanyService {
    private Mapper mapper;
    private PermitsCompanyRepository permitsCompanyRepository;

    @Autowired
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setPermitsCompanyRepository(PermitsCompanyRepository permitsCompanyRepository) {
        this.permitsCompanyRepository = permitsCompanyRepository;
    }

    public List<PermitsCompanyDTO> findByName(String year, String employer) {
        Optional<List<PermitsCompany>> data = this.permitsCompanyRepository
                .findByYearEqualsAndEmployerStartsWith(year, employer);
        return data.map(pc -> pc.stream().map(mapper::toPermitsCompanyDTO).toList()).orElse(null);
    }

    public List<PermitsCompanyDTO> getAll(String year) {
        Optional<List<PermitsCompany>> data = this.permitsCompanyRepository.findByYear(year);
        return data.map(pc -> pc.stream().map(mapper::toPermitsCompanyDTO).toList()).orElse(null);
    }
}
