package vn.lyn.store.application.converter;

import vn.lyn.store.application.bo.entity.CustomerEntity;
import vn.lyn.store.application.payload.req.CustomerReq;


public class CustomerReqConverter {
    public static CustomerEntity converter(CustomerReq customerReq){
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setName(customerReq.getName());
        customerEntity.setAge(customerReq.getAge());

        return customerEntity;
    }
}
