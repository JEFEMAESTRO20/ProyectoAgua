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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/registroAguas")
public class RegistroAguaController {

    @Autowired
    private IRegistroAguaService registroAguaService;

    @Autowired
    private IDerechoAguaService derechoAguaService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1) - 1;
        int pageSize = size.orElse(5);
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

        return "registroAgua/index";
    }

    @GetMapping("/create")
    public String create(Model model) {

        List<DerechoAgua> derechoAguas = derechoAguaService.obtenerTodos();
        model.addAttribute("registroAgua", new RegistroAgua());
        model.addAttribute("derechoAguas", derechoAguas);
        return "registroAgua/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("registroAgua") RegistroAgua registroAgua, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("derechoAguas", derechoAguaService.buscarTodos());
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "registroAgua/create";
        }

        registroAguaService.crearOEditar(registroAgua);
        attributes.addFlashAttribute("msg", "Registro de agua creado correctamente");
        return "redirect:/registroAguas";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        RegistroAgua registroAgua = registroAguaService.buscarPorId(id).get();
        model.addAttribute("registroAgua", registroAgua);
        return "registroAgua/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        RegistroAgua registroAgua = registroAguaService.buscarPorId(id).get();
        model.addAttribute("derechoAguas", derechoAguaService.obtenerTodos());
        model.addAttribute("registroAgua", registroAgua);
        return "registroAgua/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        RegistroAgua registroAgua = registroAguaService.buscarPorId(id).get();
        model.addAttribute("registroAgua", registroAgua);
        return "registroAgua/delete";
    }

    @PostMapping("/delete")
    public String delete(RegistroAgua registroAgua, RedirectAttributes attributes){
        registroAguaService.eliminarPorId(registroAgua.getId());
        attributes.addFlashAttribute("msg", "Registro eliminado correrctamente");
        return "redirect:/registroAguas";
    }
}
