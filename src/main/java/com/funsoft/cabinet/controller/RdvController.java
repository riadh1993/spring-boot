package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.model.Client;
import com.funsoft.cabinet.model.Medecin;
import com.funsoft.cabinet.model.Rv;
import com.funsoft.cabinet.repository.ClientRepository;
import com.funsoft.cabinet.repository.MedecinRepository;
import com.funsoft.cabinet.repository.RvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class RdvController {
    @Autowired
    RvRepository agent;
    @Autowired
    ClientRepository agentclient;
    @Autowired
    MedecinRepository agentmed;

    @RequestMapping(value = "/rdvs/add",method = RequestMethod.GET)
    public ModelAndView add_rdv(){
        List<Client> clients = (List<Client>) agentclient.findAll();
        List<Medecin> meds = (List<Medecin>) agentmed.findAll();
        ModelAndView model = new ModelAndView();
        Rv rdv = new Rv();
        model.addObject("meds",meds);
        model.addObject("clients",clients);
        model.addObject("rdvForm",rdv);
        model.setViewName("Rv_Form");
        return model;
    }
    @RequestMapping(value = "/rdvs/save",method = RequestMethod.POST)
    public String save_rdv(@ModelAttribute("rdvForm") Rv rdv){
        agent.save(rdv);
        return "Rdv ajouté,Good!!";
    }
}













