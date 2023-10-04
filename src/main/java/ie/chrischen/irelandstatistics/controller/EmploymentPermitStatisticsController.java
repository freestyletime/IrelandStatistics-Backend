package ie.chrischen.irelandstatistics.controller;

import ie.chrischen.irelandstatistics.model.PermitsCompany2023;
import ie.chrischen.irelandstatistics.service.PermitsCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employmentpermit")
public class EmploymentPermitStatisticsController {

    private PermitsCompanyService permitsCompanyService;

    @Autowired
    public void setPermitsCompanyService(PermitsCompanyService permitsCompanyService) {
        this.permitsCompanyService = permitsCompanyService;
    }

    @GetMapping("/2023")
    public ResponseEntity<List<PermitsCompany2023>> hello() {
        return new ResponseEntity<>(permitsCompanyService.getAll(), HttpStatus.OK);
    }
}
