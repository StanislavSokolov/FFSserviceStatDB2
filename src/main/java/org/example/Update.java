package org.example;

import org.example.model.Item;
import org.example.model.Product;
import org.example.model.Stock;
import org.example.model.User;
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
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {

        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(User.class).
                addAnnotatedClass(Product.class).
                addAnnotatedClass(Stock.class).
                addAnnotatedClass(Item.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            List<User> users = session.createQuery("FROM User").getResultList();
            for (User user : users) {

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
