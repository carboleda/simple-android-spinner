package co.devhack.firebaserestapi;

import java.util.List;

/**
 * Created by krlosf on 5/05/18.
 */

public interface AlimentoRepository {

    void getAllAlimentos(Callback<List<Alimento>> callback);

}
