package ie.chrischen.irelandstatistics.controller.permit;

import ie.chrischen.irelandstatistics.dto.permit.PermitsNationalityDTO;
import ie.chrischen.irelandstatistics.service.permit.PermitsNationalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employment-permit/nationality")
public class PermitsNationalityController {
    private PermitsNationalityService permitsNationalityService;
    @Autowired
    public void setPermitsNationalityService(PermitsNationalityService permitsNationalityService) {
        this.permitsNationalityService = permitsNationalityService;
    }

    @GetMapping("/{year}")
    public ResponseEntity<List<PermitsNationalityDTO>> getPermitsNationalityByYear(@PathVariable String year) {
        if(year.isBlank()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        List<PermitsNationalityDTO> data = permitsNationalityService.getAll(year);
        return data == null || data.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/{year}/{nationality}")
    public ResponseEntity<List<PermitsNationalityDTO>> getPermitsNationalityByEmployer(@PathVariable String year, @PathVariable String nationality) {
        if(year.isBlank() || nationality.isBlank()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        List<PermitsNationalityDTO> data = permitsNationalityService.findByName(year, nationality);
        return data == null || data.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(data, HttpStatus.OK);
    }
}
