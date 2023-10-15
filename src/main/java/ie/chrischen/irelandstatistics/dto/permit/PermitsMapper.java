package ie.chrischen.irelandstatistics.dto.permit;

import ie.chrischen.irelandstatistics.dto.IDTO;
import ie.chrischen.irelandstatistics.dto.IMapper;
import ie.chrischen.irelandstatistics.model.IModel;
import ie.chrischen.irelandstatistics.model.permit.PermitsCompany;
import ie.chrischen.irelandstatistics.model.permit.PermitsCounty;
import ie.chrischen.irelandstatistics.model.permit.PermitsNationality;
import ie.chrischen.irelandstatistics.model.permit.PermitsSector;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PermitsMapper<E extends IModel> implements IMapper<E> {
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
        } else if (model instanceof PermitsSector ps) {
            List<Integer> monthCount = new ArrayList<>();
            PermitsSectorDTO dto = new PermitsSectorDTO(ps.getId(), ps.getSector(), ps.getYear(), ps.getCount(), monthCount);
            monthCount.add(ps.getJan());
            monthCount.add(ps.getFeb());
            monthCount.add(ps.getMar());
            monthCount.add(ps.getApr());
            monthCount.add(ps.getMay());
            monthCount.add(ps.getJun());
            monthCount.add(ps.getJul());
            monthCount.add(ps.getAug());
            monthCount.add(ps.getSep());
            monthCount.add(ps.getOct());
            monthCount.add(ps.getNov());
            monthCount.add(ps.getDec());
            return dto;
        }

        throw new RuntimeException("Did not match the pre-defined models, please check the codebase.");
    }
}
