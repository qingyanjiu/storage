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
    public Map get() throws Exception{
    	Map result = new HashMap();
        AccessToken accessToken = accessTokenService.getAccessToken();
            if(accessToken != null){
                result.put("accessToken",accessToken.getAccessToken());
            }
            else {
                result.put("accessToken",null);
            }
    	return result;
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
        public Map update() throws Exception{
    	Map result = new HashMap();
        accessTokenService.updateAccessToken();
        return result;
    }

}
