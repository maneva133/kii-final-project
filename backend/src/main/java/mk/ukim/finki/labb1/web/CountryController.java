package mk.ukim.finki.labb1.web;

import io.swagger.v3.oas.annotations.Operation;
import mk.ukim.finki.labb1.dto.CreateCountryDto;
import mk.ukim.finki.labb1.dto.DisplayCountryDto;
import mk.ukim.finki.labb1.model.domen.Country;
import mk.ukim.finki.labb1.service.application.CountryApplicationService;
import mk.ukim.finki.labb1.service.domain.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    private final CountryService countryService;
    private final CountryApplicationService countryApplicationService;

    public CountryController(CountryService countryService, CountryApplicationService countryApplicationService) {
        this.countryService = countryService;
        this.countryApplicationService = countryApplicationService;
    }

    @Operation(summary = "Listing all countries", description = "Listing all of the countries in the DB")
    @GetMapping
    public List<DisplayCountryDto> listAll(){
        return countryApplicationService.findAll();
    }


    @Operation(summary = "Finding country by id", description = "Finding a country with id")

    @GetMapping("/{id}")
    public ResponseEntity<DisplayCountryDto> findById(@PathVariable Long id){
        return countryApplicationService.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // eager executing aka always executing
    }

    @Operation(summary = "Country add", description = "Adding a new country")

    @PostMapping("/add")
    public ResponseEntity<DisplayCountryDto> save(@RequestBody CreateCountryDto country){
        return countryApplicationService.save(country)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // lazy executing aka only when needed
    }

    @Operation(summary = "Edit country", description = "Editing a country")

    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayCountryDto> update(@PathVariable Long id, @RequestBody CreateCountryDto country){
        return countryApplicationService.update(id,country)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // koga e so lambda notFound().build() se executnuva samo koga Optiona vrakja empty

    }

    @Operation(summary = "Delete country", description = "Deleting a country")

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if(countryService.findById(id).isPresent()){
            countryService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
