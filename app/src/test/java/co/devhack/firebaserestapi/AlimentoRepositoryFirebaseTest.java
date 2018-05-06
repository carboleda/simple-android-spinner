package co.devhack.firebaserestapi;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by krlosf on 5/05/18.
 */
public class AlimentoRepositoryFirebaseTest {
    @Test
    public void getAllAlimentos() throws Exception {
        AlimentoRepository alimentoRepository = new AlimentoRepositoryFirebase();
        alimentoRepository.getAllAlimentos(new Callback<List<Alimento>>() {
            @Override
            public void success(List<Alimento> result) {
                assertEquals(3, result.size());
            }

            @Override
            public void error(Exception error) {
                assertNull(error);
            }
        });
    }

}