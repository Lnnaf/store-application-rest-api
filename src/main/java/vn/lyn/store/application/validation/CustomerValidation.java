package vn.lyn.store.application.validation;

import lombok.val;
import org.apache.commons.lang3.StringUtils;
import vn.lyn.store.application.bo.commonObj.ValidationMessage;
import vn.lyn.store.application.payload.req.CustomerReq;
import vn.lyn.store.application.payload.res.ValidationRes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerValidation {

    public static ValidationRes validator(CustomerReq customerReq){
        List<ValidationMessage> messages = new ArrayList<>();
        ValidationRes validRes = new ValidationRes();

        var name = customerReq.getName();
        var age = customerReq.getAge();

        if(StringUtils.isBlank(name)){
            messages.add(new ValidationMessage("name","name is mandatory"));
        }

        if(age != 0 && age < 18 || age > 150){
            messages.add(new ValidationMessage("age","age is not in range 18 - 150"));
        }
        validRes.setTimeStamp(new Date());
        validRes.setMessages(messages);

        return validRes;
    }
}
