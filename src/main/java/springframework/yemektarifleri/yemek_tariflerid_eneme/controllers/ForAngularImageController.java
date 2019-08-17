package springframework.yemektarifleri.yemek_tariflerid_eneme.controllers;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springframework.yemektarifleri.yemek_tariflerid_eneme.api.v1.model.RecipeDTO;
import springframework.yemektarifleri.yemek_tariflerid_eneme.services.ImageServiceImpl;
import springframework.yemektarifleri.yemek_tariflerid_eneme.services.RecipeService;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/imag")
public class ForAngularImageController {

    private final RecipeService recipeService;
    private final ImageServiceImpl imageService;

    public ForAngularImageController(RecipeService recipeService, ImageServiceImpl imageService) {
        this.recipeService = recipeService;
        this.imageService = imageService;
    }

    @PostMapping({"/newImage/{id}"})
    @ResponseStatus(HttpStatus.CREATED)
    public void saveImage(@PathVariable Long id, @RequestParam("file") MultipartFile file){
        imageService.saveImageFile(id, file);
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void renderImage(@PathVariable Long id, HttpServletResponse response) throws IOException {
        RecipeDTO recipeDTO = recipeService.findById(id);

        byte[] byteArray = recipeDTO.getImege();

        response.setContentType("image/jpeg");
        InputStream in = new ByteArrayInputStream(byteArray);
        IOUtils.copy(in, response.getOutputStream());
        log.debug("file is: ", response);
    }
}
