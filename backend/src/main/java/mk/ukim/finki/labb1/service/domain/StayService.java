package mk.ukim.finki.labb1.service.domain;

import mk.ukim.finki.labb1.dto.CategoryCountDTO;
import mk.ukim.finki.labb1.dto.GetAllStaysDto;
import mk.ukim.finki.labb1.model.domen.Stay;
import mk.ukim.finki.labb1.model.enumeration.Category;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StayService {
    List<Stay> findAll();

    Optional<Stay> findById(Long id);

    Optional<Stay> update(Long id, Stay product);

    Optional<Stay> save(Stay product);

    void deleteById(Long id);
    List<CategoryCountDTO> countPerCategory();
    void refreshMaterializedView();

    List<GetAllStaysDto> getAllStays();



}
