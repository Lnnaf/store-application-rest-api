package vn.lyn.store.application.bo.commonObj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ValidationMessage {
    private String field;
    private String message;
}
