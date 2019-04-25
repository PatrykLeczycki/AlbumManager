package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Artist;
import pl.coderslab.model.Band;
import pl.coderslab.repository.BandRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BandService {

    private final BandRepository bandRepository;

    public void addBand(Band band){
        bandRepository.save(band);
    }

    public List<Band> getAllBands(){
        return bandRepository.findAll();
    }

    public Band getBandById(Long id){
        Optional<Band> optionalBand = bandRepository.findById(id);

        return optionalBand.orElse(null);
    }

    public List<Band> getBandsByArtist(Artist artist){

        List<Band> allBands = getAllBands();

        List<Band> bandsByArtist = new ArrayList<>();

        for (Band band : allBands){
            if (band.getMembers().contains(artist))
                bandsByArtist.add(band);
        }

        return bandsByArtist;
    }

    public void deleteBand(Long id){
        bandRepository.deleteById(id);
    }
}
