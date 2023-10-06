package ie.chrischen.irelandstatistics.controller.permit;

import ie.chrischen.irelandstatistics.dto.IDTO;
import ie.chrischen.irelandstatistics.service.permit.PermitsCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employment-permit/company")
public class PermitsCompanyController {
    private PermitsCompanyService permitsCompanyService;
    @Autowired
    public void setPermitsCompanyService(PermitsCompanyService permitsCompanyService) {
        this.permitsCompanyService = permitsCompanyService;
    }

    @GetMapping("/{year}")
    public ResponseEntity<List<IDTO>> getPermitsCompanyByYear(@PathVariable String year) {
        if(year.isBlank()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        List<IDTO> data = permitsCompanyService.getAll(year);
        return data == null || data.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/{year}/{employer}")
    public ResponseEntity<List<IDTO>> getPermitsCompanyByEmployer(@PathVariable String year, @PathVariable String employer) {
        if(year.isBlank() || employer.isBlank()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        List<IDTO> data = permitsCompanyService.findByName(year, employer);
        return data == null || data.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(data, HttpStatus.OK);
    }
}
