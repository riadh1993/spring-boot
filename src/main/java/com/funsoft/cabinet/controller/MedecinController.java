package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.model.Medecin;
import com.funsoft.cabinet.model.Recherche;
import com.funsoft.cabinet.repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class MedecinController {
    @Autowired
    MedecinRepository agent;
    @RequestMapping(value="/medecins/add",method = RequestMethod.GET)
    public ModelAndView add_med(){
        ModelAndView model = new ModelAndView();
        Medecin med = new Medecin();
        model.addObject("medForm",med);
        model.setViewName("Medecin_Form");
        return model;
    }
    @RequestMapping(value="/medecins/save",method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("medForm") Medecin med){
        agent.save(med);
        return new ModelAndView(("redirect:/medecins/list"));
    }

    @RequestMapping(value="/medecins/list",method = RequestMethod.GET)
    public ModelAndView list_med(){
        List<Medecin> meds = (List<Medecin>) agent.findAll();
        ModelAndView model = new ModelAndView();
        model.addObject("meds",meds);
        model.setViewName("mes_medecins");
        return model;

    }
    @RequestMapping(value="/medecins/find",method = RequestMethod.GET)
    public ModelAndView find_medecins(){
        Recherche res = new Recherche();
        ModelAndView model = new ModelAndView();
        model.addObject("resForm",res);
        model.setViewName("Find_Medecin");
        return model;
    }
    @RequestMapping(value="/medecins/recherche",method = RequestMethod.POST)
public ModelAndView recherche_medecin(@ModelAttribute("resForm") Recherche res){
        //recherche des medecins par specialité (repository)
        List<Medecin> lmeds = agent.findBySpecialite(res.getSpecialite());
        //charger la liste de votre model
        res.setMeds(lmeds);
        ModelAndView model = new ModelAndView();
        model.addObject("resForm",res);
        model.setViewName("Find_Medecin");
        return model;
    }
@RequestMapping(value="/medecins/advancedfind",method = RequestMethod.GET)
public ModelAndView advancedfind_medecins(){
        Recherche res = new Recherche();
    ModelAndView model = new ModelAndView();

    model.addObject("resForm",res);
    model.setViewName("Advanced_Find_Medecin");
    return model;
}
    @RequestMapping(value="/medecins/rechercheavancee",method = RequestMethod.POST)
    public ModelAndView rechercheavancee_medecin(@ModelAttribute("resForm") Recherche res){
        List<Medecin> lmeds = agent.Search(res.getSpecialite(),"%"+res.getPseudo()+"%");
        res.setMeds(lmeds);
        ModelAndView model = new ModelAndView();
        model.addObject("resForm",res);
        model.setViewName("Advanced_Find_Medecin");
        return model;
    }
}














