package vn.lyn.store.application.payload.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerReq {
    Long id;
    private String name;
    private int age;
}
