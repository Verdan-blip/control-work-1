package ru.kpfu.itis.bagaviev.controller;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.bagaviev.model.User;
import ru.kpfu.itis.bagaviev.service.UserService;
import ru.kpfu.itis.bagaviev.util.CloudinaryUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Map;

@Controller
public class ProfileController {

    private final Cloudinary cloudinary = CloudinaryUtil.getCloudinary();
    public static final String FILE_PATH_PREFIX = "/tmp";
    public static final int DIRECTORIES_COUNT = 100;

    private final UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "profile")
    public String profile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user", authentication.getCredentials());
        return "profile";
    }

    @PostMapping(value = "upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String filename = Paths.get(file.getName()).getFileName().toString();
        File javaFile = new File(FILE_PATH_PREFIX + File.separator
                + filename.hashCode() % DIRECTORIES_COUNT + File.separator + filename);

        javaFile.getParentFile().mkdirs();
        javaFile.createNewFile();

        try (InputStream inputStream = file.getInputStream()) {
            try (FileOutputStream outputStream = new FileOutputStream(javaFile)) {
                byte[] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                outputStream.write(buffer);
            }
        }

        Map map = cloudinary.uploader().upload(javaFile, null);
        String url = (String) map.get("url");

        User user = (User) authentication.getCredentials();
        user.setAvatar(url);
        userService.update(user);

        return "redirect:/profile";
    }
}
