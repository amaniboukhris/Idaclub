package com.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import com.model.Session;
import com.model.User;

@Repository
public class UserService {

	@Autowired
	private SessionService sessionS;
	@Autowired
	private MongoTemplate mongoTemplate;

	private JavaMailSender javaMailSender;

	public List<User> getAllUser() {
		return mongoTemplate.findAll(User.class);
	}
	
	
	public User getUserByMail(String email) {

		Query query = new Query();
		query.addCriteria(Criteria.where("mail").is(email));

		User findUser = mongoTemplate.findOne(query, User.class);

		if (findUser == null) {
			System.out.println("User with cin " + email + " not exists");

		} else {

			System.out.println("User with cin " + email + "  exists");

		}
		return findUser;
	}

	public void getUserBycin(String cin) {

		Query query = new Query();
		query.addCriteria(Criteria.where("CIN").is(cin));

		User findUser = mongoTemplate.findOne(query, User.class);

		if (findUser == null) {
			System.out.println("User with cin " + cin + " not exists");

		} else {

			System.out.println("User with cin " + cin + "  exists");

		}
	}

	public User addUser(User user) {
		String cin = user.getCIN();

		Query query = new Query();
		query.addCriteria(Criteria.where("CIN").is(cin));

		User foundUser = mongoTemplate.findOne(query, User.class);

		if (foundUser != null) {
			System.out.println("User with cin " + cin + " already exists");

		} else {

			save(user);
		}
		return user;

	}

	public User findUserByid(long id) {

		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		System.out.println("the name is " + id);

		return (User) mongoTemplate.find(query, User.class);
	}

	public User update(User user) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(user.getUserId()));
		Update update = new Update();
		update.set("nom", user.getNom());

		return mongoTemplate.findAndModify(query, update, User.class);
	}

	public User updateOneUser(User user) {
		mongoTemplate.save(user);
		return user;
	}

	public User updatebyCin(User user) {
		Query query = new Query();
		query.addCriteria(Criteria.where("CIN").is(user.getCIN()));
		Update update = new Update();
		update.set("nom", user.getNom());
		return mongoTemplate.findAndModify(query, update, User.class);
	}

	public User getUserById(long id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));

		return mongoTemplate.findOne(query, User.class);
	}

	public void deleteUser(User user) {
		mongoTemplate.remove(user);

	}

	public User deleteById(long id) {

		User user = getUserById(id);
		if (user == null) {
			return null;
		} else {
			deleteUser(user);

			return user;
		}

	}

	public User save(User user) {

		if (user.getUserId() == -1 || user.getUserId() == 0) {
			List listUsers = getAllUser();
			int fin = listUsers.size();
			user.setUserId(fin + 1);
			updateOneUser(user);
		} else {
			deleteById(user.getUserId());
			updateOneUser(user);
		}
		return user;
	}

	Collection<Session> list = new ArrayList<Session>();

	public User deleteSessionUser(long idU, long idS) {
		User ut = getUserById(idU);

		list = ut.getSessions();

		for (Iterator<Session> iterator = list.iterator(); iterator.hasNext();) {
			Session value = iterator.next();
			if (value.getId() == idS) {
				iterator.remove();

			}

		}
		return mongoTemplate.save(ut);

	}

	public User addSessionUser(long idU, long idS) {
		User ut = getUserById(idU);
		Session ss = sessionS.getById(idS);
		list = ut.getSessions();
		boolean test = false;

		for (Iterator<Session> iterator = list.iterator(); iterator.hasNext();) {
			Session value = iterator.next();
			System.out.println(value.getId());
			if (value.getId() == idS) {
				test = true;
			}
		}
		if (test == false) {
			list.add(ss);
			mongoTemplate.save(ut);

		} else {
			System.out.println("existe");
		}

		return ut;
	}

}