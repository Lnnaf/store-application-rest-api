package vn.lyn.store.application.payload.res;

import lombok.Getter;
import lombok.Setter;
import vn.lyn.store.application.bo.commonObj.ValidationMessage;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ValidationRes {
    Date timeStamp;
    List<ValidationMessage> messages;
}
