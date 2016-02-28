package me.xanddol.todo.dao.impl;

import me.xanddol.todo.dao.ToDoDao;
import me.xanddol.todo.domain.ToDo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Андрей on 18.02.2016.
 */
@Repository("toDoDao")
public class ToDoDaoImpl extends HibernateDaoSupport implements ToDoDao {

    @Autowired
    public ToDoDaoImpl(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public void save(ToDo todo) {
        getHibernateTemplate().save(todo);
    }

    public void update(ToDo todo) {
        getHibernateTemplate().update(todo);
    }

    public void delete(ToDo todo) {
        getHibernateTemplate().delete(todo);
    }

    public List<ToDo> getAll() {
        return getHibernateTemplate().find("from ToDo");
    }

    public ToDo getById(int id) {
        return getHibernateTemplate().get(ToDo.class, id);
    }
}
