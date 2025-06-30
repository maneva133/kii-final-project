package mk.ukim.finki.labb1.events;
import lombok.Getter;
import mk.ukim.finki.labb1.model.domen.Host;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter

public class HostAddingEvent extends ApplicationEvent{
    public HostAddingEvent(Host source) {
        super(source);
    }
}
