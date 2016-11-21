package podcast.com.br.podtche.view;

import java.util.List;

import podcast.com.br.podtche.model.DefaultResponse;
import podcast.com.br.podtche.model.Episodes;
import podcast.com.br.podtche.model.Podty;

/**
 * Created by filipenunes on 31/10/16.
 */

public interface DetailView {
    void displayEpisodes(DefaultResponse<Podty> episodes);


}
