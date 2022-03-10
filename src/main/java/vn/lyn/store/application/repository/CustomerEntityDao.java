package vn.lyn.store.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.lyn.store.application.bo.entity.CustomerEntity;

@Repository
public interface CustomerEntityDao extends JpaRepository<CustomerEntity, Long> {
}
