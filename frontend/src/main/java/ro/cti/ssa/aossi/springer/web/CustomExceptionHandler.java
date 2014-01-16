package ro.cti.ssa.aossi.springer.web;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomExceptionHandler implements HandlerExceptionResolver{

    private Logger logger = Logger.getLogger(getClass());

    private ResponseBuilder responseBuilder;

    @Autowired
    public CustomExceptionHandler(ResponseBuilder responseBuilder) {
        this.responseBuilder = responseBuilder;
    }

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        try{

            logger.error(ex.getMessage(), ex);

            if(ex instanceof ControllerException){
                ControllerException e = (ControllerException)ex;
                responseBuilder.buildWithMessagesWrapper(response, e.getHttpStatusToRespond(), e.getMessages());
            }
            else if(ex instanceof AccessDeniedException){
                responseBuilder.buildWithMessagesWrapper(response, HttpServletResponse.SC_FORBIDDEN,
                        new String[]{ "Forbidden" });
            }
            else if(ex instanceof IllegalArgumentException){
                responseBuilder.buildWithMessagesWrapper(response, HttpServletResponse.SC_BAD_REQUEST,
                        new String[]{ ex.getMessage() });
            }
            else {
                responseBuilder.buildWithMessagesWrapper(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                        new String[]{ "Internal Server Error" } );
            }
        } catch (Exception handlerException) {
			logger.warn("Handling of [" + ex.getClass().getName() + "] resulted in Exception", handlerException);
		}
        return new ModelAndView();
    }

}
