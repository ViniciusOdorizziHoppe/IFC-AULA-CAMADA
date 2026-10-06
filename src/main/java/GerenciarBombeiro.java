
import ifc.ibirama.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vinícius
 */
public class GerenciarBombeiro {
    public static void main(String[] args) {
      Session sessao =  HibernateUtil.getSessionFactory().openSession();
      
        System.out.println("Sessão Estabelecida");
        Transaction transacao = null;
        try{
            
        }catch (Exception e){
            
        }
        
        sessao.close();
    }
}
