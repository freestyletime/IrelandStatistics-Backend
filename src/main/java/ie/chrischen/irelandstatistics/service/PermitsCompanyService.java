package ie.chrischen.irelandstatistics.service;

import ie.chrischen.irelandstatistics.model.PermitsCompany2023;
import ie.chrischen.irelandstatistics.repository.PermitsCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermitsCompanyService {
    private PermitsCompanyRepository permitsCompanyRepository;

    @Autowired
    public void setPermitsCompanyRepository(PermitsCompanyRepository permitsCompanyRepository) {
        this.permitsCompanyRepository = permitsCompanyRepository;
    }

    public Optional<PermitsCompany2023> findByName(String employer) {
        return this.permitsCompanyRepository.findByEmployerContainsIgnoreCase(employer);
    }

    public List<PermitsCompany2023> getAll() {
        return this.permitsCompanyRepository.findAll();
    }
}
