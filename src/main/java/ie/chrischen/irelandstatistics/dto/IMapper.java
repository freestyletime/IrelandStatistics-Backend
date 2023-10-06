package ie.chrischen.irelandstatistics.dto;

import ie.chrischen.irelandstatistics.model.IModel;

public interface IMapper<E extends IModel> {
    IDTO toDTO(E model);
}
