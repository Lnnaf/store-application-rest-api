package vn.lyn.store.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.lyn.store.application.bo.entity.ProductItemEntity;
import vn.lyn.store.application.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class ProductController {
    private static final String REQ_IS_NULL_MESSAGE = "Request object is null, can not resolve!";
    @Autowired
    ProductService productService;


    @GetMapping("/all-product")
    public ResponseEntity<List<ProductItemEntity>> getAllProduct(){
        List<ProductItemEntity> products = productService.getAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

//    @PostMapping("/add-new-customer")
//    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody CustomerReq customerReq){
//
//        ValidationRes validRes = CustomerValidation.validator(customerReq);
//
//        if(CheckValidation.isNotValid(validRes)){
//            return new ResponseEntity<>(validRes, HttpStatus.OK);
//        }
//
//        if(customerReq.getName() == null){
//            return new ResponseEntity<>(new StatusModifyResponse(new Date(), StatusModify.E, REQ_IS_NULL_MESSAGE), HttpStatus.OK);
//        }
//        CustomerEntity customer = customerService.save(CustomerReqConverter.converter(customerReq));
//
//        if(customer != null){
//            return new ResponseEntity<>(new StatusModifyResponse(new Date(), StatusModify.S, null ), HttpStatus.OK);
//        }else{
//            String message = String.format("Can't persist Customer %s", customerReq.getName());
//            return new ResponseEntity<>(new StatusModifyResponse(new Date(), StatusModify.E, message), HttpStatus.OK);
//        }
//
//    }
//
//    @PostMapping("/delete-customer")
//    public ResponseEntity<?> deleteCustomer(@Valid @RequestBody CustomerReq customerReq){
//        customerService.delete(CustomerReqConverter.converter(customerReq));
//        String message = "Success!";
//        if(customerReq.getId() == null){
//            message = String.format("Id of customer: [%s] must not be null", customerReq.getName());
//            return new ResponseEntity<>(new StatusModifyResponse(new Date(), StatusModify.E, message), HttpStatus.OK);
//        }
//        if(customerService.isExistById(customerReq.getId())){
//            message = String.format("Can't delete Customer %s", customerReq.getName());
//            return new ResponseEntity<>(new StatusModifyResponse(new Date(), StatusModify.E, message), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(new StatusModifyResponse(new Date(), StatusModify.E, message), HttpStatus.OK);
//    }
//
//    @PostMapping("/edit-customer")
//    public ResponseEntity<?> editCustomer(@Valid @RequestBody CustomerReq customerReq){
//        CustomerEntity customerConverted = CustomerReqConverter.converter(customerReq);
//        CustomerEntity customerResult = customerService.update(customerConverted);
//        String message = "";
//        if(customerResult.equals(customerConverted)){
//            message = "updated!";
//            return new ResponseEntity<>(new StatusModifyResponse(new Date(), StatusModify.S, message), HttpStatus.OK);
//        }else {
//            message = "Error!";
//            return new ResponseEntity<>(new StatusModifyResponse(new Date(), StatusModify.E, message), HttpStatus.OK);
//        }
//
//    }

}
