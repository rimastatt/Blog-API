package lt.codeacademy.controller;

import lt.codeacademy.dto.ThemeDTO;
import lt.codeacademy.entity.Theme;
import lt.codeacademy.service.ThemeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/themes")
public class ThemeController {

    private ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping
    public List<ThemeDTO> getThemes() {
        List<Theme> themeList = themeService.getAllThemes();
        List<ThemeDTO> themeDTOList = new ArrayList<>();
        for (Theme theme : themeList) {
            ThemeDTO themeDTO = new ThemeDTO();
            themeDTO.setName(theme.getName());
            themeDTO.setDescription(theme.getDescription());
            themeDTO.setId(theme.getId());
            themeDTO.setPicture(theme.getPicture());
            themeDTOList.add(themeDTO);
        }
        return themeDTOList;
    }
}
