package mk.ukim.finki.labb1.service.domain.impl;

import mk.ukim.finki.labb1.model.views.StaysPerHostView;
import mk.ukim.finki.labb1.repository.StaysPerHostViewRepository;
import mk.ukim.finki.labb1.service.domain.StaysPerHostViewService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StaysPerHostViewServiceImpl implements StaysPerHostViewService {
    private final StaysPerHostViewRepository staysPerHostViewRepository;

    public StaysPerHostViewServiceImpl(StaysPerHostViewRepository staysPerHostViewRepository) {
        this.staysPerHostViewRepository = staysPerHostViewRepository;
    }

    @Override
    public List<StaysPerHostView> getStaysPerHost() {
        staysPerHostViewRepository.refreshMaterializedView();
        return staysPerHostViewRepository.findAll();
    }
}
