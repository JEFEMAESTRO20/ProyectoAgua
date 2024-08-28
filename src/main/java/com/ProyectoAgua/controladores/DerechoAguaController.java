package com.ProyectoAgua.controladores;

import com.ProyectoAgua.modelos.DerechoAgua;
import com.ProyectoAgua.servicios.interfaces.IDerechoAguaService;
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
@RequestMapping("/derechoAguas")
public class DerechoAguaController {

    @Autowired
    private IDerechoAguaService derechoAguaService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1) - 1; //si no esta seteado se asigna
        int pageSize = size.orElse(5); // tamaño de la pagina se asigna 5
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<DerechoAgua> derechoAguas = derechoAguaService.buscarTodosPaginados(pageable);
        model.addAttribute("derechoAguas", derechoAguas);

        int totalPages = derechoAguas.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "derechoAgua/index";
    }

    @GetMapping("/create")
    public String create(DerechoAgua derechoAgua)
    {
        return "derechoAgua/create";
    }

    @PostMapping("/save")
    public String save (DerechoAgua derechoAgua, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute(derechoAgua);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un errог.");
            return "derechoAgua/create";
        }

        derechoAguaService.crearOEditar(derechoAgua);
        attributes.addFlashAttribute("msg", "DerechoAgua creado correctamente");
        return "redirect:/derechoAguas";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        DerechoAgua derechoAgua = derechoAguaService.buscarPorId(id).get();
        model.addAttribute("derechoAgua", derechoAgua);
        return "derechoAgua/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        DerechoAgua derechoAgua = derechoAguaService.buscarPorId(id).get();
        model.addAttribute("derechoAgua", derechoAgua);
        return "derechoAgua/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        DerechoAgua derechoAgua = derechoAguaService.buscarPorId(id).get();
        model.addAttribute("derechoAguas", derechoAgua);
        return "derechoAgua/delete";
    }

    @PostMapping("/delete")
    public String delete(DerechoAgua derechoAgua, RedirectAttributes attributes){
        derechoAguaService.eliminarPorId(derechoAgua.getId());
        attributes.addFlashAttribute("msg", "derechoAgua eliminado correrctamente");
        return "redirect:/derechoAguas";
    }
}
