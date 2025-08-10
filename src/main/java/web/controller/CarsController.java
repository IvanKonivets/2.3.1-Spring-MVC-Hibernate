package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarsController {

    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(required = false) Integer count, Model model) {
        int limit = (count == null) ? Integer.MAX_VALUE : count;
        model.addAttribute("cars",  carService.getCars(limit));
        return "cars";
    }
}
