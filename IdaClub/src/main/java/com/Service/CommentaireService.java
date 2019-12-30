package com.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.model.Session;
import com.model.commentaire;

@Repository
public class CommentaireService {

	@Autowired
	private MongoTemplate MongoTemplate;
	private static int Idcourant = 0;

	// Get All
	public List<commentaire> getAllcomment() {
		return MongoTemplate.findAll(commentaire.class);
	}

	public commentaire getById(long id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));

		return MongoTemplate.findOne(query, commentaire.class);

	}

	public void deleteComment(commentaire comment) {
		MongoTemplate.remove(comment);

	}

	public commentaire deleteComm(long id) {

		commentaire comment = getById(id);
		if (comment == null) {
			return null;
		} else {
			deleteComment(comment);
			System.out.println("comment " + id + "est suprimer");
			return comment;
		}

	}

	// Delet
	/*
	 * public commentaire deleteById(long id) { commentaire C = findByid(id);
	 * 
	 * MongoTemplate.remove(C); return C; }
	 */

	// Find By Id
	public commentaire findByid(long id) {

		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		System.out.println("the comment is " + id);
		return (commentaire) MongoTemplate.find(query, commentaire.class);
	}

	/// Save Commnetaire
	public commentaire save(commentaire C) {
		if (C.getId() == -1 || C.getId() == 0) {
			List listcomm = getAllcomment();
			int fin =listcomm.size();
			C.setId(fin + 1);
			MongoTemplate.save(C);
		} else {
			deleteComm(C.getId());

			// comm.add(C);

			MongoTemplate.save(C);
		}
		return C;
	}

	// Ajouter Commmentaire
	public commentaire addcomment(commentaire comment) {
		long id = comment.getId();
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		save(comment);
		return comment;

	}

}