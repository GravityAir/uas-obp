package com.example.demospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.example.demospringboot.service.PengirimanService;
import com.example.demospringboot.entity.Pengiriman;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Controller
@RequestMapping("/pengiriman")
public class PengirimanController {

    @Autowired
    private PengirimanService pengirimanService;

    @GetMapping
    public String pengirimanPage(Model model) {
        List<Pengiriman> pengirimanList = pengirimanService.getAllPengiriman();
        model.addAttribute("pengirimanList", pengirimanList);
        model.addAttribute("pengirimanInfo", new Pengiriman());
        return "home";
    }

    @GetMapping("/pengiriman/{resi}")
    public String pengirimanGetRec(Model model, @PathVariable("resi") int resi) {
        List<Pengiriman> pengirimanList = pengirimanService.getAllPengiriman();
        Pengiriman pengirimanRec = pengirimanService.getPengirimanByResi(resi);
        model.addAttribute("pengirimanList", pengirimanList);
        model.addAttribute("pengirimanInfo", pengirimanRec);
        return "home";
    }

    @PostMapping(value = "/pengiriman/submit/", params = "add")
    public String pengirimanAdd(@ModelAttribute("pengirimanInfo") Pengiriman pengirimanInfo) {
        pengirimanInfo.setResi(0);
        pengirimanService.addPengiriman(pengirimanInfo);
        return "redirect:/home";
    }

    // Edit data pengiriman berdasarkan resi
    @PostMapping(value = "pengiriman/submit/{resi}", params = "edit")
    public String pengirimanEdit(@ModelAttribute("pengirimanInfo") Pengiriman pengirimanInfo,
            @PathVariable("resi") int resi) {
        pengirimanService.updatePengiriman(resi, pengirimanInfo);
        return "redirect:/home";
    }

    // Hapus data pengiriman berdasarkan resi
    @PostMapping(value = "/submit/{resi}", params = "delete")
    public String pengirimanDelete(@PathVariable("resi") int resi) {
        pengirimanService.deletePengiriman(resi);
        return "redirect:/home";
    }

    @PostMapping("/pengiriman/updateStatus/{resi}/")
    public String updateStatus(@PathVariable("resi") int resi) {
        Pengiriman pengiriman = pengirimanService.getPengirimanByResi(resi);
        if (pengiriman != null) {
            pengiriman.setStatus("Sedang Dikirim");
            pengirimanService.updatePengiriman(resi, pengiriman);
        }
        return "redirect:/kurirDashboard";
    }
}
