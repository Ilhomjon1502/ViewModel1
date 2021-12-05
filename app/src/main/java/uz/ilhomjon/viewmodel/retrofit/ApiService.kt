package uz.ilhomjon.viewmodel.retrofit

import retrofit2.Call
import retrofit2.http.GET
import uz.ilhomjon.viewmodel.models.User

interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<User>>
}