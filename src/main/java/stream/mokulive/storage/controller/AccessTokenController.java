package stream.mokulive.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import stream.mokulive.storage.service.IAccessTokenService;
import stream.mokulive.storage.utils.Utils;
import stream.mokulive.storage.vo.AccessToken;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/token")
@Controller
public class AccessTokenController {

    @Autowired
    private IAccessTokenService accessTokenService;

    @RequestMapping(value = "get",method = RequestMethod.POST)
    @ResponseBody
    public Map get() {
    	Map result = new HashMap();
        AccessToken accessToken = null;
        try {
            accessToken = accessTokenService.getAccessToken();
            if(accessToken != null){
                Utils.tagResult(result,true);
                result.put("accessToken",accessToken.getAccessToken());
            }
            else {
                Utils.tagResult(result,false);
            }
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }

    	return result;
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Map update() {
    	Map result = new HashMap();
        try {
            accessTokenService.updateAccessToken();
            Utils.tagResult(result,true);
        } catch (Exception e) {
            Utils.tagResult(result,false);
        }
        return result;
    }

}
