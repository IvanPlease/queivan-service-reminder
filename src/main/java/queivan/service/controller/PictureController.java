package queivan.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/picture")
@RequiredArgsConstructor
public class PictureController {

    @GetMapping("/check")
    public String deployCheck(){
        return String.format("%s check succeeded", this.getClass().getSimpleName());
    }

}