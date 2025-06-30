package mk.ukim.finki.labb1.web;

import io.swagger.v3.oas.annotations.Operation;
import mk.ukim.finki.labb1.dto.CreateHostDto;
import mk.ukim.finki.labb1.dto.DisplayHostDto;
import mk.ukim.finki.labb1.model.projections.HostProjection;
import mk.ukim.finki.labb1.model.views.HostsPerCountry;
import mk.ukim.finki.labb1.service.application.HostApplicationService;
import mk.ukim.finki.labb1.service.domain.HostService;
import mk.ukim.finki.labb1.service.domain.HostsPerCountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/host")
public class HostController {


    private final HostsPerCountryService hostsPerCountryService;
    private final HostApplicationService hostApplicationService;
    private final HostService hostService;

    public HostController(HostsPerCountryService hostsPerCountryService, HostApplicationService hostApplicationService, HostService hostService) {
        this.hostsPerCountryService = hostsPerCountryService;
        this.hostApplicationService = hostApplicationService;
        this.hostService = hostService;
    }

    @Operation(summary = "Listing all Hosts", description = "Listing all of the Hosts in the DB")
    @GetMapping
    public List<DisplayHostDto> listAll() {
        return hostApplicationService.findAll();
    }


    @Operation(summary = "Finding host by id", description = "Finding a host with id")
    @GetMapping("/{id}")
    public ResponseEntity<DisplayHostDto> findById(@PathVariable Long id) {
        return hostApplicationService.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // eager executing aka always executing
    }

    @Operation(summary = "Host add", description = "Adding a new host")
    @PostMapping("/add")
    public ResponseEntity<DisplayHostDto> save(@RequestBody CreateHostDto stay) {
        return hostApplicationService.save(stay)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // lazy executing aka only when needed
    }

    @Operation(summary = "Edit host", description = "Editing a host")
    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayHostDto> update(@PathVariable Long id, @RequestBody CreateHostDto hostDto) {
        return hostApplicationService.update(id, hostDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()); // koga e so lambda notFound().build() se executnuva samo koga Optiona vrakja empty

    }

    @Operation(summary = "Delete host", description = "Deleting a host")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (hostApplicationService.findById(id).isPresent()) {
            hostApplicationService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/by-country")
    public ResponseEntity<List<HostsPerCountry>> hostsPerCountry() {
        return ResponseEntity.ok(hostsPerCountryService.findAll());
    }

    @GetMapping("/names")
    public ResponseEntity<List<HostProjection>> takeHostsByProjections(){
        return ResponseEntity.ok(hostService.takeHostsByProjection());
    }

}
