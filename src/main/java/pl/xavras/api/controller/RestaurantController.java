package pl.xavras.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.xavras.api.dto.AddressDTO;
import pl.xavras.api.dto.CustomerDTO;
import pl.xavras.api.dto.OwnerDTO;
import pl.xavras.api.dto.RestaurantDTO;
import pl.xavras.api.dto.mapper.RestaurantMapper;
import pl.xavras.api.dto.mapper.StreetMapper;
import pl.xavras.business.RestaurantService;
import pl.xavras.business.StreetService;
import pl.xavras.domain.Address;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@AllArgsConstructor
@Slf4j
public class RestaurantController {

    public static final String RESTAURANT = "/restaurants";
    public static final String RESTAURANTS_BY_STREET = "/restaurants/street/{streetName}";
    private static final String RESTAURANT_BY_NAME = "/restaurants/show/{restaurantName}";
    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;

    @GetMapping(RESTAURANT)
    public String restaurants(Model model) {
        List<RestaurantDTO> allRestaurants = restaurantService.findAll().stream()
                .map(restaurantMapper::map).toList();
        model.addAttribute("restaurants", allRestaurants);
        return "restaurants";
    }

    @GetMapping(value = RESTAURANTS_BY_STREET)
    public String showRestaurantsByStreet(@PathVariable String streetName, Model model) {
        var restaurantsSet = restaurantService.findRestaurantsByStreetName(streetName).stream()
                .map(restaurantMapper::map).collect(Collectors.toSet());
        model.addAttribute("restaurants", restaurantsSet);
        model.addAttribute("street", streetName);
        return "restaurantsByStreet";
    }

    @GetMapping(RESTAURANT_BY_NAME)
    public String showRestaurantDetails(@PathVariable String restaurantName, Model model) {

        RestaurantDTO restaurantDetails = restaurantService.findByName(restaurantName)
                .map(restaurantMapper::map)
                .orElseThrow(() -> new RuntimeException("Restaurant with name [%s] doest not exists".formatted(restaurantName)));
        AddressDTO address = restaurantDetails.getAddress();
        OwnerDTO owner = restaurantDetails.getOwner();


        model.addAttribute("restaurant", restaurantDetails);
        model.addAttribute("address", address);
        model.addAttribute("owner", owner);

        return "restaurantDetails";
    }


}
