package ie.chrischen.irelandstatistics.controller.permit;

import ie.chrischen.irelandstatistics.common.ResponseEntityUtils;
import ie.chrischen.irelandstatistics.dto.IDTO;
import ie.chrischen.irelandstatistics.service.permit.PermitsCountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employment-permit/county")
public class PermitsCountyController {
    private PermitsCountyService permitsCountyService;

    @Autowired
    public void setPermitsCountyService(PermitsCountyService permitsCountyService) {
        this.permitsCountyService = permitsCountyService;
    }

    @GetMapping("/{year}")
    public ResponseEntity<List<IDTO>> getPermitsCountyByYear(@PathVariable String year) {
        var res = ResponseEntityUtils.checkEssentialParams(year);
        if(res != null) return res;
        List<IDTO> data = permitsCountyService.getAll(year);
        return data == null || data.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/{year}/{county}")
    public ResponseEntity<List<IDTO>> getPermitsCountyByName(@PathVariable String year, @PathVariable String county) {
        var res = ResponseEntityUtils.checkEssentialParams(year, county);
        if(res != null) return res;
        List<IDTO> data = permitsCountyService.findByName(year, county);
        return data == null || data.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(data, HttpStatus.OK);
    }
}
