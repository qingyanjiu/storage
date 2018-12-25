package stream.mokulive.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import stream.mokulive.storage.service.IAccessTokenService;
import stream.mokulive.storage.vo.AccessToken;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/token")
@Controller
public class AccessTokenController {

    @Autowired
    private IAccessTokenService accessTokenService;

    @RequestMapping("get")
    @ResponseBody
    public Map get() {
    	Map result = new HashMap();
        AccessToken accessToken = accessTokenService.getAccessToken();
        result.put("accessToken",accessToken.getAccessToken());
    	return result;
    }

    @RequestMapping("update")
    @ResponseBody
    public Map update() {
    	Map result = new HashMap();
        try {
            accessTokenService.updateAccessToken();
            result.put("success",true);
        } catch (Exception e) {
            result.put("success",false);
        }
        return result;
    }

}
