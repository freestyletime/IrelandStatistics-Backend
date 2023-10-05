package ie.chrischen.irelandstatistics.dto.permit;

import ie.chrischen.irelandstatistics.model.permit.PermitsCompany;
import ie.chrischen.irelandstatistics.model.permit.PermitsNationality;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {
    public PermitsCompanyDTO toPermitsCompanyDTO(PermitsCompany pc) {
        List<Integer> monthCount = new ArrayList<>();
        PermitsCompanyDTO dto = new PermitsCompanyDTO(pc.getId(), pc.getEmployer(), pc.getYear(), pc.getCount(), monthCount);
        monthCount.add(pc.getJan());
        monthCount.add(pc.getFeb());
        monthCount.add(pc.getMar());
        monthCount.add(pc.getApr());
        monthCount.add(pc.getMay());
        monthCount.add(pc.getJun());
        monthCount.add(pc.getJul());
        monthCount.add(pc.getAug());
        monthCount.add(pc.getSep());
        monthCount.add(pc.getOct());
        monthCount.add(pc.getNov());
        monthCount.add(pc.getDec());
        return dto;
    }

    public PermitsNationalityDTO toPermitsNationalityDTO(PermitsNationality pn) {
        return new PermitsNationalityDTO(pn.getId(), pn.getNationality(), pn.getYear(), pn.getIssued(), pn.getRefused(), pn.getWithdrawn());
    }
}
