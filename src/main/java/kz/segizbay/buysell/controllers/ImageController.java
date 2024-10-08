package kz.segizbay.buysell.controllers;

import kz.segizbay.buysell.Services.ImageService;
import kz.segizbay.buysell.models.Image;
import kz.segizbay.buysell.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImageByID(@PathVariable Long id){
        Image image = imageService.getFindById(id).orElse(null);
        System.out.println(image.getSize());
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
}
