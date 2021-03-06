package com.wiltech.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Resource not found exception.
 * This exception is to be used to pass three values. The entity the exception was thrown, the field and the value of the field.
 * Eg exception - oportunity - id - 123.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private final String resourceName;
    private final String fieldName;
    private final Object fieldValue;

    /**
     * Instantiates a new Resource not found exception.
     *
     * @param resourceName the resource name
     * @param fieldName    the field name
     * @param fieldValue   the field value
     */
    public ResourceNotFoundException(final String resourceName, final String fieldName, final Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    /**
     * Gets resource name.
     *
     * @return the resource name
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * Gets field name.
     *
     * @return the field name
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Gets field value.
     *
     * @return the field value
     */
    public Object getFieldValue() {
        return fieldValue;
    }
}
