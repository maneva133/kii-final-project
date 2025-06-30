package mk.ukim.finki.labb1.web;

import io.swagger.v3.oas.annotations.Operation;
import mk.ukim.finki.labb1.dto.CreateGuestDto;
import mk.ukim.finki.labb1.dto.CreateHostDto;
import mk.ukim.finki.labb1.dto.DisplayGuestDto;
import mk.ukim.finki.labb1.service.application.GuestServiceApplicationService;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    public final GuestServiceApplicationService guestService;

    public GuestController(GuestServiceApplicationService guestService) {
        this.guestService = guestService;
    }

    @Operation(summary = "List all Guests", description = "Listing all guests")
    @GetMapping
    public List<DisplayGuestDto> findAll() {
        return guestService.findAll();
    }

    @Operation(summary = "Find guest by Id", description = "Finding a guest by its id")
    @GetMapping("/{id}")
    public ResponseEntity<DisplayGuestDto> findById(@PathVariable Long id) {
        return guestService.findById(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Guest add", description = "Creating a new guest")
    @PostMapping("/add")
    public ResponseEntity<DisplayGuestDto> save(@RequestBody CreateGuestDto guestDto) {
        return guestService.save(guestDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Guest edit", description = "Editing an existing guest")

    @PutMapping("/update/{id}")
    public ResponseEntity<DisplayGuestDto> update(@PathVariable Long id, @RequestBody CreateGuestDto guestDto) {
        return guestService.update(id, guestDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Guest delete", description = "Deleting a guest")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (guestService.findById(id).isPresent()) {
            guestService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Adding a host to e guest", description = "Adding a host to a guest")
    @PostMapping("/addHost/{id}")
    public ResponseEntity<DisplayGuestDto> addHost(@PathVariable Long id, @RequestBody CreateHostDto hostDto) {
        return guestService.addHost(id, hostDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
