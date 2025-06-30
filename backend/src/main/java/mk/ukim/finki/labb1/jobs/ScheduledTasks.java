package mk.ukim.finki.labb1.jobs;

import mk.ukim.finki.labb1.service.domain.StayService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private final StayService stayService;

    public ScheduledTasks(StayService stayService) {
        this.stayService = stayService;
    }

    @Scheduled(cron = "0 * * * * *")
    public void refreshMaterializedView() {
        this.stayService.refreshMaterializedView();
    }
}
