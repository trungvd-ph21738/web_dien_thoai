package com.poly.ph21738.repositories.impl;

import com.poly.ph21738.entities.Battery;
import com.poly.ph21738.repositories.ICommomRepository;
import com.poly.ph21738.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BatteryRepositoryImpl implements ICommomRepository<Battery, UUID> {

    @Override
    public List<Battery> findAll() {
        List<Battery> batteryList = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<Battery> query = session.createQuery("FROM Battery", Battery.class);
            batteryList = query.getResultList();
            return batteryList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return batteryList;
    }

    @Override
    public Battery findById(UUID id) {
        Battery battery = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<Battery> query = session.createQuery("FROM Battery WHERE id = :id", Battery.class);
            query.setParameter("id", id);
            battery = query.getSingleResult();
            return battery;
        } catch (Exception e) {
            e.printStackTrace();
            return battery;
        }
    }

    @Override
    public Boolean add(Battery battery) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(battery);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public Boolean update(Battery battery) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(battery);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public Boolean delete(Battery battery) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(battery);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public List<Battery> findByName(String keyword) {
        List<Battery> listSearch = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<Battery> query = session.createQuery("FROM Battery WHERE batteryName LIKE :keyword", Battery.class);
            query.setParameter("keyword", "%" + keyword + "%");
            listSearch = query.getResultList();
            return listSearch;
        } catch (Exception e) {
            e.printStackTrace();
            return listSearch;
        }
    }
}

