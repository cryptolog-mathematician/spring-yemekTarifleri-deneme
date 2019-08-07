package springframework.yemektarifleri.yemek_tariflerid_eneme.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    void saveImageFile(Long recipeId, MultipartFile file);

}
