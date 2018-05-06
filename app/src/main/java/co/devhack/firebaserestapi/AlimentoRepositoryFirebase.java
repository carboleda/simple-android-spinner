package co.devhack.firebaserestapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by krlosf on 5/05/18.
 */

public class AlimentoRepositoryFirebase implements AlimentoRepository {

    //RestAdapter
    interface AlimentoService {
        @GET("alimentos.json")
        Call<List<Alimento>> getAll();
    }

    @Override
    public void getAllAlimentos(final Callback<List<Alimento>> callback) {
        try {
            Retrofit retrofit = RetrofitSingleton.getInstance();
            AlimentoService alimentoService = retrofit.create(AlimentoService.class);

            Call<List<Alimento>> call = alimentoService.getAll();
            //Consumimos el api pidiendole a Retrofit que cree un hilo para el request
            /*call.enqueue(new retrofit2.Callback<List<Alimento>>() {

                @Override
                public void onResponse(Call<List<Alimento>> call, Response<List<Alimento>> response) {
                    //Llamamo el callback nuestro pasando la lista de alimentos
                    if(response.isSuccessful()) {
                        callback.success(response.body());
                    }
                }

                @Override
                public void onFailure(Call<List<Alimento>> call, Throwable t) {
                    //Llamamo el callback nuestro pasando el error generado
                    callback.error(new Exception(t));
                }
            });*/
            Response<List<Alimento>> response = call.execute();
            callback.success(response.body());
        } catch (Exception e) {
            callback.error(e);
        }
    }

}
