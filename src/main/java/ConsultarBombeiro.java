
import ifc.ibirama.hibernate.util.HibernateUtil;
import ifc.ibirama.hibernate.util.entidades.Bombeiros;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author aluno
 */
public class ConsultarBombeiro {

    public static void main(String[] args) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        String meuobj = "from Bombeiro";

        List<Bombeiros> bombeiros = sessao.createQuery(meuobj, Bombeiros.class).getResultList();

        for (Iterator<Bombeiros> index = bombeiros.iterator(); index.hasNext();) {
            Bombeiros meubombeiro = index.next();
            System.out.println(meubombeiro.getCpf());
        }

        HibernateUtil.shutdown();
    }
}
