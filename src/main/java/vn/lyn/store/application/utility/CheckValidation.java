package vn.lyn.store.application.utility;

import org.apache.commons.collections4.CollectionUtils;
import vn.lyn.store.application.payload.res.ValidationRes;


public class CheckValidation {
    public static Boolean isNotValid(ValidationRes in){
        return CollectionUtils.isNotEmpty(in.getMessages());
    }
}
