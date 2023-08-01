package com.poly.ph21738.repositories.impl;

import com.poly.ph21738.entities.Product;
import com.poly.ph21738.repositories.ICommomRepository;
import com.poly.ph21738.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductRepository implements ICommomRepository<Product, UUID> {

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM Product", Product.class);
            productList = query.getResultList();
            return productList;
        } catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product findById(UUID id) {
        Product product = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM Product WHERE id = :id", Product.class);
            query.setParameter("id",id);
            product = (Product) query.getSingleResult();
            return product;
        } catch (Exception e){
            e.printStackTrace();
            return product;
        }
    }

    @Override
    public Boolean add(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public Boolean update(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public Boolean delete(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(product);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public List<Product> findByName(String keyword) {
        List<Product> listSearch = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM Product WHERE productName Like :keyword", Product.class);
            query.setParameter("keyword", "%"+keyword+"%");
            listSearch = query.getResultList();
            return listSearch;
        }catch (Exception e){
            e.printStackTrace();
            return listSearch;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new ProductRepository().findAll());
        System.out.println(new ProductRepository().findById(UUID.fromString("f12c6c5c-374c-e445-9e04-674fbe69338b")));
        System.out.println(new ProductRepository().findByName("Iphone"));
    }
}
