package ie.chrischen.irelandstatistics.controller.permit;

import ie.chrischen.irelandstatistics.common.ResponseEntityUtils;
import ie.chrischen.irelandstatistics.dto.IDTO;
import ie.chrischen.irelandstatistics.service.permit.PermitsCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<IDTO>> getPermitsCompanyByYear(@PathVariable String year,
                                                              @RequestParam(defaultValue= "0", required = false) Integer page ,
                                                              @RequestParam(defaultValue= "50", required = false) Integer pageSize) {
        var res = ResponseEntityUtils.checkEssentialParams(year);
        if(res != null) return res;

        Pageable paging = PageRequest.of(page, pageSize);
        List<IDTO> data = permitsCompanyService.getAll(year, paging);
        return data == null || data.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/{year}/{employer}")
    public ResponseEntity<List<IDTO>> getPermitsCompanyByEmployer(@PathVariable String year,
                                                                  @PathVariable String employer,
                                                                  @RequestParam(defaultValue= "0", required = false) Integer page ,
                                                                  @RequestParam(defaultValue= "50", required = false) Integer pageSize) {
        var res = ResponseEntityUtils.checkEssentialParams(year, employer);
        if(res != null) return res;

        Pageable paging = PageRequest.of(page, pageSize);
        List<IDTO> data = permitsCompanyService.findByName(year, employer, paging);
        return data == null || data.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(data, HttpStatus.OK);
    }
}
