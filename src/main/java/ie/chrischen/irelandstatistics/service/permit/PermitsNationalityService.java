package ie.chrischen.irelandstatistics.service.permit;

import ie.chrischen.irelandstatistics.common.Constants;
import ie.chrischen.irelandstatistics.dto.IDTO;
import ie.chrischen.irelandstatistics.dto.permit.PermitsMapper;
import ie.chrischen.irelandstatistics.model.permit.PermitsNationality;
import ie.chrischen.irelandstatistics.repository.permit.PermitsNationalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermitsNationalityService {
    private PermitsMapper<PermitsNationality> permitsMapper;
    private PermitsNationalityRepository permitsNationalityRepository;
    @Autowired
    public void setMapper(PermitsMapper<PermitsNationality> permitsMapper) {
        this.permitsMapper = permitsMapper;
    }
    @Autowired
    public void setPermitsNationalityRepository(PermitsNationalityRepository permitsNationalityRepository) {
        this.permitsNationalityRepository = permitsNationalityRepository;
    }

    public List<IDTO> findByName(String year, String nationality) {
        Optional<List<PermitsNationality>> data = this.permitsNationalityRepository
                .findByYearAndNationalityStartsWith(year, nationality);
        return data.map(pn -> pn.stream().map(permitsMapper::toDTO).toList()).orElse(null);
    }

    public List<IDTO> getAll(String year) {
        Optional<List<PermitsNationality>> data = this.permitsNationalityRepository.findByYearOrderByIssuedDesc(year);
        return data.map(pn -> pn.stream().filter(c -> !c.getNationality().equals(Constants.Field_GrandTotal)).map(permitsMapper::toDTO).toList()).orElse(null);
    }
}
