package stream.mokulive.storage.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class BuildingController {

    @RequestMapping("updateImage")
    @ResponseBody
    public Map updateImage(String startX, String endX, String startY, String endY) {
    	Map map = new HashMap();
    	return map;
    }

}
