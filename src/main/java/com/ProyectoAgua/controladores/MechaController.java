package com.ProyectoAgua.controladores;

import com.ProyectoAgua.modelos.DerechoAgua;
import com.ProyectoAgua.modelos.Mecha;
import com.ProyectoAgua.servicios.interfaces.IDerechoAguaService;
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

    @Autowired
    private IDerechoAguaService derechoAguaService;

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
    public String create(Model model) {
        List<DerechoAgua> derechoAguas = derechoAguaService.obtenerTodos();
        model.addAttribute("mecha", new Mecha());
        model.addAttribute("derechoAguas", derechoAguas);
        return "mecha/create";
    }


    @PostMapping("/save")
    public String save(@RequestParam(required = false) Integer id,
                       @RequestParam Integer derechoAgua,
                       @RequestParam String cantidadMecha,
                       RedirectAttributes attributes) {
        DerechoAgua newderechoAgua = derechoAguaService.buscarPorId(derechoAgua).orElse(null);

        if (newderechoAgua != null) {
            Mecha newMecha;

            if (id != null) {
                newMecha = mechaService.buscarPorId(id).orElse(new Mecha());
                newMecha.setDerechoAgua(newderechoAgua);
                newMecha.setCantidadMecha(cantidadMecha);
                mechaService.crearOEditar(newMecha);
                attributes.addFlashAttribute("msg", "Mecha actualizada exitosamente");
            } else {
                newMecha = new Mecha();
                newMecha.setDerechoAgua(newderechoAgua);
                newMecha.setCantidadMecha(cantidadMecha);
                mechaService.crearOEditar(newMecha);
                attributes.addFlashAttribute("msg", "Mecha creada exitosamente");
            }
        }
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
