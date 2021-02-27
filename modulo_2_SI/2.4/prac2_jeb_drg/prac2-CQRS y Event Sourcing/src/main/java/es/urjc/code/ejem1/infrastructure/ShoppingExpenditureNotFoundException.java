package es.urjc.code.ejem1.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Shopping expenditure cart not found")
public class ShoppingExpenditureNotFoundException  extends RuntimeException {

    private static final long serialVersionUID = -5596141541624573125L;

}
