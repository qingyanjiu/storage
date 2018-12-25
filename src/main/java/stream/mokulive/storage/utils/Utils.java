package stream.mokulive.storage.utils;

import java.util.Map;

public class Utils {

    public static Map tagResult(Map result, boolean trueOrFalse) {
        result.put("success",trueOrFalse);
        return result;
    }
}
