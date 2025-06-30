package mk.ukim.finki.labb1.web;

import io.swagger.v3.oas.annotations.Operation;
import mk.ukim.finki.labb1.dto.CategoryCountDTO;
import mk.ukim.finki.labb1.dto.CreateStayDto;
import mk.ukim.finki.labb1.dto.DisplayStayDto;
import mk.ukim.finki.labb1.dto.GetAllStaysDto;
import mk.ukim.finki.labb1.model.views.StaysPerHostView;
import mk.ukim.finki.labb1.service.application.StayApplicationService;
import mk.ukim.finki.labb1.service.domain.StayService;
import mk.ukim.finki.labb1.service.domain.StaysPerHostViewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stay")
public class StayController
{
    private final StayService stayService;
    private final StayApplicationService stayApplicationService;
    private final StaysPerHostViewService staysPerHostViewService;

    public StayController(StayService stayService, StayApplicationService stayApplicationService, StaysPerHostViewService staysPerHostViewService) {
        this.stayService = stayService;
        this.stayApplicationService = stayApplicationService;
        this.staysPerHostViewService = staysPerHostViewService;
    }

    @Operation(summary = "Listing all Stays", description = "Listing all of the Stays in the DB")
    @GetMapping
    public List<DisplayStayDto> listAll(){
        return stayApplicationService.findAll();
    }


    @Operation(summary = "Finding stay by id", description = "Finding a stay with id")

    @GetMapping("/{id}")
    public ResponseEntity<DisplayStayDto> findById(@PathVariable Long id){
        return stayApplicationService.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // eager executing aka always executing
    }

    @Operation(summary = "Stay add", description = "Adding a new stay")

    @PostMapping("/add")
    public ResponseEntity<DisplayStayDto> save(@RequestBody CreateStayDto stay){
        return stayApplicationService.save(stay)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // lazy executing aka only when needed
    }

    @Operation(summary = "Edit stay", description = "Editing a stay")

    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayStayDto> update(@PathVariable Long id, @RequestBody CreateStayDto stay){
        return stayApplicationService.update(id,stay)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // koga e so lambda notFound().build() se executnuva samo koga Optiona vrakja empty

    }

    @Operation(summary = "Delete stay", description = "Deleting a stay")

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if(stayApplicationService.findById(id).isPresent()){
            stayApplicationService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/categories")
    public ResponseEntity<List<CategoryCountDTO>> categoryPerStay() {
        List<CategoryCountDTO> result = stayApplicationService.countPerCategory();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/by-host")
    public ResponseEntity<List<StaysPerHostView>> staysPerHost(){
        List<StaysPerHostView> result = staysPerHostViewService.getStaysPerHost();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAllStays")
    public ResponseEntity<List<GetAllStaysDto>> getAllStays(){
        return ResponseEntity.ok(stayService.getAllStays());
    }


//    http://localhost:8080/swagger-ui/index.html
}
