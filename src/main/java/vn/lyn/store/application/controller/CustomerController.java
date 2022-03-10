package vn.lyn.store.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.lyn.store.application.Enum.StatusModify;
import vn.lyn.store.application.bo.entity.CustomerEntity;
import vn.lyn.store.application.converter.CustomerReqConverter;
import vn.lyn.store.application.payload.req.CustomerReq;
import vn.lyn.store.application.payload.res.StatusModifyResponse;
import vn.lyn.store.application.payload.res.ValidationRes;
import vn.lyn.store.application.repository.CustomerEntityDao;
import vn.lyn.store.application.service.CustomerService;
import vn.lyn.store.application.utility.CheckValidation;
import vn.lyn.store.application.validation.CustomerValidation;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/public")
public class CustomerController {
    private static final String REQ_IS_NULL_MESSAGE = "Request object is null, can not resolve!";
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerEntityDao customerEntityDao;


    @GetMapping("/all-customer")
    public ResponseEntity<List<CustomerEntity>> getAllCustomer(){
        List<CustomerEntity> customers = customerService.getAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/add-new-customer")
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody CustomerReq customerReq){

        ValidationRes validRes = CustomerValidation.validator(customerReq);

        if(CheckValidation.isNotValid(validRes)){
            return new ResponseEntity<>(validRes, HttpStatus.OK);
        }

        if(customerReq.getName() == null){
            return new ResponseEntity<>(new StatusModifyResponse(new Date(), StatusModify.E, REQ_IS_NULL_MESSAGE), HttpStatus.OK);
        }
        CustomerEntity customer = customerService.save(CustomerReqConverter.converter(customerReq));

        if(customer != null){
            return new ResponseEntity<>(new StatusModifyResponse(new Date(), StatusModify.S, null ), HttpStatus.OK);
        }else{
            String message = String.format("Can't persist Customer %s", customerReq.getName());
            return new ResponseEntity<>(new StatusModifyResponse(new Date(), StatusModify.E, message), HttpStatus.OK);
        }

    }

    @PostMapping("/delete-customer")
    public ResponseEntity<?> deleteCustomer(@Valid @RequestBody CustomerReq customerReq){
        customerService.delete(CustomerReqConverter.converter(customerReq));
        String message = "Success!";
        if(customerReq.getId() == null){
            message = String.format("Id of customer: [%s] must not be null", customerReq.getName());
            return new ResponseEntity<>(new StatusModifyResponse(new Date(), StatusModify.E, message), HttpStatus.OK);
        }
        if(customerService.isExistById(customerReq.getId())){
            message = String.format("Can't delete Customer %s", customerReq.getName());
            return new ResponseEntity<>(new StatusModifyResponse(new Date(), StatusModify.E, message), HttpStatus.OK);
        }
        return new ResponseEntity<>(new StatusModifyResponse(new Date(), StatusModify.E, message), HttpStatus.OK);
    }

    @PostMapping("/edit-customer")
    public ResponseEntity<?> editCustomer(@Valid @RequestBody CustomerReq customerReq){
        CustomerEntity customerConverted = CustomerReqConverter.converter(customerReq);
        CustomerEntity customerResult = customerService.update(customerConverted);
        String message = "";
        if(customerResult.equals(customerConverted)){
            message = "";
            return new ResponseEntity<>(new StatusModifyResponse(new Date(), StatusModify.S, message), HttpStatus.OK);
        }else {
            message
            return new ResponseEntity<>(new StatusModifyResponse(new Date(), StatusModify.S, message), HttpStatus.OK);
        }

    }

}
