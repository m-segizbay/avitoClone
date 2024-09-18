package kz.segizbay.buysell.Services;

import kz.segizbay.buysell.models.Image;
import kz.segizbay.buysell.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public Optional<Image> getFindById(Long id){
        return imageRepository.findById(id);
    }
}
