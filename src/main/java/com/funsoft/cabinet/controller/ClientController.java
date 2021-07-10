package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.model.Client;
import com.funsoft.cabinet.repository.ClientRepository;
import com.funsoft.cabinet.service.ClientService;
import com.funsoft.cabinet.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

//@Controller // controleur MVC ( une page web === HTML)
@RestController
public class ClientController {

    @Autowired
    ClientService agent;

    //http://localhost:8082/clinique
    /*@RequestMapping(value="/",method = RequestMethod.GET)
    public String Hello(){
        return("Welcome, it's your first spring boot project");
    }*/
    @RequestMapping(value="/",method = RequestMethod.GET)
    public ModelAndView Hello(){
        // Je suis au niveau d'un controleur, ce qui manque est le Model and Vue
        ModelAndView model = new ModelAndView();
        model.setViewName("index"); // spécifier la page web à retourner
        return(model);
    }

    @RequestMapping(value = "/addclient",method = RequestMethod.GET)
    public String test_ajout_clien(){
        Client c = new Client();
        c.setNom("Farhat");
        c.setPrenom("Mahran");
        agent.save_or_update(c);
        return "client ajouté :"+"\n"+c.toString();
    }

    @RequestMapping(value = "/clients/add",method = RequestMethod.GET)
    public ModelAndView ajouter_client(){
        ModelAndView model = new ModelAndView();
        Client c = new Client();
        model.addObject("clientForm",c);
        model.setViewName("Client_Form"); // nom de la page
        return (model);
    }

    @RequestMapping(value="/clients/save",method = RequestMethod.POST)
    public ModelAndView add_client(@Valid @ModelAttribute("clientForm") Client cl, BindingResult result,Model model){
        if (result.hasErrors()){
           return (new ModelAndView("/Client_Form"));
        }
        else{
        agent.save_or_update(cl);
        return (new ModelAndView("redirect:/clients/list"));}
    }

    @RequestMapping(value = "/clients/list",method = RequestMethod.GET)
    public ModelAndView list_clients(){
        List<Client> clients = (List<Client>) agent.consulter(); // récupérer les clients de la BD
        ModelAndView model = new ModelAndView();
        model.addObject("clients",clients); // ajouter la liste en tant qu'objet à votre model
        model.setViewName("mes_clients"); // indiquer le nom de la page
        return (model);

    }
    @RequestMapping(value="/clients/delete/{idc}",method = RequestMethod.GET)
    public ModelAndView delete_client(@PathVariable("idc") long idclient){
        agent.delete(idclient);
        return (new ModelAndView("redirect:/clients/list"));
    }
    @RequestMapping(value="/clients/update/{idc}",method = RequestMethod.GET)
    public ModelAndView edit_client(@PathVariable("idc") long idclient){
        Client cl = agent.findById(idclient);
        ModelAndView model = new ModelAndView();
        model.addObject("clientForm",cl);
        model.setViewName("Client_Edit");
        return (model);
    }

}














