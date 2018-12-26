package stream.mokulive.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import stream.mokulive.storage.service.IAccessTokenService;
import stream.mokulive.storage.service.IUserService;
import stream.mokulive.storage.utils.Utils;
import stream.mokulive.storage.vo.AccessToken;
import stream.mokulive.storage.vo.Auth0User;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "{userId}",method = RequestMethod.POST)
    @ResponseBody
    public Map checkUser(@PathVariable("userId") String userId) {
    	Map result = new HashMap();
        Auth0User user = null;
        try {
            user = userService.checkUser(userId);
            if(user != null){
                result.put("user",user);
            }
            Utils.tagResult(result,true);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }

    	return result;
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Map add(Auth0User user) {
    	Map result = new HashMap();
        try {
            userService.addUser(user);
            Utils.tagResult(result,true);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

}
