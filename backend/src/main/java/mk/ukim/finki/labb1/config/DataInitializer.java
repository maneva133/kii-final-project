package mk.ukim.finki.labb1.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.labb1.model.domen.Country;
import mk.ukim.finki.labb1.model.domen.Host;
import mk.ukim.finki.labb1.model.domen.Stay;
import mk.ukim.finki.labb1.model.domen.User;
import mk.ukim.finki.labb1.model.enumeration.Category;
import mk.ukim.finki.labb1.model.enumeration.Role;
import mk.ukim.finki.labb1.repository.CountryRepository;
import mk.ukim.finki.labb1.repository.HostRepository;
import mk.ukim.finki.labb1.repository.StayRepository;
import mk.ukim.finki.labb1.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final CountryRepository countryRepository;
    private final HostRepository hostRepository;
    private final StayRepository stayRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(CountryRepository countryRepository,
                           HostRepository hostRepository,
                           StayRepository stayRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.countryRepository = countryRepository;
        this.hostRepository = hostRepository;
        this.stayRepository = stayRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //@PostConstruct
    public void initData() {
        // Initialize countries
        Country macedonia = new Country();
        macedonia.setName("Macedonia");
        macedonia.setContinent("Europe");
        countryRepository.save(macedonia);

        Country france = new Country();
        france.setName("France");
        france.setContinent("Europe");
        countryRepository.save(france);

        Country japan = new Country();
        japan.setName("Japan");
        japan.setContinent("Asia");
        countryRepository.save(japan);

        // Initialize hosts
        Host host1 = new Host();
        host1.setName("John");
        host1.setSurname("Doe");
        host1.setCountry(macedonia);
        hostRepository.save(host1);

        Host host2 = new Host();
        host2.setName("Marie");
        host2.setSurname("Curie");
        host2.setCountry(france);
        hostRepository.save(host2);

        Host host3 = new Host();
        host3.setName("Takeshi");
        host3.setSurname("Kitano");
        host3.setCountry(japan);
        hostRepository.save(host3);

        // Initialize stays
        Stay stay1 = new Stay();
        stay1.setName("Mountain Retreat");
        stay1.setCategory(Category.HOTEL);
        stay1.setHost(host1);
        stay1.setNumRooms(3);
        stayRepository.save(stay1);

        Stay stay2 = new Stay();
        stay2.setName("Paris Luxury Apartment");
        stay2.setCategory(Category.APARTMENT);
        stay2.setHost(host2);
        stay2.setNumRooms(2);
        stayRepository.save(stay2);

        Stay stay3 = new Stay();
        stay3.setName("Tokyo City Hotel");
        stay3.setCategory(Category.HOTEL);
        stay3.setHost(host3);
        stay3.setNumRooms(10);
        stayRepository.save(stay3);

        Stay stay4 = new Stay();
        stay4.setName("Lakeview Cottage");
        stay4.setCategory(Category.HOUSE);
        stay4.setHost(host1);
        stay4.setNumRooms(4);
        stayRepository.save(stay4);

        userRepository.save(new User(
                "user",
                passwordEncoder.encode("user"),
                "user",
                "user",
                Role.ROLE_USER
        ));

        userRepository.save(new User(
                "host",
                passwordEncoder.encode("host"),
                "host",
                "host",
                Role.ROLE_HOST
        ));

    }
}