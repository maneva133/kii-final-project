package mk.ukim.finki.labb1.service.application;

import mk.ukim.finki.labb1.dto.CategoryCountDTO;
import mk.ukim.finki.labb1.dto.CreateStayDto;
import mk.ukim.finki.labb1.dto.DisplayStayDto;

import java.util.List;
import java.util.Optional;

public interface StayApplicationService {

    Optional<DisplayStayDto> update(Long id, CreateStayDto stayDto) ;

    Optional<DisplayStayDto> save(CreateStayDto stayDto);

    Optional<DisplayStayDto> findById(Long id);

    List<DisplayStayDto> findAll();

    void deleteById(Long id);
    List<CategoryCountDTO> countPerCategory();

}
