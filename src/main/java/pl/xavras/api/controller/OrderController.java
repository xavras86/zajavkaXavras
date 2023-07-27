package pl.xavras.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.xavras.api.dto.mapper.StreetMapper;
import pl.xavras.business.StreetService;

@Controller
@AllArgsConstructor
@Slf4j
public class OrderController {

    public static final String ORDER = "/order";


}

