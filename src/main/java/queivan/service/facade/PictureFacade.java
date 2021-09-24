package queivan.service.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import queivan.service.service.PictureService;

@Component
@RequiredArgsConstructor
public class PictureFacade {
    private final PictureService service;
}