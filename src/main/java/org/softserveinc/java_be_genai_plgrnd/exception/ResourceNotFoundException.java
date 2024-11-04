package org.softserveinc.java_be_genai_plgrnd.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String entityName, String id) {
        super(String.format("%s with id %s was not found", entityName, id));
    }
}
