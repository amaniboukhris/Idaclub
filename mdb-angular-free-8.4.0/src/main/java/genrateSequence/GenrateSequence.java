package genrateSequence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.journaldev.bootifulmongodb.model.DatabaseSequence;

public class GenrateSequence {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private  MongoTemplate mongoTemplate;


	public long generateSequence(String key)  {
		Query query = new Query(Criteria.where("_id").is(key));
		Update update = new Update();
		  update.inc("seq",2);
		  FindAndModifyOptions options = new FindAndModifyOptions();
		  options.returnNew(true);
		  DatabaseSequence seqId = mongoTemplate.findAndModify(query, update, options, DatabaseSequence.class);
				  
		  if (seqId == null) {
		        log.error("Unable to get sequence id for key: {}", key);
		        
		    }

		    log.debug("Next sequendId: {}", seqId);
		    return seqId.getSeq();
		}
		 
}
