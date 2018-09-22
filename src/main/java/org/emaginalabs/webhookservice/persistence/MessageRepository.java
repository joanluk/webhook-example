package org.emaginalabs.webhookservice.persistence;

import org.emaginalabs.webhookservice.model.Application;
import org.emaginalabs.webhookservice.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findAllByApplicationOrderByIdAsc(Application destination);

}
