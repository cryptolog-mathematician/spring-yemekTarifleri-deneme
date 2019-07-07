package springframework.yemektarifleri.yemek_tariflerid_eneme.services;

import springframework.yemektarifleri.yemek_tariflerid_eneme.models.UnitOfMeasure;
import springframework.yemektarifleri.yemek_tariflerid_eneme.repositories.UnitOfMeasureRepository;

import java.util.HashSet;
import java.util.Set;

public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public UnitOfMeasure findById(Long aLong) {
        return unitOfMeasureRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<UnitOfMeasure> findByAll() {
        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        unitOfMeasureRepository.findAll().forEach(unitOfMeasures :: add);
        return null;
    }

    @Override
    public UnitOfMeasure save(UnitOfMeasure object) {

        return unitOfMeasureRepository.save(object);
    }

    @Override
    public void delete(UnitOfMeasure object) {
        unitOfMeasureRepository.delete(object);
    }

    @Override
    public void deletById(Long aLong) {
        unitOfMeasureRepository.deleteById(aLong);
    }
}
