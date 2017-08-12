package org.mum.edu.ea.controller;

import org.mum.edu.ea.domain.Category;
import org.mum.edu.ea.domain.Position;
import org.mum.edu.ea.domain.PositionCategory;
import org.mum.edu.ea.domain.PositionStatus;
import org.mum.edu.ea.service.IPostJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * Created by Zamuna on 8/11/2017.
 */
@Controller
@RequestMapping("/jobPost")

public class PostJobController {
    @Autowired
    IPostJobService jobService;

    @RequestMapping(value = "/addPosition",method = RequestMethod.POST)
    public Position postJob(Position position, Principal principal,Model model){
        position.setStatus(PositionStatus.ACTIVATE);
        PositionCategory positionCategory = new PositionCategory();
        positionCategory.setType(Category.IT);
        position.setCategory(positionCategory);
        return jobService.createPosition(position);
    }
    @RequestMapping(value = "/addPosition",method = RequestMethod.GET)
    public String postJobForm(Model model)
    {
        System.out.println(java.util.Arrays.asList(Category.values()));
        model.addAttribute("categories",Category.values());
        return "postJob";
    }

    @RequestMapping(value = "/getAllPosition",method = RequestMethod.GET)
    public List<Position> getAll(){
        return jobService.getAllPosition();
    }

    @RequestMapping(value = "/getPosition",method = RequestMethod.GET)
    public Position getOne(Long id){
        return jobService.getPosition(id);
    }

    @RequestMapping(value = "/updatePosition",method = RequestMethod.POST)
    public Position updatePosition(Position position){
        return jobService.updatePosition(position);
    }

    @RequestMapping(value = "/deletePosition",method = RequestMethod.DELETE)
    public void deletePosition(Long id,Position position){
        jobService.deletePosition(id,position);
    }

}
