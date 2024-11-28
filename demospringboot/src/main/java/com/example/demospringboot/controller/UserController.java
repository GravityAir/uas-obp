package com.example.demospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demospringboot.service.AdminService;
import com.example.demospringboot.service.CustomerService;
import com.example.demospringboot.service.KurirService;
import com.example.demospringboot.service.PengirimanService;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demospringboot.entity.Admin;
import com.example.demospringboot.entity.Customer;
import com.example.demospringboot.entity.Kurir;
import com.example.demospringboot.entity.Pengiriman;

import org.springframework.ui.Model;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private AdminService adminService;

    @Autowired 
    private CustomerService customerService;

    @Autowired
    private KurirService kurirService;

    @Autowired
    private PengirimanService pengirimanService;

    @GetMapping(value={"/admin", "/admin/"})
    public String adminPage(Model model){
        List<Admin> userList = adminService.getAllUsers();
        model.addAttribute("userList", userList);
        model.addAttribute("userInfo", new Admin());
		return "admin";
	}
    
    @GetMapping(value={"/customer", "/customer/"})
    public String customerPage(Model model){
        List<Customer> userList = customerService.getAllUsers();
        model.addAttribute("userList", userList);
        model.addAttribute("userInfo", new Customer());
		return "customer";
	}

    @GetMapping(value={"/kurir", "/kurir/"})
    public String kurirPage(Model model){
        List<Kurir> userList = kurirService.getAllUsers();
        model.addAttribute("userList", userList);
        model.addAttribute("userInfo", new Kurir());
		return "kurir";
	}

    @GetMapping(value={"/pengiriman", "/pengiriman/"})
    public String pengirimanPage(Model model){
        List<Pengiriman> userList = pengirimanService.getAllUsers();
        model.addAttribute("userList", userList);
        model.addAttribute("userInfo", new Pengiriman());
		return "pengiriman";
	}

    @GetMapping("/admin/{id}")
    public String adminGetRec(Model model, @PathVariable("id") int id){
        List<Admin> userList = adminService.getAllUsers();
        Admin userRec = adminService.getUserById(id);
        model.addAttribute("userList", userList);
		model.addAttribute("userRec", userRec);
		return "admin";
	}

    @GetMapping("/customer/{id}")
    public String customerGetRec(Model model, @PathVariable("id") int id){
        List<Customer> userList = customerService.getAllUsers();
        Customer userRec = customerService.getUserById(id);
        model.addAttribute("userList", userList);
		model.addAttribute("userRec", userRec);
		return "customer";
	}

    @GetMapping("/kurir/{id}")
    public String kurirGetRec(Model model, @PathVariable("id") int id){
        List<Kurir> userList = kurirService.getAllUsers();
        Kurir userRec = kurirService.getUserById(id);
        model.addAttribute("userList", userList);
		model.addAttribute("userRec", userRec);
		return "kurir";
	}

    @GetMapping("/pengiriman/{id}")
    public String pengirimanGetRec(Model model, @PathVariable("id") int id){
        List<Pengiriman> userList = pengirimanService.getAllUsers();
        Pengiriman userRec = pengirimanService.getUserById(id);
        model.addAttribute("userList", userList);
		model.addAttribute("userRec", userRec);
		return "pengiriman";
	}

    @PostMapping( value={"/admin/submit/", "/admin/submit/{id}"}, params={"add"})
    public String adminAdd(Model model, @ModelAttribute("userInfo") Admin userInfo){
        userInfo.setUserId(0);
        @SuppressWarnings("unused")
        Admin adm = adminService.addUser(userInfo);
        List<Admin> userList = adminService.getAllUsers();
        model.addAttribute("userList", userList);
        return "redirect:/admin";
    }

    @PostMapping( value={"/customer/submit/", "/customer/submit/{id}"}, params={"add"})
    public String customerAdd(Model model, @ModelAttribute("userInfo") Customer userInfo){
        userInfo.setUserId(0);
        @SuppressWarnings("unused")
        Customer cust = customerService.addUser(userInfo);
        List<Customer> userList = customerService.getAllUsers();
        model.addAttribute("userList", userList);
        model.addAttribute("successMessage", "Admin berhasil didaftarkan!");
        return "redirect:/customer";
    }

    @PostMapping( value={"/kurir/submit/", "/kurir/submit/{id}"}, params={"add"})
    public String kurirAdd(Model model, @ModelAttribute("userInfo") Kurir userInfo){
        userInfo.setUserId(0);
        @SuppressWarnings("unused")
        Kurir kurir = kurirService.addUser(userInfo);
        List<Kurir> userList = kurirService.getAllUsers();
        model.addAttribute("userList", userList);
        return "redirect:/kurir";
    }

    @PostMapping( value={"/pengiriman/submit/", "/pengiriman/submit/{id}"}, params={"add"})
    public String pengirimanAdd(Model model, @ModelAttribute("userInfo") Pengiriman userInfo){
        userInfo.setUserId(0);
        @SuppressWarnings("unused")
        Pengiriman pengiriman = pengirimanService.addUser(userInfo);
        List<Pengiriman> userList = pengirimanService.getAllUsers();
        model.addAttribute("userList", userList);
        return "redirect:/pengiriman";
    }

    @PostMapping( value="/admin/submit/{id}", params={"edit"})
    public String adminEdit(Model model, @ModelAttribute("userInfo") Admin userInfo, @PathVariable("id") int id){
        @SuppressWarnings("unused")
        Admin adm = adminService.updateUser(id,userInfo);
        List<Admin> userRec = adminService.getAllUsers();
        model.addAttribute("userList", userRec);
		return "redirect:/admin";
	}

    @PostMapping( value="/customer/submit/{id}", params={"edit"})
    public String customerEdit(Model model, @ModelAttribute("userInfo") Customer userInfo, @PathVariable("id") int id){
        @SuppressWarnings("unused")
        Customer cust = customerService.updateUser(id,userInfo);
        List<Customer> userRec = customerService.getAllUsers();
        model.addAttribute("userList", userRec);
		return "redirect:/customer";
	}

    @PostMapping( value="/kurir/submit/{id}", params={"edit"})
    public String kurirEdit(Model model, @ModelAttribute("userInfo") Kurir userInfo, @PathVariable("id") int id){
        @SuppressWarnings("unused")
        Kurir kur = kurirService.updateUser(id,userInfo);
        List<Kurir> userRec = kurirService.getAllUsers();
        model.addAttribute("userList", userRec);
		return "redirect:/kurir";
	}

    @PostMapping( value="/pengiriman/submit/{id}", params={"edit"})
    public String pengirimanEdit(Model model, @ModelAttribute("userInfo") Pengiriman userInfo, @PathVariable("id") int id){
        @SuppressWarnings("unused")
        Pengiriman adm = pengirimanService.updateUser(id,userInfo);
        List<Pengiriman> userRec = pengirimanService.getAllUsers();
        model.addAttribute("userList", userRec);
		return "redirect:/pengiriman";
	}

    @PostMapping( value="/admin/submit/{id}", params={"delete"})
    public String adminDelete(@PathVariable("id") int id){
        adminService.deleteUser(id);
        return "redirect:/admin";
	}

    @PostMapping( value="/customer/submit/{id}", params={"delete"})
    public String customerDelete(@PathVariable("id") int id){
        customerService.deleteUser(id);
        return "redirect:/customer";
	}

    @PostMapping( value="/kurir/submit/{id}", params={"delete"})
    public String kurirDelete(@PathVariable("id") int id){
        customerService.deleteUser(id);
        return "redirect:/kurir";
	}

    @PostMapping( value="/pengiriman/submit/{id}", params={"delete"})
    public String pengirimanDelete(@PathVariable("id") int id){
        pengirimanService.deleteUser(id);
        return "redirect:/pengiriman";
	}
}
