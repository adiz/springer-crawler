package ro.cti.ssa.aossi.springer.converter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.config.AbstractFactoryBean;


public class ObjectMapperFactoryBean extends AbstractFactoryBean {

    @Override
    public Class getObjectType() {
        return ObjectMapper.class;
    }

    @Override
    protected Object createInstance(){

        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.registerModule(new ObjectMapperSimpleModule());

        return objectMapper;
    }
}
