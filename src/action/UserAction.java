package action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entity.User;
import service.UserService;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: kuchi
 * Date: 2018/1/12
 * Time: 14:18
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
    private User user = new User();
    private UserService userService;
    private JSONArray returndata;
    private JSONObject data;

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public JSONArray getReturndata() {
        return returndata;
    }

    public void setReturndata(JSONArray returndata) {
        this.returndata = returndata;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getModel() {
        if(user==null){
            user = new User();
        }
        return user;
    }

    public String showRecords(){
        List<User> list = userService.showRecords();
        returndata = JSONArray.parseArray(JSON.toJSONString(list));
        return "show";
    }

    public String Login() {
        Map result = new HashMap();
        if (userService.Login(user.getUsername(),user.getPassword())){
            Map<String,Object> session = ActionContext.getContext().getSession();
//            session.put("username",user.getUsername());
//            result.put("result","success");
            return "success";
        }else {
            result.put("result","error");
            data = JSONObject.parseObject(JSON.toJSONString(result));
            return "result";
        }

    }
}
