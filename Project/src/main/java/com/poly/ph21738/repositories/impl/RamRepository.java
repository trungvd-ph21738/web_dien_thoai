package com.poly.ph21738.repositories.impl;

import com.poly.ph21738.entities.Ram;
import com.poly.ph21738.repositories.ICommomRepository;
import com.poly.ph21738.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RamRepository implements ICommomRepository<Ram, UUID> {
    @Override
    public List<Ram> findAll() {
        List<Ram> ramList = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Ram", Ram.class);
            ramList = query.getResultList();
            return ramList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ramList;
    }

    @Override
    public Ram findById(UUID id) {
        Ram ram = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Ram WHERE id = :id", Ram.class);
            query.setParameter("id", id);
            ram = (Ram) query.getSingleResult();
            return ram;
        } catch (Exception e) {
            e.printStackTrace();
            return ram;
        }
    }

    @Override
    public Boolean add(Ram ram) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(ram);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public Boolean update(Ram ram) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ram);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public Boolean delete(Ram ram) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ram);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public List<Ram> findByName(String keyword) {
        List<Ram> listSearch = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Ram WHERE productName LIKE :keyword", Ram.class);
            query.setParameter("keyword", "%" + keyword + "%");
            listSearch = query.getResultList();
            return listSearch;
        } catch (Exception e) {
            e.printStackTrace();
            return listSearch;
        }
    }
}
