package com.poly.ph21738.repositories.impl;

import com.poly.ph21738.entities.Brand;
import com.poly.ph21738.repositories.ICommomRepository;
import com.poly.ph21738.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BrandRepositoryImpl implements ICommomRepository<Brand, UUID> {
    @Override
    public List<Brand> findAll() {
        List<Brand> brandList = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<Brand> query = session.createQuery("FROM Brand", Brand.class);
            brandList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brandList;
    }

    @Override
    public Brand findById(UUID id) {
        Brand brand = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            brand = session.get(Brand.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brand;
    }

    @Override
    public Boolean add(Brand brand) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(brand);
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
    public Boolean update(Brand brand) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(brand);
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
    public Boolean delete(Brand brand) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(brand);
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
    public List<Brand> findByName(String keyword) {
        List<Brand> listSearch = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<Brand> query = session.createQuery("FROM Brand WHERE brandName LIKE :keyword", Brand.class);
            query.setParameter("keyword", "%" + keyword + "%");
            listSearch = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSearch;
    }
}
