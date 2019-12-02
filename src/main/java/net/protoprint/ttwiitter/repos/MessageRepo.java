package net.protoprint.ttwiitter.repos;

import net.protoprint.ttwiitter.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {

    List<Message> findByTag(String tag);
}
