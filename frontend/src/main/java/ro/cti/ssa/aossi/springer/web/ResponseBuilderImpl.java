package ro.cti.ssa.aossi.springer.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseBuilderImpl implements ResponseBuilder{

    private ObjectMapper objectMapper;

    @Autowired
    public ResponseBuilderImpl(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    public void buildWithMessagesWrapper(HttpServletResponse response, int httpStatusCode, String[] messages) throws IOException{
        MessagesWrapper errorWrapper = new MessagesWrapper(messages);
        build(response, httpStatusCode, errorWrapper);
    }

    public void build(HttpServletResponse response, int httpStatusCode, Object object) throws IOException {
        response.setStatus(httpStatusCode);
        PrintWriter writer = response.getWriter();

        writer.print(objectMapper.writeValueAsString(object));
    }
}
