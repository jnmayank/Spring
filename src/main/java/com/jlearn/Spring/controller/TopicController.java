package com.jlearn.Spring.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.aspectj.weaver.AjAttribute.MethodDeclarationLineNumberAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ControllerLinkBuilderFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.jlearn.Spring.exception.NotFoundException;
import com.jlearn.Spring.model.Topic;
import com.jlearn.Spring.service.TopicService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "topics")
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	
	@GetMapping
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();	
	}
	
	@GetMapping(path ="/{id}",produces= "application/json")
	@ApiOperation(value="get a specific topic for a given ID.")
	public Resource <Topic> getTopic(@PathVariable String id) {		
		Topic topic = topicService.getTopic(id);
		
		if(topic == null) {
			throw new NotFoundException("topic doesn't exist");
		}
		
		//HATEOS - Hyper media as the engine of application state.
		Resource<Topic> topicResource = new Resource<Topic>(topic);		
		ControllerLinkBuilder link = ControllerLinkBuilder.linkTo(
				ControllerLinkBuilder.methodOn(this.getClass()).getAllTopics());
		
		topicResource.add(link.withRel("all-topics"));
		
		return topicResource;
	}
	
	@PostMapping(path ="/newTopic",consumes= "application/json")
	public ResponseEntity addTopic(@Valid @RequestBody Topic topic) {
		
		topicService.addTopic(topic);		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(topic.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping(path ="/updateTopic/{id}",consumes= "application/json")
	public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
		topicService.UpdateTopic(id, topic);	
	}
	
	@DeleteMapping(path ="/deleteTopic/{id}")
	public void deleteTopic(@PathVariable String id) {
		
		topicService.deleteTopic(id);
		
		/*boolean status = topicService.deleteTopic(id);	
		if(!status)
			throw new NotFoundException("topic doesn't exist");*/
	}

	public TopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

}
