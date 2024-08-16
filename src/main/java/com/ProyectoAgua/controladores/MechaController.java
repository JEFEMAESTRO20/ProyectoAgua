package com.ProyectoAgua.controladores;

import com.ProyectoAgua.modelos.Mecha;
import com.ProyectoAgua.servicios.interfaces.IMechaService;
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
@RequestMapping("/mechas")
public class MechaController {
    @Autowired
    private IMechaService mechaService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1) -1;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<Mecha> mechas = mechaService.buscarTodosPaginados(pageable);
        model.addAttribute("mechas", mechas);

        int totalPages = mechas.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute( "pageNumbers", pageNumbers);
        }
        return "mecha/index";
    }

    @GetMapping("/create")
    public String create(Mecha mecha){
        return "mecha/create";
    }

    @PostMapping("/save")
    public String save (Mecha mecha, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute(mecha);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un errог.");
            return "mecha/create";
        }

        mechaService.crearOEditar(mecha);
        attributes.addFlashAttribute("msg", "mecha creada correctamente");
        return "redirect:/mechas";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        Mecha mecha = mechaService.buscarPorId(id).get();
        model.addAttribute("mecha", mecha);
        return "mecha/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Mecha mecha = mechaService.buscarPorId(id).get();
        model.addAttribute("mecha", mecha);
        return "mecha/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        Mecha mecha = mechaService.buscarPorId(id).get();
        model.addAttribute("mecha", mecha);
        return "mecha/delete";
    }

    @PostMapping("/delete")
    public String delete(Mecha mecha, RedirectAttributes attributes){
        mechaService.eliminarPorId(mecha.getId());
        attributes.addFlashAttribute("msg", "mecha eliminada correrctamente");
        return "redirect:/mechas";
    }
}
