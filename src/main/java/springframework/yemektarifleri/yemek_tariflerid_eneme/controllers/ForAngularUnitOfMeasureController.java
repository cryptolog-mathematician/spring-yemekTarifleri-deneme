package springframework.yemektarifleri.yemek_tariflerid_eneme.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.model.UnitOfMeasureDTO;
import springframework.yemektarifleri.yemek_tariflerid_eneme.services.UnitOfMeasureServiceImpl;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/unitOfMeasure", produces = "application/json")
public class ForAngularUnitOfMeasureController {

    private UnitOfMeasureServiceImpl unitOfMeasureService;

    public ForAngularUnitOfMeasureController(UnitOfMeasureServiceImpl unitOfMeasureService) {
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UnitOfMeasureDTO getUomById(@PathVariable Long id) {
        return unitOfMeasureService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<UnitOfMeasureDTO> getAllUOM() {
        return unitOfMeasureService.findAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public UnitOfMeasureDTO saveUofM(@RequestBody UnitOfMeasureDTO unitOfMeasureDTO) {
        return unitOfMeasureService.save(unitOfMeasureDTO);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletById(@PathVariable Long id) {
        unitOfMeasureService.deletById(id);
    }
}
