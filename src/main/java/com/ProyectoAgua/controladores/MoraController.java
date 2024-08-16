package com.ProyectoAgua.controladores;

import com.ProyectoAgua.modelos.Mora;
import com.ProyectoAgua.servicios.interfaces.IMoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/moras")
public class MoraController {
    @Autowired
    private IMoraService moraService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1) -1;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<Mora> moras = moraService.buscarTodosPaginados(pageable);
        model.addAttribute("moras", moras);

        int totalPages = moras.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute( "pageNumbers", pageNumbers);
        }
        return "mora/index";
    }

    @GetMapping("/create")
    public String create(Mora mora){
        return "mora/create";
    }

    @PostMapping("/save")
    public String save (Mora mora, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute(mora);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un errог.");
            return "mora/create";
        }

        moraService.crearOEditar(mora);
        attributes.addFlashAttribute("msg", "mora creada correctamente");
        return "redirect:/moras";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        Mora mora = moraService.buscarPorId(id).get();
        model.addAttribute("mora", mora);
        return "mora/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Mora mora = moraService.buscarPorId(id).get();
        model.addAttribute("mora", mora);
        return "mora/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        Mora mora = moraService.buscarPorId(id).get();
        model.addAttribute("mora", mora);
        return "mora/delete";
    }

    @PostMapping("/delete")
    public String delete(Mora mora, RedirectAttributes attributes){
        moraService.eliminarPorId(mora.getId());
        attributes.addFlashAttribute("msg", "Mora eliminada correrctamente");
        return "redirect:/moras";
    }
}
