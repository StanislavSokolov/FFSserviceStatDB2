package org.example;

import org.example.com.Data;
import org.example.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Update extends Thread {

    @Override
    public void run() {

        super.run();
        while (true) {
            try {
                update();
                sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {

        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(User.class).
                addAnnotatedClass(Product.class).
                addAnnotatedClass(Stock.class).
                addAnnotatedClass(Item.class).
                addAnnotatedClass(Year2023.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            for (int i = 0; i > -50; i--) {
                List<Item> items = session.createQuery("FROM Item where cdate like '" + Data.getData(i) + "'").getResultList();
                if (!items.isEmpty()) {
                    List<Year2023> day = session.createQuery("FROM Year2023 where cdate LIKE '" + Data.getData(i) + "'").getResultList();
                    if (day.isEmpty()) {
                        Year2023 year2023 = new Year2023(Data.getData(i), items.size());
                        session.save(year2023);
                    } else {
                        session.createQuery("update Year2023 set csum = " + items.size() + " WHERE cdate = '" + Data.getData(i) + "'").executeUpdate();
                    }
                }
            }
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

    private int delimiter(String s, String delimiter) {
        String str = s;
        String[] subStr;
        subStr = str.split(delimiter); // Разделения строки str с помощью метода split()
        return Integer.parseInt(subStr[0]);
    }
}
