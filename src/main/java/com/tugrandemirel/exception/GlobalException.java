package com.tugrandemirel.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleArgumentNotValidException(MethodArgumentNotValidException exception) {
        Map<String, List<String>> errorsMap = new HashMap<>();
        List<ObjectError> errors = exception.getBindingResult().getAllErrors();

       for (ObjectError error: errors) {
          String fieldName = ((FieldError) error).getField();
          if (errorsMap.containsKey(fieldName)) {
                errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), error.getDefaultMessage()));
          } else {
                errorsMap.put(fieldName, addMapValue(new ArrayList<>(), error.getDefaultMessage()));
          }
       }
       return ResponseEntity.badRequest().body(createApiError(errorsMap));
    }

    private List<String> addMapValue(List<String> list, String newValue) {
        list.add(newValue);
        return list;
    }

    private ApiError createApiError(Map<String, List<String>> errorsMap) {
        ApiError apiError = new ApiError();
        // UUID
        apiError.setId(UUID.randomUUID().toString());
        apiError.setErrorTime(new Date());
        apiError.setErrors(errorsMap);
        return apiError;
    }
}
