package pl.xavras.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.xavras.api.dto.CustomerDTO;
import pl.xavras.api.dto.mapper.CustomerMapper;
import pl.xavras.business.CustomerService;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    public static final String HOME = "/";

    @GetMapping(HOME)
    public String home() {

        return "home";
    }

}

