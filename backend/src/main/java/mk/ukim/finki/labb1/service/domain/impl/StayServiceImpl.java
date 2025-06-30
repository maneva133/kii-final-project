package mk.ukim.finki.labb1.service.domain.impl;

import mk.ukim.finki.labb1.dto.CategoryCountDTO;
import mk.ukim.finki.labb1.dto.GetAllStaysDto;
import mk.ukim.finki.labb1.model.domen.Stay;
import mk.ukim.finki.labb1.repository.StayRepository;
import mk.ukim.finki.labb1.repository.StaysPerHostViewRepository;
import mk.ukim.finki.labb1.service.domain.StayService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StayServiceImpl implements StayService {
    private final StayRepository stayRepository;
    private final StaysPerHostViewRepository staysPerHostViewRepository;

    public StayServiceImpl(StayRepository stayRepository, StaysPerHostViewRepository staysPerHostViewRepository) {
        this.stayRepository = stayRepository;
        this.staysPerHostViewRepository = staysPerHostViewRepository;
    }

    @Override
    public List<Stay> findAll() {
        return stayRepository.findAll();
    }

    @Override
    public Optional<Stay> findById(Long id) {
        return stayRepository.findById(id);
    }

    @Override
    public Optional<Stay> update(Long id, Stay stay) {
        if (stayRepository.findById(id).isPresent()) {
            Stay stay1 = stayRepository.findById(id).get();
            stay1.setCategory(stay.getCategory());
            stay1.setHost(stay.getHost());
            stay1.setNumRooms(stay.getNumRooms());
            stay1.setName(stay.getName());
            stay1.setAvailable(stay.isAvailable());
            stayRepository.save(stay1);
            return Optional.of(stay1);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Stay> save(Stay product) {
        return Optional.of(stayRepository.save(product));
    }

    @Override
    public void deleteById(Long id) {
        if (stayRepository.findById(id).isPresent()) {
            stayRepository.deleteById(id);
        }
    }

    @Override
    public List<CategoryCountDTO> countPerCategory() {
        Map<String, Integer> map = new HashMap<>();
        List<Stay> stays = stayRepository.findAll();

        for (Stay stay : stays) {
            String categoryName = stay.getCategory().name();
            map.put(categoryName, map.getOrDefault(categoryName, 0) + 1);
        }

        List<CategoryCountDTO> dtoList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            dtoList.add(new CategoryCountDTO(entry.getKey(), entry.getValue()));
        }

        return dtoList;
    }

    @Override
    public void refreshMaterializedView() {
        staysPerHostViewRepository.refreshMaterializedView();
    }

    @Override
    public List<GetAllStaysDto> getAllStays() {
        return stayRepository.findAll()
                .stream().map(GetAllStaysDto::from)
                .collect(Collectors.toList());
    }


}
