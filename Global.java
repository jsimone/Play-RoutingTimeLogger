import play.*;
import play.mvc.*;
import play.mvc.Http.*;
import java.lang.reflect.Method;
import java.util.Date;

public class Global extends GlobalSettings {

    @Override
    public Action onRequest(Request request, Method actionMethod) {
        if(request.getHeader("x-request-start") != null) {        
            Date date = new Date();
            long now = date.getTime();
            long routeTime = now - Long.valueOf(request.getHeader("x-request-start"));
            if(routeTime < 0) routeTime = 0;
            System.out.println("at=metric queue=" + routeTime + "ms");
        }
       return super.onRequest(request, actionMethod);
    }

}