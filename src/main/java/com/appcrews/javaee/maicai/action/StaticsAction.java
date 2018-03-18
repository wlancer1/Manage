package com.appcrews.javaee.maicai.action;

import com.appcrews.javaee.maicai.service.baseService;
import com.appcrews.javaee.maicai.service.orderService;
import com.appcrews.javaee.maicai.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class StaticsAction extends BaseAction{
    private  int buyer,seller;

    @Autowired
    public void setService(userService service) {
        super.setService(service);
    }
    @Autowired
    public void setService(orderService service) {
        super.setService(service);
    }
    public String userStatic(){

        buyer=((userService)service).getcount(0);
        seller=((userService)service).getcount(1);
        getRequest().setAttribute("buyer",this.buyer);
        getRequest().setAttribute("seller",this.seller);

           return  "success";
    }

}
