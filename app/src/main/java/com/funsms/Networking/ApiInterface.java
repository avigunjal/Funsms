package com.funsms.Networking;

import com.funsms.Model.Smsdata;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by AVI on 25-12-2017.
 */

public interface ApiInterface {

    @POST("smsdata.php")
    Call<Smsdata> SMSDATA_CALL(@Query("category") String category,@Query("lang") String lang);

}
