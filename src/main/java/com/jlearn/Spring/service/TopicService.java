package com.jlearn.Spring.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jlearn.Spring.exception.NotFoundException;
import com.jlearn.Spring.model.Topic;
import com.jlearn.Spring.repository.TopicRepository;


@Service("topicService")
public class TopicService {
	
	@Autowired
	TopicRepository topicRepository;
	
	public List<Topic> getAllTopics() {
		return topicRepository.findAll();
	}
	
	public Topic getTopic(String id) {
		Optional<Topic> optional = topicRepository.findById(id);		
		return optional.orElseThrow(() -> new NotFoundException("topic doesn't exist"));
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void UpdateTopic(String id, Topic topic1) {
		Topic topic  = getTopic(id);
		
		topic.setName(topic1.getName());
		topic.setDescription(topic1.getDescription());
		
		topicRepository.save(topic);
		
	}
	
	public void deleteTopic(String id) {
		topicRepository.delete(getTopic(id));		
	}

}
