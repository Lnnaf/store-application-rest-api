package vn.lyn.store.application.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.lyn.store.application.bo.entity.ProductItemEntity;
import vn.lyn.store.application.repository.CustomerEntityDao;
import vn.lyn.store.application.repository.ProductEntityDao;
import vn.lyn.store.application.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductEntityDao productEntityDao;
    @Override
    public List<ProductItemEntity> getAll() {
        return productEntityDao.findAll();
    }

    @Override
    public ProductItemEntity save(ProductItemEntity object) {
        return null;
    }

    @Override
    public void delete(ProductItemEntity object) {

    }

    @Override
    public Boolean isExistById(Long id) {
        return null;
    }

    @Override
    public ProductItemEntity update(ProductItemEntity object) {
        return null;
    }
}
