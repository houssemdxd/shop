package com.project.shop.service.image;

import com.project.shop.dto.ImageDto;
import com.project.shop.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IImageservice {

    Image GetImageById(Long id );
    void DeleteImageById(Long id);
    List<ImageDto> SaveImage(List<MultipartFile> file , Long productId);
    void updateImage(Long imageId ,MultipartFile file) throws IOException;


}
