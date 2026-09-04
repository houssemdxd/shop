package com.project.shop.service.image;

import com.project.shop.dto.ImageDto;
import com.project.shop.exception.ResourceNotFoundException;
import com.project.shop.model.Image;
import com.project.shop.model.Product;
import com.project.shop.repository.ImageRepository;
import com.project.shop.service.product.IProductService;
import com.project.shop.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService  implements  IImageservice{

private final  ImageRepository imageRepository;
private final IProductService productService;

    @Override
    public Image GetImageById(Long id) {
        return imageRepository.findById(id).orElseThrow(() ->{throw new ResourceNotFoundException("image not found ");} );
    }

    @Override
    public void DeleteImageById(Long id) {
        imageRepository.findById(id).ifPresentOrElse(imageRepository::delete,()->{throw new ResourceNotFoundException("Image not found");});
    }

    @Override
    public List<ImageDto> SaveImage(List<MultipartFile> files, Long productId) {
        Product product = productService.getProductById(productId);
        List<ImageDto> images = new ArrayList<>();
        for (MultipartFile file : files ){
            try{
                Image image = new Image();
                image.setFileName(file.getOriginalFilename());
                image.setFileType(file.getContentType());
                image.setImageData(file.getBytes());
                image.setProduct(product);
                String buildDownloadUrl= "/api/v1/images/image/download/";
                Image savedImage =  imageRepository.save(image);
               savedImage.setDownloadUrl(buildDownloadUrl+savedImage.getId());
               imageRepository.save(savedImage);
               ImageDto imageDto =  new ImageDto();
               imageDto.setId(savedImage.getId());
               imageDto.setFileName(savedImage.getFileName());
               imageDto.setDownloadUrl(savedImage.getDownloadUrl());
               images.add(imageDto);



            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        return images;
    }

    @Override
    public void updateImage(Long imageId, MultipartFile file) {
        Image image = this.GetImageById(imageId);

        try {
            image.setFileType(file.getContentType());
            image.setImageData(file.getBytes());
            image.setFileName(file.getOriginalFilename());

            imageRepository.save(image);

        } catch (IOException e) {
            throw new RuntimeException("Failed to update image", e);
        }
    }
}
