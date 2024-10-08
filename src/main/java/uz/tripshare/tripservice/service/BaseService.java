package uz.tripshare.tripservice.service;
import uz.tripshare.domain.BaseClass;
import uz.tripshare.tripservice.domain.entity.BaseEntity;

import java.util.List;

public interface BaseService<E extends BaseEntity, Resp extends BaseClass, Req> {

    Resp save(Req request);

    Resp update(Integer id, Req request);

    Resp findById(Integer id);

    List<Resp> findAll();

    void delete(Integer id);

    Resp mapEntityToResponse(E entity);

    List<Resp> mapListToResponse(List<E> entities);

    E mapRequestToEntity(Req request);
}
