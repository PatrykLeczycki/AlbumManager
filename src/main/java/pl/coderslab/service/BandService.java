package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Band;
import pl.coderslab.repository.BandRepository;

@Service
@RequiredArgsConstructor
public class BandService {

    private final BandRepository bandRepository;

    public void addBand(Band band){
        bandRepository.save(band);
    }
}
