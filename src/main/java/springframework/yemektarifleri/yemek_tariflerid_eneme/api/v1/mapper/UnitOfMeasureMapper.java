package springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.model.UnitOfMeasureDTO;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.UnitOfMeasure;

@Mapper
public interface UnitOfMeasureMapper {

    UnitOfMeasureMapper INSTANCE = Mappers.getMapper(UnitOfMeasureMapper.class);

    UnitOfMeasure uomDTO2uom(UnitOfMeasureDTO unitOfMeasureDTO);

    UnitOfMeasureDTO uom2uomDTO(UnitOfMeasure unitOfMeasure);
}
