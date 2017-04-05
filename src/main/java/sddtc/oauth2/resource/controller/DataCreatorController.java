package sddtc.oauth2.resource.controller;

import com.google.gson.Gson;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sddtc on 2017/3/31.
 */
@RestController
public class DataCreatorController {

    private Gson gson = new Gson();

    @RequestMapping("/data")
    @PreAuthorize("#oauth2.hasScope('toll_read') and hasAuthority('ROLE_OPERATOR')")
    @ResponseBody
    public String getData() {
        Map<String, String> data = new HashMap<>();

        data.put("name", "sddtc");
        data.put("birth", "0129");

        return gson.toJson(data);
    }
}
