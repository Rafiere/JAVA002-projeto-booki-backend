package com.example.projetobooki.backend.config.exceptions.exceptionsconfig;

import org.apache.commons.lang3.StringUtils;

public abstract class CustomRestException extends RuntimeException {

    public String getTitle(){
        return StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(getClass().getSimpleName()), " ");
    }

    public String getDeveloperMessage(){
        return this.getClass().getSimpleName() + ": " + getDevMessage();
    }

    protected abstract String getDevMessage();

    public CustomRestException(String message){
        super(message);
    }
}
