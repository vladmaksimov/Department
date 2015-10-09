package com.department.utils.validator;

import com.department.exeption.ValidateException;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataValidator {
    private Validator validator = new Validator();
    private Map<String, String> errors = new HashMap<String, String>();

    public Map<String, String> validate(Object o) throws ValidateException {
        List<ConstraintViolation> violations = validator.validate(o);
        for (ConstraintViolation violation : violations) {
            String contextName = violation.getContext().toString();
            String errorName = contextName.substring(contextName.lastIndexOf(".") + 1);
            errors.put(errorName, violation.getMessage());
        }
        return errors;
    }

}
