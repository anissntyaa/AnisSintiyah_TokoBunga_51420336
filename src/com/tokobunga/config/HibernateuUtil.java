/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tokobunga.config;

import com.toko.bunga.dao.TokoBungaDao;
import com.toko.bunga.dao.TokoBungaImpl;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author ANIS
 */
public class HibernateuUtil {
    private static final SessionFactory SESSION_FACTORY;
    private static final TokoBungaDao TokoBunga_DAO;

    static{
        try{
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
            TokoBunga_DAO = new TokoBungaImpl(SESSION_FACTORY);
        }catch(HibernateException e){
            System.err.println("Initial SessionFactory Creation Failed : " +e);
            throw new ExceptionInInitializerError(e);
            
        }
    }
    
    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }
    
    public static TokoBungaDao getTokoBungaDao(){
        return TokoBunga_DAO;
    }
}
