package mk.ukim.finki.labb1.dto;

import mk.ukim.finki.labb1.model.domen.Country;
import mk.ukim.finki.labb1.model.domen.Guest;
import mk.ukim.finki.labb1.model.domen.Host;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayHostDto(Long id,String name, String surname, Long country) {

    public static DisplayHostDto from(Host host){
        return new DisplayHostDto(host.getId(),host.getName(),host.getSurname(),host.getCountry().getId());
    }

    public static List<DisplayHostDto> from(List<Host> hosts){
        return hosts.stream()
                .map(DisplayHostDto::from).collect(Collectors.toList());
    }



}
