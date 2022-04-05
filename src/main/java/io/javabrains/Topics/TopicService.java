package io.javabrains.Topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicsRepository topicsRepository;

    /*private List<Topics_class> topics= new ArrayList<>(Arrays.asList(
            new Topics_class("Spring_Boot",1,2000.0),
            new Topics_class("JAVA",2,3000.0),
            new Topics_class("ML",3,2000.0),
            new Topics_class("DS",4,2500.0)
    ));*/

    public List<Topics_class> getTopics()
    {
        List<Topics_class> topics =new ArrayList<>();

        topicsRepository.findAll().forEach(topics::add);

        return topics;
    }

    public Topics_class getSpecificTopic(int id)
    {
        Optional<Topics_class> optional=topicsRepository.findById(id);

        return optional.get();
    }

    public void addTopic(Topics_class topic) {

        topicsRepository.save(topic);
    }

    public void updateTopic(int id, Topics_class topic) {

        topicsRepository.save(topic);
    }

    public void deleteTopic(int id) {
        topicsRepository.deleteById(id);
    }
}

