package ru.kpfu.itis.bagaviev.util;

import com.cloudinary.Cloudinary;

import java.util.HashMap;
import java.util.Map;

public class CloudinaryUtil {

    private static Cloudinary cloudinary;

    private CloudinaryUtil() { }

    public static Cloudinary getCloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "doaetvccv");
        config.put("api_key", "955375793197148");
        config.put("api_secret", "W2BQCAEMC_10bNiapPXqVSFbf7w");
        if (cloudinary == null) {
            cloudinary = new Cloudinary(config);
        }
        return cloudinary;
    }

}
