package com.poly.ph21738.repositories.impl;

import com.poly.ph21738.entities.Color;
import com.poly.ph21738.repositories.ICommomRepository;
import com.poly.ph21738.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ColorRepository implements ICommomRepository<Color, UUID> {

    @Override
    public List<Color> findAll() {
        List<Color> colorList = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<Color> query = session.createQuery("FROM Color", Color.class);
            colorList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return colorList;
    }

    @Override
    public Color findById(UUID id) {
        Color color = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<Color> query = session.createQuery("FROM Color WHERE id = :id", Color.class);
            query.setParameter("id", id);
            color = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return color;
    }

    @Override
    public Boolean add(Color color) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(color);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(Color color) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(color);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean delete(Color color) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(color);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Color> findByName(String keyword) {
        List<Color> listSearch = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<Color> query = session.createQuery("FROM Color WHERE colorName LIKE :keyword", Color.class);
            query.setParameter("keyword", "%" + keyword + "%");
            listSearch = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSearch;
    }
}
