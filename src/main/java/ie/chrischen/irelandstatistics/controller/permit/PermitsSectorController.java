package ie.chrischen.irelandstatistics.controller.permit;

import ie.chrischen.irelandstatistics.common.ResponseEntityUtils;
import ie.chrischen.irelandstatistics.dto.IDTO;
import ie.chrischen.irelandstatistics.service.permit.PermitsSectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employment-permit/sector")
public class PermitsSectorController {
    private PermitsSectorService permitsSectorService;
    @Autowired
    public void setPermitsSectorService(PermitsSectorService permitsSectorService) {
        this.permitsSectorService = permitsSectorService;
    }

    @GetMapping
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @GetMapping("/{year}")
    public ResponseEntity<List<IDTO>> getPermitsSectorByYear(@PathVariable String year) {
        var res = ResponseEntityUtils.checkEssentialParams(year);
        if(res != null) return res;

        List<IDTO> data = permitsSectorService.getAll(year);
        return data == null || data.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/{year}/{sector}")
    public ResponseEntity<List<IDTO>> getPermitsSectorBySectorName(@PathVariable String year, @PathVariable String sector) {
        var res = ResponseEntityUtils.checkEssentialParams(year, sector);
        if(res != null) return res;

        List<IDTO> data = permitsSectorService.findByName(year, sector);
        return data == null || data.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(data, HttpStatus.OK);
    }
}
