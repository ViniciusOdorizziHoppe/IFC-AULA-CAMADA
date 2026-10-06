
import ifc.ibirama.hibernate.util.HibernateUtil;
import ifc.ibirama.hibernate.util.entidades.Bombeiros;
import java.util.Calendar;
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
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        System.out.println("Sessão Estabelecida");
        Transaction transacao = null;

        Bombeiros bombeiro = new Bombeiros();
        bombeiro.setcpf("12345678");
        Calendar cal = Calendar.getInstance();
        cal.set(1990, Calendar.JANUARY, 8);
        bombeiro.setBom_data_nascimento(cal.getTime());

        bombeiro.setBom_nome_completo("Vinícius Odorizzi Hoppe");

        try {
            transacao = sessao.beginTransaction();

            sessao.persist(bombeiro);
            transacao.commit();
            System.out.println("Bombeiro Salvo");
            sessao.close();

        } catch (Exception e) {
            if (transacao != null) {
                transacao.rollback();
            }
        }

        sessao.close();
    }
}
