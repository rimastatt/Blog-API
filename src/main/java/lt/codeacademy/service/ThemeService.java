package lt.codeacademy.service;

import lt.codeacademy.entity.Theme;
import lt.codeacademy.repository.ThemeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeService {

    private final ThemeRepository themeRepository;

    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    public List<Theme> getAllThemes(){
        return themeRepository.findAll();
    }

    public Theme findThemeById(Long id){
        return themeRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
