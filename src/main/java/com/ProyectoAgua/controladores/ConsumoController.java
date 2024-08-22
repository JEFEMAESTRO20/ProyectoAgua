package com.ProyectoAgua.controladores;

import com.ProyectoAgua.modelos.Consumo;
import com.ProyectoAgua.servicios.interfaces.IConsumoService;
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
@RequestMapping("/consumos")
public class ConsumoController {
    @Autowired
    private IConsumoService consumoService;

    @Autowired
    private IDerechoAguaService derechoAguaService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1) -1; //si no esta seteado se asigna
        int pageSize = size.orElse(5); // tamaño de la pagina se asigna 5
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<Consumo> consumos = consumoService.buscarTodosPaginados(pageable);
        model.addAttribute("consumos", consumos);

        int totalPages = consumos.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute( "pageNumbers", pageNumbers);
        }

        return "consumo/index";
    }

    @GetMapping("/create")
    public String create(Model model)
    {
        model.addAttribute("derechoAgua", derechoAguaService.obtenerTodos());
        return "consumo/create";
    }

    @PostMapping("/save")
    public String save (Consumo consumo, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute(consumo);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un errог.");
            return "consumo/create";
        }

        consumoService.crearOEditar(consumo);
        attributes.addFlashAttribute("msg", "Consumo creado correctamente");
        return "redirect:/consumos";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        Consumo consumo = consumoService.buscarPorId(id).get();
        model.addAttribute("consumo", consumo);
        return "consumo/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Consumo consumo = consumoService.buscarPorId(id).get();
        model.addAttribute("consumo", consumo);
        return "consumo/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        Consumo consumo = consumoService.buscarPorId(id).get();
        model.addAttribute("consumo", consumo);
        return "consumo/delete";
    }

    @PostMapping("/delete")
    public String delete(Consumo consumo, RedirectAttributes attributes){
        consumoService.eliminarPorId(consumo.getId());
        attributes.addFlashAttribute("msg", "Consumo eliminado correrctamente");
        return "redirect:/consumos";
    }
}