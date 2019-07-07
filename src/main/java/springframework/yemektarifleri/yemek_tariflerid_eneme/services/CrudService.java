package springframework.yemektarifleri.yemek_tariflerid_eneme.services;

import java.util.Set;

public interface CrudService<T, ID> {

    T findById(ID id);

    Set<T> findAll();

    T save(T object);

    void delete(T object);

    void deletById(ID id);

}
