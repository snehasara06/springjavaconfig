package com.kgisl.javaspring.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.javaspring.entity.BookInfo;

@Service
public class BookDaoImpl implements BookDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List < BookInfo > getBooks() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < BookInfo > cq = cb.createQuery(BookInfo.class);
        Root < BookInfo > root = cq.from(BookInfo.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        System.out.println(query.getResultList());
        return query.getResultList(); 
    }
}
