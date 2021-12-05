package uz.ilhomjon.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.ilhomjon.viewmodel.models.User
import uz.ilhomjon.viewmodel.retrofit.ApiClient

class MyViewModel : ViewModel(){
    private var liveDouble = MutableLiveData<List<User>>()

    fun getUsers():LiveData<List<User>>{
        ApiClient.apiService.getUsers().enqueue(object : Callback<List<User>>{
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful){
                    liveDouble.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }
        })
        return liveDouble
    }

}