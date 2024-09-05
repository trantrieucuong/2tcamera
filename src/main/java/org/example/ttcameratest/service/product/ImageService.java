package org.example.ttcameratest.service.product;

import lombok.AllArgsConstructor;
import org.example.ttcameratest.entity.product.Image;
import org.example.ttcameratest.repos.product.ImageRepos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ImageService {
    private final ImageRepos imageRepos;
    public List<Image> getImage(int id) {
        // Sử dụng phương thức đã sửa để tìm ảnh theo ID sản phẩm
        return imageRepos.findAllByProductId(id);
    }
}
