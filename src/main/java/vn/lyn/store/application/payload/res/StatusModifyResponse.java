package vn.lyn.store.application.payload.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.lyn.store.application.Enum.StatusModify;
import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatusModifyResponse {
    private Date timestamp;
    private StatusModify status;
    private String message;
}
