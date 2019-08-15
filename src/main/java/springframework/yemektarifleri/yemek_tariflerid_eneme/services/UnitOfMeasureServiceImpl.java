package springframework.yemektarifleri.yemek_tariflerid_eneme.services;

import org.springframework.stereotype.Service;
import springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.mapper.UnitOfMeasureMapper;
import springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.model.UnitOfMeasureDTO;
import springframework.yemektarifleri.yemek_tariflerid_eneme.models.UnitOfMeasure;
import springframework.yemektarifleri.yemek_tariflerid_eneme.repositories.UnitOfMeasureRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private UnitOfMeasureRepository unitOfMeasureRepository;
    private UnitOfMeasureMapper unitOfMeasureMapper;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureMapper unitOfMeasureMapper) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureMapper = unitOfMeasureMapper;
    }

    @Override
    public UnitOfMeasureDTO findById(Long aLong) {

        UnitOfMeasure unitOfMeasure = unitOfMeasureRepository.findById(aLong).orElse(null);
        UnitOfMeasureDTO unitOfMeasureDTO = unitOfMeasureMapper.uom2uomDTO(unitOfMeasure);

        return unitOfMeasureDTO;
    }

    @Override
    public Set<UnitOfMeasureDTO> findAll() {
        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        unitOfMeasureRepository.findAll().forEach(unitOfMeasures :: add);

        Set<UnitOfMeasureDTO> unitOfMeasureDTOS = new HashSet<>();
        for (UnitOfMeasure unitOfMeasure : unitOfMeasures) {
            UnitOfMeasureDTO unitOfMeasureDTO = unitOfMeasureMapper.uom2uomDTO(unitOfMeasure);
            unitOfMeasureDTOS.add(unitOfMeasureDTO);
        }
        return unitOfMeasureDTOS;
    }

    @Override
    public UnitOfMeasureDTO save(UnitOfMeasureDTO object) {

        UnitOfMeasure unitOfMeasure = unitOfMeasureMapper.uomDTO2uom(object);
        UnitOfMeasure unitOfMeasureSaved = unitOfMeasureRepository.save(unitOfMeasure);
        UnitOfMeasureDTO unitOfMeasureDTO = unitOfMeasureMapper.uom2uomDTO(unitOfMeasureSaved);

        return unitOfMeasureDTO;
    }

    @Override
    public void delete(UnitOfMeasureDTO object) {

        unitOfMeasureRepository.delete(unitOfMeasureRepository.findById(object.getId()).get());
    }

    @Override
    public void deletById(Long aLong) {

        unitOfMeasureRepository.deleteById(aLong);
    }
}
