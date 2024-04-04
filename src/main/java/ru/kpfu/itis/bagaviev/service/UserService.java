package ru.kpfu.itis.bagaviev.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.bagaviev.dto.UserRegisterDto;
import ru.kpfu.itis.bagaviev.model.User;
import ru.kpfu.itis.bagaviev.repositories.UserRepository;
import ru.kpfu.itis.bagaviev.util.PasswordEncryptUtil;

@Service
public class UserService {

    private final UserRepository repository;

    private static final String DEFAULT_USER_AVATAR = "https://www.mfp-law.com/wp-content/uploads/2021/06/Platzhalter-j.bunz_.jpg";

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    public boolean existsByPhone(String phone) {
        return repository.existsByPhone(phone);
    }

    public User getByEmailAndPassword(String email, String password) {
        return repository.findOneByEmailAndPassword(email, PasswordEncryptUtil.encrypt(password));
    }


    public void update(User user) {
        repository.saveAndFlush(user);
    }

    public void save(UserRegisterDto userRegisterDto) {
        repository.saveAndFlush(new User(
                userRegisterDto.getName(),
                userRegisterDto.getLastname(),
                userRegisterDto.getGender(),
                DEFAULT_USER_AVATAR,
                userRegisterDto.getPhone(),
                userRegisterDto.getEmail(),
                PasswordEncryptUtil.encrypt(userRegisterDto.getPassword())
        ));
    }
}
