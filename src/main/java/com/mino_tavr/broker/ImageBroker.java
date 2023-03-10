package com.mino_tavr.broker;

import lombok.Getter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


@Getter
@Component
public class ImageBroker {
    private final byte[] dummyImageModelPreview;
    public ImageBroker() throws IOException {
        BufferedImage bImage = ImageIO.read(new ClassPathResource("images/dummy_model.png").getInputStream());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "png", bos);
        this.dummyImageModelPreview = bos.toByteArray();
    }
}
