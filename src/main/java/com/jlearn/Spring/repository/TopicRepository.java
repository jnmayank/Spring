package com.jlearn.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jlearn.Spring.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, String>{
	
	/* custom method declaration 
		- findBy<propertyName>
		- findBy<entityName+propertyName>
		
	*/
	
}
