package queivan.service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import queivan.service.mapper.PictureMapper;
import queivan.service.service.repository.PictureRepository;

@RequiredArgsConstructor
@Service
@Slf4j
public class PictureService {
    private final PictureRepository repository;
    private final PictureMapper mapper;
}
