package com.ProyectoAgua.controladores;

import com.ProyectoAgua.modelos.DerechoAgua;
import com.ProyectoAgua.modelos.RegistroAgua;
import com.ProyectoAgua.servicios.interfaces.IDerechoAguaService;
import com.ProyectoAgua.servicios.interfaces.IRegistroAguaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/registroAguas")
public class RegistroAguaController {

    @Autowired
    private IRegistroAguaService registroAguaService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1) - 1; //si no esta seteado se asigna
        int pageSize = size.orElse(5); // tamaño de la pagina se asigna 5
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<RegistroAgua> registroAguas = registroAguaService.buscarTodosPaginados(pageable);
        model.addAttribute("registroAguas", registroAguas);

        int totalPages = registroAguas.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "registroagua/index";
    }
}

