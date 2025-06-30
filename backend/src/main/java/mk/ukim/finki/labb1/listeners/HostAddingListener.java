package mk.ukim.finki.labb1.listeners;

import mk.ukim.finki.labb1.events.HostAddingEvent;
import mk.ukim.finki.labb1.service.domain.HostsPerCountryService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HostAddingListener {
    private final HostsPerCountryService hostsPerCountryService;

    public HostAddingListener(HostsPerCountryService hostsPerCountryService) {
        this.hostsPerCountryService = hostsPerCountryService;
    }

    @EventListener
    public void onHostCreated(HostAddingEvent event) {
        this.hostsPerCountryService.refreshMaterializedView();
    }

}
