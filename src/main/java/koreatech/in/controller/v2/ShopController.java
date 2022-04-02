package koreatech.in.controller.v2;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import koreatech.in.service.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.Map;

@Controller("ShopControllerV2")
@RequestMapping(value="/v2/shops")
public class ShopController {
    @Inject
    private ShopService shopService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity getShops() throws Exception {
        Map<String, Object> map = shopService.getShops();

        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", required = true, paramType = "path", dataType = "int")
    )
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity getShop(@ApiParam(required = true) @PathVariable(value = "id") String id) throws Exception {

        return new ResponseEntity<Map<String, Object>>(shopService.getShop(id), HttpStatus.OK);
    }
}
