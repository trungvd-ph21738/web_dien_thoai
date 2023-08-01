package com.poly.ph21738.repositories.impl;

import com.poly.ph21738.entities.Chip;
import com.poly.ph21738.repositories.ICommomRepository;
import com.poly.ph21738.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChipRepositoryImpl implements ICommomRepository<Chip, UUID> {
    @Override
    public List<Chip> findAll() {
        List<Chip> chipList = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<Chip> query = session.createQuery("FROM Chip", Chip.class);
            chipList = query.getResultList();
            return chipList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chipList;
    }

    @Override
    public Chip findById(UUID id) {
        Chip chip = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<Chip> query = session.createQuery("FROM Chip WHERE id = :id", Chip.class);
            query.setParameter("id", id);
            chip = query.getSingleResult();
            return chip;
        } catch (Exception e) {
            e.printStackTrace();
            return chip;
        }
    }

    @Override
    public Boolean add(Chip chip) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(chip);
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
    public Boolean update(Chip chip) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(chip);
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
    public Boolean delete(Chip chip) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(chip);
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
    public List<Chip> findByName(String keyword) {
        List<Chip> listSearch = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<Chip> query = session.createQuery("FROM Chip WHERE chipName LIKE :keyword", Chip.class);
            query.setParameter("keyword", "%" + keyword + "%");
            listSearch = query.getResultList();
            return listSearch;
        } catch (Exception e) {
            e.printStackTrace();
            return listSearch;
        }
    }
}