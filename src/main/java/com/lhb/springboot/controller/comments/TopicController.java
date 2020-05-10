package com.lhb.springboot.controller.comments;

import com.lhb.springboot.entity.comments.Topic;
import com.lhb.springboot.service.comments.TopicService;
import com.lhb.springboot.utils.Result;
import com.lhb.springboot.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: yaya
 * @create: 2020/4/4
 */
@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    TopicService topicService;

    @PostMapping("/pushTopic")
    public Result pushTopic(Topic topic){

        Topic topic1 = topicService.addTopic(topic);

        if(topic1 == null){
            return new Result(ResultCode.WRONG_OPERATION.getCode(),
                    ResultCode.WRONG_OPERATION.getMsg());
        }
        return new Result(ResultCode.SUCCESSFUL.getCode(),
                ResultCode.SUCCESSFUL.getMsg());
    }
}
