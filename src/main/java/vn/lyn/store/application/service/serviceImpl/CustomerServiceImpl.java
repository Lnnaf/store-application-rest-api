package vn.lyn.store.application.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.lyn.store.application.bo.entity.CustomerEntity;
import vn.lyn.store.application.repository.CustomerEntityDao;
import vn.lyn.store.application.service.CustomerService;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerEntityDao customerEntityDao;

    @Override
    public List<CustomerEntity> getAll() {
        return customerEntityDao.findAll();
    }


    @Override
    public CustomerEntity save(CustomerEntity customer) {
        return customerEntityDao.save(customer);
    }

    @Override
    public void delete(CustomerEntity customer) {
         customerEntityDao.delete(customer);
    }

    @Override
    public Boolean isExistById(Long id) {
        return customerEntityDao.existsById(id);
    }

    @Override
    public CustomerEntity update(CustomerEntity entity) {
        return customerEntityDao.save(entity);
    }


}
