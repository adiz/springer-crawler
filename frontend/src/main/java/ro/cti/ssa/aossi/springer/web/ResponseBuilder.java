package ro.cti.ssa.aossi.springer.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ResponseBuilder {

    void buildWithMessagesWrapper(HttpServletResponse response, int httpStatusCode, String[] messages) throws IOException;

    void build(HttpServletResponse response, int httpStatusCode, Object object) throws IOException;
}
