package ie.chrischen.irelandstatistics.dto.permit;

import ie.chrischen.irelandstatistics.dto.IDTO;
import ie.chrischen.irelandstatistics.dto.IMapper;
import ie.chrischen.irelandstatistics.model.IModel;
import ie.chrischen.irelandstatistics.model.permit.PermitsCompany;
import ie.chrischen.irelandstatistics.model.permit.PermitsCounty;
import ie.chrischen.irelandstatistics.model.permit.PermitsNationality;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper<E extends IModel> implements IMapper<E> {
    @Override
    public IDTO toDTO(E model) {
        if(model instanceof PermitsCompany pc) {
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
        } else if(model instanceof PermitsNationality pn) {
            return new PermitsNationalityDTO(pn.getId(), pn.getNationality(), pn.getYear(), pn.getIssued(), pn.getRefused(), pn.getWithdrawn());
        } else if(model instanceof PermitsCounty pc) {
            return new PermitsCountyDTO(pc.getId(), pc.getCounty(), pc.getYear(), pc.getIssued(), pc.getRefused(), pc.getWithdrawn());
        }
        return null;
    }
}
