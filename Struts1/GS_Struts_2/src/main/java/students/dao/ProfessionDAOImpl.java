package students.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import students.entity.Profession;

public class ProfessionDAOImpl implements ProfessionDAO {

    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    public Long addProfession(Profession p) {
        return (Long)template.save(p);
    }

    public void updateProfession(Profession p) {
        template.saveOrUpdate(p);
    }

    public void deleteProfession(Profession p) {
        template.delete(p);
    }

    public Profession getProfession(Long id) {
        return (Profession) template.load(Profession.class, id);
    }

    public List<Profession> findProfession() {
        return template.find("FROM Profession ORDER BY professionName");
    }
}
