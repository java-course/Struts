package students.dao;

import java.util.List;
import students.entity.Profession;

public interface ProfessionDAO {

    public Long addProfession(Profession p);

    public void updateProfession(Profession p);

    public void deleteProfession(Profession p);

    public Profession getProfession(Long id);

    public List<Profession> findProfession();
}
