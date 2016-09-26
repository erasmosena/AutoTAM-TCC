package api.autotam.dao;

import api.autotam.model.Questao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Danilo on 9/24/2016.
 */

@Repository("questaoDAO")
public class QuestaoDAOImpl extends AbstractDAO implements QuestaoDAO{
    @Override
    public void saveQuestao(Questao questao) { persist(questao);}

    @Override
    public void updateQuestao(Questao questao) { getSession().update(questao);}

    @Override
    public List<Questao> findAllQuestoesFromVariavel(int idVariavel) {
        Query query = getSession().createSQLQuery(
                "select * from questao q where p.idVariavel = :idVariavel")
                .addEntity(Questao.class)
                .setParameter("idVariavel", idVariavel);
        return (List<Questao>) query.list();
    }

    @Override
    public void deleteQuestao(int idQuestao) {
        Query query = getSession().createSQLQuery(
                "delete from questao where idQuestao = :idQuestao");
        query.setParameter("idQuestao", idQuestao);
        query.executeUpdate();
    }

    @Override
    public Questao findById(int idQuestao) {
        Query query = getSession().createSQLQuery(
                "select * from questao q where q.idQuestao = :idQuestao")
                .addEntity(Questao.class)
                .setParameter("idQuestao", idQuestao);
        return (Questao) query.uniqueResult() ;
    }


}