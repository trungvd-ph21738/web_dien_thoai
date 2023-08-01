package com.poly.ph21738.util;
import com.poly.ph21738.entities.Battery;
import com.poly.ph21738.entities.Brand;
import com.poly.ph21738.entities.Chip;
import com.poly.ph21738.entities.Color;
import com.poly.ph21738.entities.Product;
import com.poly.ph21738.entities.Ram;
import com.poly.ph21738.entities.Rom;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=Assignment_Java4");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.FORMAT_SQL, "true");

        conf.setProperties(properties);
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(Rom.class);
        conf.addAnnotatedClass(Ram.class);
        conf.addAnnotatedClass(Color.class);
        conf.addAnnotatedClass(Brand.class);
        conf.addAnnotatedClass(Chip.class);
        conf.addAnnotatedClass(Battery.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
    }
}
