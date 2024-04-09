package hanyang.eos.eosBackend.Controller;

import hanyang.eos.eosBackend.Dto.User;
import hanyang.eos.eosBackend.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
//@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/")
    public User getUserByKakaoId(@RequestHeader("kakaoId") Long kakaoId) {
        User user = userRepository.findByKakaoId(kakaoId);

        if (user == null) {
            User newUser = new User();
            newUser.setKakaoId(kakaoId);
            userRepository.save(newUser);
            User result = userRepository.findByKakaoId(kakaoId);
            return result;
        } else {
            return user;
        }
    }
}
