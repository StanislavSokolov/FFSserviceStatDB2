package org.example;

import org.example.com.Data;
import org.example.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
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

        SessionFactory sessionFactory = null;
        try {
            sessionFactory = new Configuration().
                    addAnnotatedClass(Item.class).
                    addAnnotatedClass(Year.class).
                    setProperty("hibernate.driver_class", Settings.getProperties("hibernate.driver_class")).
                    setProperty("hibernate.connection.url", Settings.getProperties("hibernate.connection.url")).
                    setProperty("hibernate.connection.username", Settings.getProperties("hibernate.connection.username")).
                    setProperty("hibernate.connection.password", Settings.getProperties("hibernate.connection.password")).
                    setProperty("hibernate.dialect", Settings.getProperties("hibernate.dialect")).
                    setProperty("hibernate.current_session_context_class", Settings.getProperties("hibernate.current_session_context_class")).
                    setProperty("hibernate.show_sql", Settings.getProperties("hibernate.show_sql")).
                    buildSessionFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            for (int i = 0; i > -1; i--) {
                List<Item> itemsOrders = session.createQuery("FROM Item where cdate like '" + Data.getData(i) + "'").getResultList();
                List<Item> itemsSales = session.createQuery("FROM Item where sdate like '" + Data.getData(i) + "' and status like 'sold'").getResultList();
                List<Item> itemsReturns = session.createQuery("FROM Item where sdate like '" + Data.getData(i) + "' and status like 'returned'").getResultList();
                if (!itemsOrders.isEmpty() || !itemsSales.isEmpty()) {
//                    System.out.println("Hello");
                    List<Year> day = session.createQuery("FROM Year where cdate LIKE '" + Data.getData(i) + "'").getResultList();
                    if (day.isEmpty()) {
                        Year year = new Year(Data.getData(i), itemsOrders.size(), itemsSales.size(), 0);
                        session.save(year);
                    } else {
                        session.createQuery("update Year set orders = " + itemsOrders.size() + ", sales = " + itemsSales.size() + ", returns = " + itemsReturns.size() + " WHERE cdate = '" + Data.getData(i) + "'").executeUpdate();
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
