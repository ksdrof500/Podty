package podcast.com.br.podtche.view;

import java.util.List;

import podcast.com.br.podtche.model.DefaultResponse;
import podcast.com.br.podtche.model.Podty;


/**
 * Created by gholz on 3/5/16.
 */
public interface HomeView {
    void displayHome(DefaultResponse<List<Podty>> podtyList);
}
