package zhida.business.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import zhida.business.domain.util.ResponseMsgUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class BaseController extends ResponseMsgUtil {
	
	protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
      
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        this.request = request;  
        this.response = response;  
        this.session = request.getSession();  
    }

    public void getmsg(ModelAndView mv, String action){
        if(action!=null && action!=""){
            mv.addObject("ac", action);
        }else{
            mv.addObject("ac", "");
        }

    }

}
