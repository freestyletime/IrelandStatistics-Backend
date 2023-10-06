package ie.chrischen.irelandstatistics.common;

import ie.chrischen.irelandstatistics.dto.IDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseEntityUtils {

    public static ResponseEntity<List<IDTO>> checkEssentialParams(String ...strs) {
        for(String s : strs) if(s.isBlank())  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return null;
    }
}
