package lt.codeacademy.repository;

import lt.codeacademy.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {

    public Theme findThemeByName(String name);

}
