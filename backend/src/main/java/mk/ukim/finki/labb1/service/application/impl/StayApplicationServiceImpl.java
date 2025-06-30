package mk.ukim.finki.labb1.service.application.impl;

import mk.ukim.finki.labb1.dto.CategoryCountDTO;
import mk.ukim.finki.labb1.dto.CreateStayDto;
import mk.ukim.finki.labb1.dto.DisplayStayDto;
import mk.ukim.finki.labb1.repository.HostRepository;
import mk.ukim.finki.labb1.service.application.StayApplicationService;
import mk.ukim.finki.labb1.service.domain.StayService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StayApplicationServiceImpl implements StayApplicationService {
    private final StayService stayService;

    private final HostRepository hostRepository;
    public StayApplicationServiceImpl(StayService stayService, HostRepository hostRepository) {
        this.stayService = stayService;
        this.hostRepository = hostRepository;
    }

    @Override
    public Optional<DisplayStayDto> update(Long id, CreateStayDto stayDto) {
        return stayService.update(id,
                stayDto.toStay(
                        stayDto.category(),
                        hostRepository.findById(stayDto.hostId()).get()
                )
        ).map(DisplayStayDto::from);
    }

    @Override
    public Optional<DisplayStayDto> save(CreateStayDto stayDto) {
        return stayService.save(stayDto.toStay(stayDto.category(),hostRepository.findById(stayDto.hostId()).get()))
                .map(DisplayStayDto::from);
    }

    @Override
    public Optional<DisplayStayDto> findById(Long id) {
        return stayService.findById(id).map(DisplayStayDto::from);
    }

    @Override
    public List<DisplayStayDto> findAll() {
        return stayService.findAll()
                .stream().map(DisplayStayDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        stayService.deleteById(id);
    }

    @Override
    public List<CategoryCountDTO> countPerCategory() {
        return stayService.countPerCategory();
    }
}
