package pl.xavras.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.xavras.domain.Owner;
import pl.xavras.infrastructure.database.entity.OwnerEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OwnerEntityMapper {


     Owner mapFromEntity(OwnerEntity entity);

}
