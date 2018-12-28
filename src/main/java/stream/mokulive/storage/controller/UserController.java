package stream.mokulive.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public Map checkUser(@PathVariable("userId") String userId) throws Exception {
    	Map result = new HashMap();
        Auth0User user = null;
        user = userService.checkUser(userId);
        result.put("user", user);
    	return result;
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public Map add(@RequestBody Auth0User user) throws Exception {
    	Map result = new HashMap();
        userService.addUser(user);
        return result;
    }

}
