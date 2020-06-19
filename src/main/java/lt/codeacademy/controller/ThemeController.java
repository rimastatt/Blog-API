package lt.codeacademy.controller;

import lt.codeacademy.entity.Theme;
import lt.codeacademy.service.ThemeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/themes")
public class ThemeController {

    private ThemeService themeService;

    public ThemeController(ThemeService themeService){
        this.themeService = themeService;
    }

    @GetMapping
    public List<Theme> getThemes(){
        return themeService.getAllThemes();
    }
}
