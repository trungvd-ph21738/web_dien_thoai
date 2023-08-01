package com.poly.ph21738.repositories.impl;

import com.poly.ph21738.entities.Rom;
import com.poly.ph21738.repositories.ICommomRepository;
import com.poly.ph21738.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RomRepository implements ICommomRepository<Rom, UUID> {
    @Override
    public List<Rom> findAll() {
        List<Rom> romList = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM Rom", Rom.class);
            romList = query.getResultList();
            return romList;
        } catch (Exception e){
            e.printStackTrace();
        }
        return romList;
    }

    @Override
    public Rom findById(UUID id) {
        Rom rom = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM Rom WHERE id = :id", Rom.class);
            query.setParameter("id", id);
            rom = (Rom) query.getSingleResult();
            return rom;
        } catch (Exception e){
            e.printStackTrace();
            return rom;
        }
    }

    @Override
    public Boolean add(Rom rom) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.persist(rom);
            transaction.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public Boolean update(Rom rom) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.merge(rom);
            transaction.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public Boolean delete(Rom rom) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(rom);
            transaction.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public List<Rom> findByName(String keyword) {
        List<Rom> listSearch = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM Rom WHERE productName LIKE :keyword", Rom.class);
            query.setParameter("keyword", "%" + keyword + "%");
            listSearch = query.getResultList();
            return listSearch;
        } catch (Exception e){
            e.printStackTrace();
            return listSearch;
        }
    }
}
