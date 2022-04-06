package io.javabrains.Topics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Topics_Controller {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public List<Topics_class> getAllTopics()
    {
        return topicService.getTopics();
    }

    @GetMapping("/topics/{id}")
    public Topics_class getSpecificTopic(@PathVariable int id)
    {
        return topicService.getSpecificTopic(id);
    }

    @PostMapping(value = "/topics")
    public void addTopic(@RequestBody Topics_class topic)
    {
        topicService.addTopic(topic);
    }

    @PutMapping(value = "/topics/{id}")
    public void updateTopic(@RequestBody Topics_class topic,@PathVariable int id)
    {
        topicService.updateTopic(id,topic);
    }

    @DeleteMapping(value = "/topics/{id}")
    public void deleteTopic(@PathVariable int id)
    {
        topicService.deleteTopic(id);
    }
}
