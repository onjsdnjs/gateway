package com.blueocn.api.controller.rest.admin.consumer;

import com.blueocn.api.controller.rest.AbstractResponseController;
import com.blueocn.api.kong.model.Consumer;
import com.blueocn.api.kong.model.Consumers;
import com.blueocn.api.response.RestfulResponse;
import com.blueocn.api.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: RestConsumerController
 * Description:
 *
 * @author Yufan
 * @version 1.0.0
 * @since 2016-03-02 14:25
 */
@RestController
@RequestMapping("admin/consumer")
public class RestConsumerController extends AbstractResponseController {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public RestfulResponse<String> save(Consumer consumer) {
        return consumerService.save(consumer);
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public Consumers queryConsumerList(Consumer consumer) {
        return consumerService.queryAll(consumer);
    }

    @RequestMapping(value = "delete/{consumerId}")
    public RestfulResponse<String> delete(@PathVariable("consumerId") String consumerId) {
        consumerService.delete(consumerId);
        return new RestfulResponse<>();
    }
}
